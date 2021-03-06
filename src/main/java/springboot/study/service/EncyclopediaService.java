package springboot.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.study.dto.EncyclopediaDto;
import springboot.study.repository.EncyclopediaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EncyclopediaService {

    private final EncyclopediaRepository encyclopediaRepository;

    public List<EncyclopediaDto> findByQuery(String query) {

       return encyclopediaRepository.findByQuery(query).getItems().stream()
               .map(e -> EncyclopediaDto.builder()
               .title(e.getTitle())
                       .link(e.getLink())
                       .display(e.getDisplay())
                       .start(e.getStart())
                       .total(e.getTotal())
                       .display(e.getDisplay())
                       .build())
               .collect(Collectors.toList());

    }

}
