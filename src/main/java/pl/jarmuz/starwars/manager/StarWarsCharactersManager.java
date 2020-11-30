package pl.jarmuz.starwars.manager;

import pl.jarmuz.starwars.dto.CharacterDto;
import pl.jarmuz.starwars.dto.PageDto;

public interface StarWarsCharactersManager {

    PageDto getAllCharacters(String page);

    CharacterDto getCharacterById(String id);
}