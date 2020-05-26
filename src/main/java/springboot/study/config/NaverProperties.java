package springboot.study.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "naverapi")
public class NaverProperties {

    private String bolgUrl;
    private String movieUrl;
    private String encyUrl;
    private String clientId;
    private String clientSecret;

}
