package springboot.study.service;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import springboot.study.dto.MovieDto;
import springboot.study.repository.MovieRepository;
import springboot.study.respons.ResponseMovie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class) //선언하면, @Mock 어노테이션 사용 가능
class MovieServiceTest {

  private MovieService movieService;

  @Test
  @DisplayName("평점 순으로 정렬이 잘 되는지")
  void arranged_well_in_user_ratings() {

    //given
    float expectedUserRanking = 9.3f;
    MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
    Mockito.when(movieRepository.findByQuery(any())).thenReturn(getStubMovieList()); //Mock 객체의 findByQuary 메서드 실행 결과 반환 "가짜데이터"
    movieService = new MovieService(movieRepository); // Mock객체를 MovieService 주입

    //when
    List<MovieDto> actualList = movieService.findByQuery("쿼리"); // 테스트 실행

    //then
    assertEquals(expectedUserRanking, actualList.stream().findFirst().get().getUserRating());

  }

  private ResponseMovie getStubMovieList() {

    List<ResponseMovie.Item> items = Arrays.asList(
            ResponseMovie.Item.builder().title("<b>MovieOne</b> 제목").actor("배우1").userRating(9.3f).build(),
            ResponseMovie.Item.builder().title("<b>MovieTwo</b> 제목").actor("배우2").userRating(9.7f).build(),
            ResponseMovie.Item.builder().title("<b>MovieThree</b> 제목").actor("배우3").userRating(7.5f).build()
            ResponseMovie.Item.builder().title("<b>MovieFour</b> 제목").actor("배우4").userRating(7.5f).build()
    );

    return ResponseMovie.builder()
            .items(items)
            .build();
  }
}