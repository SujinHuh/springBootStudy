package springboot.study;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private BlogService blogService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private EncyclopediaService encyclopediaService;

    @GetMapping("/blog")
    public List<BlogDto> searchBlogByQuery(@RequestParam(name = "query") String query){

        return blogService.findByQuery(query);
    }

    @GetMapping("/movie")
    public List<MovieDto> searchMovieByQuery() {
        return movieService.findByQuery("해리포터");
    }

    @GetMapping("/Encyclopedia")
    public List<EncyclopediaDto> searchNewsByQuery() {
        return encyclopediaService.findByQuery("다이어트");
    }

}