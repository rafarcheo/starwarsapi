package pl.jarmuz.starwars.helper;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
import pl.jarmuz.starwars.configuration.StarWarProperties;


@Component
@Data
public class ExternalApiHelper {

    private final StarWarProperties properties;

    public String getPageApiUrl(String page) {
        return UriComponentsBuilder
                .fromUriString(properties.getApiBaseUrl().concat("people/"))
                .queryParam("page", page)
                .build().toUriString();
    }

    public String getCharacterApiUrl(String id) {
        return UriComponentsBuilder
                .fromUriString(properties.getApiBaseUrl().concat("people/").concat(id).concat("/"))
                .build().toUriString();
    }
}