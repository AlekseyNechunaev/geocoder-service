package ru.nechunaev.geocoderservice.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

public class LoggingWebClientFilter implements ExchangeFilterFunction {

    private static final Logger log = LoggerFactory.getLogger(LoggingWebClientFilter.class);
    @Override
    @NonNull
    public Mono<ClientResponse> filter(@NonNull ClientRequest request, ExchangeFunction next) {
        log.info("request to {}, method {}", request.url(), request.method());
        log.info("headers {}", request.headers());
        long startTime = System.currentTimeMillis();
        return next.exchange(request)
                .doOnSuccess(clientResponse -> {
                    long duration = System.currentTimeMillis() - startTime;
                    log.info("Response: {}, exec time (ms) {}", clientResponse.statusCode(), duration);
                });
    }
}
