package springboot.study.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
public class MovieDto {

    private String title;
    private String link;
    private float userRating;
    private String subtitle;

}
