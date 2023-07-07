package ru.nechunaev.geocoderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import ru.nechunaev.geocoderservice.configuration.YandexApiWebClientProperties;

@EnableConfigurationProperties(YandexApiWebClientProperties.class)
@SpringBootApplication
@EnableCaching
public class GeocoderServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(GeocoderServiceApplication.class, args);
	}

}
