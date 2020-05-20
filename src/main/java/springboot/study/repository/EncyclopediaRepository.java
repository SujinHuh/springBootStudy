package springboot.study.repository;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;
import springboot.study.respons.ResponseEncyclopedia;
import springboot.study.respons.ResponseMovie;

@Repository
public class EncyclopediaRepository {

    @Value("${naver.openapi.clientId}")
    private String naverOpenApiClientId;

    @Value("${naver.openapi.clientSecret}")
    private String naverOpenApiClientSecret;

    public ResponseEncyclopedia findByQuery(String query) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", naverOpenApiClientId);
        httpHeaders.add("X-Naver-Client-Secret", naverOpenApiClientSecret);

        String url ="https://openapi.naver.com/v1/search/encyc.json"+ "?query=" + query;

        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseEncyclopedia.class).getBody();

    }

}
