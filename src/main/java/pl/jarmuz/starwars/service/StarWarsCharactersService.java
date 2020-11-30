package pl.jarmuz.starwars.service;

import pl.jarmuz.starwars.dto.CharacterExernalApiDto;
import pl.jarmuz.starwars.dto.HomeWorldDto;
import pl.jarmuz.starwars.dto.PageExternalApiDto;
import pl.jarmuz.starwars.dto.StarShipDto;

import java.util.List;

public interface StarWarsCharactersService {
    CharacterExernalApiDto getCharacterExternalApiDto(String id);

    PageExternalApiDto retrieveCharacterPageInfo(String page);

    HomeWorldDto retrieveHomeward(String homeWorldUrl);

    List<StarShipDto> retrieveStarShips(List<String> urls);
}