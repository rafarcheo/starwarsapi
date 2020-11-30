package pl.jarmuz.starwars.manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import pl.jarmuz.starwars.dto.CharacterDto;
import pl.jarmuz.starwars.dto.CharacterExernalApiDto;
import pl.jarmuz.starwars.dto.PageDto;
import pl.jarmuz.starwars.dto.PageExternalApiDto;
import pl.jarmuz.starwars.service.StarWarsCharactersService;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@Slf4j
@Component
public class StarWarsCharactersManagerImpl implements StarWarsCharactersManager {

    private final ObjectMapper objectMapper;

    private final StarWarsCharactersService starWarsService;

    @Override
    public PageDto getAllCharacters(String page) {
        log.debug("request for character page : {}", page);
        return cachedGetAllCharacters(page);
    }

    @Cacheable(value = "getAllCharacters", key = "#page")
    public PageDto cachedGetAllCharacters(String page) {
        return convertToResponsePageDto(
                starWarsService.retrieveCharacterPageInfo(page), page);
    }

    private PageDto convertToResponsePageDto(PageExternalApiDto pageExternalApiDto, String page) {
        final PageDto pageDto = retrievePageConverter().apply(pageExternalApiDto);
        setPersonsIds(page, pageDto);
        return pageDto;
    }

    private void setPersonsIds(String page, PageDto pageDto) {
        for(int i=0; i < pageDto.getResults().size(); i++){
            int tempId = i + 1 + (10 * Integer.parseInt(page)) - 10;
            pageDto.getResults().get(i).setId(String.valueOf(tempId));
        }
    }

    private Function<PageExternalApiDto, PageDto> retrievePageConverter() {
        return externalApiDto -> PageDto.builder()
                .count(externalApiDto.getCount())
                .next(externalApiDto.getNext())
                .previous(externalApiDto.getPrevious())
                .results(convertCharactersObjects(externalApiDto.getResults()))
                .build();
    }

    private List<CharacterDto> convertCharactersObjects(List<CharacterExernalApiDto> characterExternalApiDtos) {
        return characterExternalApiDtos.stream()
                .map(this::convertToResponseCharacterDto)
                .collect(Collectors.toList());
    }

    @Override
    public CharacterDto getCharacterById(String id) {
        log.debug("request for character by id : {}", id);
        return cachedGetCharacterById(id);
    }

    @Cacheable(value = "getCharacterById", key = "#id")
    public CharacterDto cachedGetCharacterById(String id) {
        return getCharacterInfo(id);
    }

    private CharacterDto getCharacterInfo(String id) {

        CharacterDto characterExtendDto =
                convertToResponseCharacterDto(starWarsService.getCharacterExternalApiDto(id));
        characterExtendDto.setId(id);

        return characterExtendDto;
    }

    private CharacterDto convertToResponseCharacterDto(CharacterExernalApiDto characterBaseDto) {
        return retrieveCharacterConverter().apply(characterBaseDto);
    }

    private Function<CharacterExernalApiDto, CharacterDto> retrieveCharacterConverter() {
        return externalApiDto -> CharacterDto.builder()
                .name(externalApiDto.getName())
                .height(externalApiDto.getHeight())
                .mass(externalApiDto.getMass())
                .hairColor(externalApiDto.getHairColor())
                .skinColor(externalApiDto.getSkinColor())
                .birthYear(externalApiDto.getBirthYear())
                .gender(externalApiDto.getGender())
                .eyeColor(externalApiDto.getEyeColor())
                .homeworld(starWarsService.retrieveHomeward(externalApiDto.getHomeWorld()))
                .starships(starWarsService.retrieveStarShips(externalApiDto.getStarshipsUrls()))
                .build();
    }
}