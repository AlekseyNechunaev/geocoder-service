package ru.nechunaev.geocoderservice.configuration;

import com.google.maps.GeoApiContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class GoogleApiContextConfiguration {

    private final GoogleApiContextProperties properties;

    @Autowired
    public GoogleApiContextConfiguration(GoogleApiContextProperties properties) {
        this.properties = properties;
    }

    @Bean
    public GeoApiContext googleGeoApiContext() {
        return new GeoApiContext.Builder()
                .apiKey(properties.getApiKey())
                .connectTimeout(properties.getConnectionTimeout(), TimeUnit.SECONDS)
                .readTimeout(properties.getReadTimeout(), TimeUnit.SECONDS)
                .maxRetries(properties.getMaxRetries())
                .build();
    }
}
