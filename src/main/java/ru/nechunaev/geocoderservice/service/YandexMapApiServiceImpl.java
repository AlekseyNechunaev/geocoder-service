package ru.nechunaev.geocoderservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.nechunaev.geocoderservice.dto.yandex.YandexGeocoderResult;
import ru.nechunaev.geocoderservice.exception.YandexMapGeocoderClientException;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class YandexMapApiServiceImpl implements YandexMapApiService {

    private static final Logger log = LoggerFactory.getLogger(YandexMapApiServiceImpl.class);
    private final WebClient client;
    private final ObjectMapper mapper;

    @Autowired
    public YandexMapApiServiceImpl(WebClient client, ObjectMapper mapper) {
        this.client = client;
        this.mapper = mapper;
    }

    @Override
    public YandexGeocoderResult sendRequest(Map<String, Object> parameters) {
        final YandexGeocoderResult geocoderResult = client.get()
                .uri(uriBuilder ->
                        uriBuilder.queryParams(convertParametersToMultiMap(parameters))
                                .build())
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse -> clientResponse.bodyToMono(String.class)
                        .flatMap(error -> {
                                    logResponse(error);
                                    return Mono.error(
                                            new YandexMapGeocoderClientException("the request to the external " +
                                                    "system failed with an error"));
                                }
                        ))
                .bodyToMono(YandexGeocoderResult.class)
                .block();
        logResponse(geocoderResult);
        return geocoderResult;
    }

    private MultiValueMap<String, String> convertParametersToMultiMap(Map<String, Object> parameters) {
        final Map<String, List<String>> multiValueParameters = new HashMap<>(parameters.size());
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            var key = entry.getKey();
            var value = Collections.singletonList(parameters.get(key).toString());
            multiValueParameters.put(key, value);
        }
        return new LinkedMultiValueMap<>(multiValueParameters);
    }

    private void logResponse(Object response) {
        if (response == null) {
            log.info("response body is empty");
            return;
        }
        try {
            final String convertedResponse = mapper.writeValueAsString(response);
            log.info("response body {}", convertedResponse);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
