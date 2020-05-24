package springboot.study.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import springboot.study.config.NaverProperties;
import springboot.study.respons.ResponseMovie;

@Repository
@RequiredArgsConstructor
public class  MovieRepository {

    private final NaverProperties naverProperties;
    private final RestTemplate restTemplate;


    public ResponseMovie findByQuery(String query) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", naverProperties.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", naverProperties.getClientSecret());

        String url =naverProperties.getMovieUrl()+ "?query=" + query;

        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseMovie.class).getBody();
    }
}
