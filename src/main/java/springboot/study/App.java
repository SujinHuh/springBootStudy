package springboot.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springboot.study.config.NaverProperties;

@SpringBootApplication
@EnableConfigurationProperties(NaverProperties.class)
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
