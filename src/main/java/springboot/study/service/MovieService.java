package springboot.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.study.dto.MovieDto;
import springboot.study.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<MovieDto> findByQuery(String query) {

        List<MovieDto> list = new ArrayList<>();
        movieRepository.findByQuery(query).getItems().forEach(
                m -> list.add(MovieDto.builder()
                        .title(m.getTitle())
                        .link(m.getLink())
                        .userRating(m.getUserRating())
                        .subtitle(m.getSubtitle())
                        .build())
        );


        return getSortRating(list);

    }

    // TODO 더... 간단한 방법이 있을 것 같은데.....음... Dto 쪽으로 보내야 하나...
    private List<MovieDto> getSortRating(List<MovieDto> list) {
        return list.stream().sorted((a,b) -> (int)(b.getUserRating()*100) -  (int)(a.getUserRating())*100)
                .collect(Collectors.toList());
    }


}
