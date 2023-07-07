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
import java.util.function.Predicate;

@Service
public class YandexMapApiServiceImpl implements YandexMapApiService {

    private static final Logger log = LoggerFactory.getLogger(YandexMapApiServiceImpl.class);
    private final WebClient client;
    private final ObjectMapper objectMapper;

    @Autowired
    public YandexMapApiServiceImpl(WebClient client, ObjectMapper objectMapper) {
        this.client = client;
        this.objectMapper = objectMapper;
    }

    @Override
    public YandexGeocoderResult sendRequest(Map<String, String> parameters) {
        final Predicate<HttpStatusCode> isErrorCode = httpStatusCode -> httpStatusCode.is4xxClientError() ||
                httpStatusCode.is5xxServerError();
        return client.get()
                .uri( uriBuilder ->
                        uriBuilder.queryParams(convertParametersToMultiMap(parameters))
                                .build())
                .retrieve()
                .onStatus(isErrorCode,
                        clientResponse -> {
                    logResponse(clientResponse);
                    return Mono.error(new YandexMapGeocoderClientException("An error occurred, the request ended " +
                            "with the status " + clientResponse.statusCode()));
                })
                .bodyToMono(YandexGeocoderResult.class)
                .doOnSuccess(this::logResponse)
                .block();
    }

    private MultiValueMap<String, String> convertParametersToMultiMap(Map<String, String> parameters) {
        final Map<String, List<String>> multiValueParameters = new HashMap<>(parameters.size());
        for (Map.Entry<String, String> entry: parameters.entrySet()) {
            var key = entry.getKey();
            var value = Collections.singletonList(parameters.get(key));
            multiValueParameters.put(key, value);
        }
        return new LinkedMultiValueMap<>(multiValueParameters);
    }

    private void logResponse(Object response) {
        String logObjectInfo;
        try {
            logObjectInfo = objectMapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        log.info("response {}", logObjectInfo);
    }
}
