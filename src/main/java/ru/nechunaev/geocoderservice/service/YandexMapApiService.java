package ru.nechunaev.geocoderservice.service;

import ru.nechunaev.geocoderservice.dto.yandex.YandexGeocoderResult;

import java.util.Map;

public interface YandexMapApiService {

    YandexGeocoderResult sendRequest(Map<String, Object> parameters);

}
