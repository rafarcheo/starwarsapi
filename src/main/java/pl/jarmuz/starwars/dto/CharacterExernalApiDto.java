package pl.jarmuz.starwars.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CharacterExernalApiDto implements Serializable {

    private String id;
    private String name;
    private String height;
    private String mass;

    @JsonProperty("hair_color")
    private String hairColor;

    @JsonProperty("skin_color")
    private String skinColor;

    @JsonProperty("eye_color")
    private String eyeColor;

    @JsonProperty("birth_year")
    private String birthYear;

    private String gender;
    private String created;
    private String url;
    private String edited;

    @JsonProperty("homeworld")
    private String homeWorld;

    @JsonProperty("starships")
    private List<String> starshipsUrls;

    private List<String> films;
    private List<String> species;
    private List<String> vehicles;
}