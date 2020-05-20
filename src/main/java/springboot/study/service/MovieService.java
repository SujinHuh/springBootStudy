package springboot.study.service;

import org.springframework.stereotype.Service;
import springboot.study.dto.MovieDto;
import springboot.study.repository.MovieRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> findByQuery(String query) {

        return movieRepository.findByQuery(query).getItems().stream()
                .map(m -> MovieDto.builder()
                        .title(m.getTitle())
                        .link(m.getLink())
                        .userRating(m.getUserRating())
                        .subtitle(m.getSubtitle())
                        .build())
                .collect(Collectors.toList());
    }

}
