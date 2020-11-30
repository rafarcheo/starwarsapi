package pl.jarmuz.starwars.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.jarmuz.starwars.dto.CharacterExernalApiDto;
import pl.jarmuz.starwars.dto.HomeWorldDto;
import pl.jarmuz.starwars.dto.PageExternalApiDto;
import pl.jarmuz.starwars.dto.StarShipDto;
import pl.jarmuz.starwars.exceptions.ContentNotFoundException;
import pl.jarmuz.starwars.helper.ExternalApiHelper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@Slf4j
public class StarWarsCharactersServiceImpl implements StarWarsCharactersService {

    private final RestTemplate restTemplate;

    private final ExternalApiHelper externalApiHelper;

    @Override
    public CharacterExernalApiDto getCharacterExternalApiDto(String id) {
        return (CharacterExernalApiDto)
                callExternalApi(externalApiHelper.getCharacterApiUrl(id), CharacterExernalApiDto.class);
    }

    @Override
    public PageExternalApiDto retrieveCharacterPageInfo(String page) {
        return (PageExternalApiDto)
                callExternalApi(externalApiHelper.getPageApiUrl(page), PageExternalApiDto.class);
    }

    @Override
    public HomeWorldDto retrieveHomeward(String homeWorldUrl) {
        return (HomeWorldDto) callExternalApi(homeWorldUrl, HomeWorldDto.class);
    }

    @Override
    public List<StarShipDto> retrieveStarShips(List<String> starShipsUrls) {
        return starShipsUrls.stream()
                .map(url -> (StarShipDto) callExternalApi(url, StarShipDto.class))
                .collect(Collectors.toList());
    }

    private Object callExternalApi(String url, Class<?> classType) {
        log.debug("attempt to data from url {}", url);
        try {
            return restTemplate.getForEntity(url, classType).getBody();
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new ContentNotFoundException(illegalArgumentException);
        }
    }
}