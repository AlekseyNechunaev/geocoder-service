package ru.nechunaev.geocoderservice.exception;

public class YandexMapGeocoderClientException extends RuntimeException {

    public YandexMapGeocoderClientException() {
    }

    public YandexMapGeocoderClientException(String message) {
        super(message);
    }

    public YandexMapGeocoderClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public YandexMapGeocoderClientException(Throwable cause) {
        super(cause);
    }
}
