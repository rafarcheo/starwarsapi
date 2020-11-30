package pl.jarmuz.starwars.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageDto {

    private String count;
    private String next;
    private String previous;
    private List<CharacterDto> results;
}
