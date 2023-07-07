package ru.nechunaev.geocoderservice.configuration;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.Map;

@Configuration
public class WebClientConfiguration {

    public static final String DEFAULT_FORMAT = "json";
    private final YandexApiWebClientProperties properties;

    @Autowired
    public WebClientConfiguration(YandexApiWebClientProperties properties) {
        this.properties = properties;
    }


    @Bean
    public WebClient geocoderYandexClient() {
        final HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, properties.getConnectionTimeout())
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(properties.getReadTimeout()))
                            .addHandlerLast(new WriteTimeoutHandler(properties.getReadTimeout()));
                });
        final Map<String, String> defaultQueryParameters = Map.of(
                YandexWebClientParameterNames.API_KEY, properties.getApiKey(),
                YandexWebClientParameterNames.FORMAT, DEFAULT_FORMAT
        );
        return WebClient.builder()
                .baseUrl(properties.getBaseUrl())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(defaultQueryParameters)
                .filter(new LoggingWebClientFilter())
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
}
