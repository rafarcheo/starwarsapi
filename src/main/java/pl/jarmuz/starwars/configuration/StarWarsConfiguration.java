package pl.jarmuz.starwars.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class StarWarsConfiguration {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {

        return builder.setConnectTimeout(Duration.ofMillis(200000))
                .setReadTimeout(Duration.ofMillis(200000)).build();
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);

        return mapper;
    }

    @Bean
    public URIBuilder getURIBuilder() {
        return new URIBuilder();
    }
}
