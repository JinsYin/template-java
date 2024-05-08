package cn.guruguru.template.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpClientConfig {

    /**
     * HTTP Client based on the {@link RestTemplate}
     *
     * @return a {@link RestTemplate} client
     */
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
