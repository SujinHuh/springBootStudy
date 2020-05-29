package springboot.study.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import springboot.study.repository.MovieRepository;
import springboot.study.respons.ResponseMovie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@AutoConfigureMockMvc

public class MovieServiceTest {

  @Autowired
  MovieService movieService;

  @Autowired
  MockMvc mockMvc;

  @MockBean
  private MovieRepository movieRepository;

  @BeforeEach
  void getMovieList() {

    ResponseMovie.Item.builder().title("MovieOne").actor("ActorOne").userRating(8.7f).build();

  }


  @Test
  @DisplayName("평점순으로정렬 확인")
  public void movie_ratings_sort() throws Exception {

      //given

    ResponseMovie.Item responseMovieOne = ResponseMovie.Item.builder()
            .title("MovieOne")
            .director("One")
            .userRating(8.2f)
            .build();


    ResponseMovie.Item responseMovieTwo = ResponseMovie.Item.builder()
            .title("MovieTwo")
            .director("Two")
            .userRating(9.2f)
            .build();


    ResponseMovie.Item responseMovieThree = ResponseMovie.Item.builder()
            .title("Movie3")
            .director("Three")
            .userRating(3.2f)
            .build();

    List<ResponseMovie.Item> items = Arrays.asList(responseMovieOne,responseMovieTwo,responseMovieThree);

    ResponseMovie.builder().items(items).build();

    MovieRepository movieRepository = mockMvc.perform();

    //when

      //then
    assertEquals();

  }

  
}