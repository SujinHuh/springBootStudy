package springboot.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springboot.study.dto.BlogDto;
import springboot.study.dto.EncyclopediaDto;
import springboot.study.dto.MovieDto;
import springboot.study.service.BlogService;
import springboot.study.service.EncyclopediaService;
import springboot.study.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {


    private final BlogService blogService;

    private final MovieService movieService;

    private final EncyclopediaService encyclopediaService;

    public MainController(BlogService blogService, MovieService movieService, EncyclopediaService encyclopediaService) {
        this.blogService = blogService;
        this.movieService = movieService;
        this.encyclopediaService = encyclopediaService;
    }

    @GetMapping("/blog")
    public List<BlogDto> searchBlogByQuery(){
        return blogService.findByQuery("강남");
    }

    @GetMapping("/movie")
    public List<MovieDto> searchMovieByQuery() {
        return movieService.findByQuery("해리포터");
    }

    // 영화 평점순 정렬


    @GetMapping("/Encyclopedia")
    public List<EncyclopediaDto> searchNewsByQuery() {
        return encyclopediaService.findByQuery("다이어트");
    }

}