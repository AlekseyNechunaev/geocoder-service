package ru.nechunaev.geocoderservice.configuration;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = GoogleApiContextProperties.CONF_PREFIX)
public class GoogleApiContextProperties {
    public static final String CONF_PREFIX = "google";
    private final String apiKey;
    private final long connectionTimeout;
    private final long readTimeout;
    private final int maxRetries;

    public GoogleApiContextProperties(@NotNull String apiKey, long connectionTimeout, long readTimeout, int maxRetries) {
        this.apiKey = apiKey;
        this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.maxRetries = maxRetries;
    }

    public String getApiKey() {
        return apiKey;
    }

    public long getConnectionTimeout() {
        return connectionTimeout;
    }

    public long getReadTimeout() {
        return readTimeout;
    }

    public int getMaxRetries() {
        return maxRetries;
    }
}
