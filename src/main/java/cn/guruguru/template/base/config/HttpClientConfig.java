package cn.guruguru.template.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpClientConfig {

    /**
     * HTTP Client based on the {@link RestTemplate}
     *
     * @return a {@link RestTemplate} client
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
