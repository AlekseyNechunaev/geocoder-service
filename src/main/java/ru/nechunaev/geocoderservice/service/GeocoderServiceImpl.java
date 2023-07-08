package ru.nechunaev.geocoderservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nechunaev.geocoderservice.common.mapper.CoordinatesMapper;
import ru.nechunaev.geocoderservice.configuration.YandexApiWebClientProperties;
import ru.nechunaev.geocoderservice.configuration.YandexWebClientParameterNames;
import ru.nechunaev.geocoderservice.dto.AddressDto;
import ru.nechunaev.geocoderservice.dto.CoordinatesDto;
import ru.nechunaev.geocoderservice.dto.yandex.FeatureMember;
import ru.nechunaev.geocoderservice.dto.yandex.GeoObject;
import ru.nechunaev.geocoderservice.dto.yandex.YandexGeocoderResult;
import ru.nechunaev.geocoderservice.exception.ServiceException;

import java.util.List;
import java.util.Map;

@Service
public class GeocoderServiceImpl implements GeocoderService {
    private static final Logger log = LoggerFactory.getLogger(GeocoderServiceImpl.class);
    private static final String DEFAULT_FORMAT = "json";
    private static final int EXCEPTED_RESULT_COUNT = 1;
    private static final int LAT_LNG_EXCEPTED_SIZE = 2;
    private final YandexMapApiService yandexMapApiService;
    private final CoordinatesMapper coordinatesMapper;
    private final YandexApiWebClientProperties properties;

    @Autowired
    public GeocoderServiceImpl(YandexMapApiService yandexMapApiService,
                               CoordinatesMapper coordinatesMapper,
                               YandexApiWebClientProperties properties) {
        this.yandexMapApiService = yandexMapApiService;
        this.coordinatesMapper = coordinatesMapper;
        this.properties = properties;
    }

    @Override
    public AddressDto getAddressByCoordinates(CoordinatesDto coordinatesDto) {
        final String preparedCoordinates = coordinatesMapper.convertCoordinatesToString(coordinatesDto);
        final Map<String, Object> requestParameters = Map.of(
                YandexWebClientParameterNames.API_KEY, properties.getApiKey(),
                YandexWebClientParameterNames.FORMAT, DEFAULT_FORMAT,
                YandexWebClientParameterNames.GEOCODE, preparedCoordinates,
                YandexWebClientParameterNames.RESULTS_COUNT, EXCEPTED_RESULT_COUNT
        );
        YandexGeocoderResult result = yandexMapApiService.sendRequest(
                requestParameters
        );
        List<FeatureMember> geocodeResultObjects = result.getResponse()
                .getGeoObjectCollection().getFeatureMember();
        checkGeocodeResultIsNotEmpty(geocodeResultObjects);
        GeoObject currentGeoObject = geocodeResultObjects.get(0).getGeoObject();
        String address = currentGeoObject.getMetaDataProperty()
                .getGeocoderMetaData()
                .getText();
        final AddressDto addressDto = new AddressDto();
        addressDto.setAddress(address);
        return addressDto;
    }

    @Override
    public CoordinatesDto getCoordinatesByAddress(AddressDto addressDto) {
        final Map<String, Object> requestParameters = Map.of(
                YandexWebClientParameterNames.API_KEY, properties.getApiKey(),
                YandexWebClientParameterNames.FORMAT, DEFAULT_FORMAT,
                YandexWebClientParameterNames.GEOCODE, addressDto.getAddress(),
                YandexWebClientParameterNames.RESULTS_COUNT, EXCEPTED_RESULT_COUNT
        );
        YandexGeocoderResult result = yandexMapApiService.sendRequest(requestParameters);
        List<FeatureMember> geocodeResultObjects = result.getResponse()
                .getGeoObjectCollection()
                .getFeatureMember();
        checkGeocodeResultIsNotEmpty(geocodeResultObjects);
        FeatureMember currentGeoObject = geocodeResultObjects.get(0);
        String[] latLongPosition = currentGeoObject.getGeoObject()
                .getPoint()
                .getPos()
                .split(" ");
        int actualCoordinatesSize = latLongPosition.length;
        if (actualCoordinatesSize != LAT_LNG_EXCEPTED_SIZE) {
            log.error("the actual size of the coordinate array does not match the expected one");
            throw new ServiceException("Incorrect value of latitude, longitude parameters returned");
        }
        return coordinatesMapper.convertListCoordinatesToDto(latLongPosition);
    }

    private void checkGeocodeResultIsNotEmpty(List<FeatureMember> geocodeResultObjects) {
        if (geocodeResultObjects.isEmpty()) {
            log.error("No geocoding results found");
            throw new ServiceException("no geocoding result");
        }
    }
}
