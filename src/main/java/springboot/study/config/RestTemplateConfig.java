package springboot.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestTemplateConfig {

    /** RestTemplate Bean 정의 */
    @Bean
    public RestTemplate restTemplate () {
        return new RestTemplate();
    }
}
