package pl.jarmuz.starwars.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="star.wars")
@Data
public class StarWarProperties {

    private String apiBaseUrl;

}
