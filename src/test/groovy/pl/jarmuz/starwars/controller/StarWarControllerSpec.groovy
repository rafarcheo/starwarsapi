package pl.jarmuz.starwars.controller

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import lombok.extern.slf4j.Slf4j
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import pl.jarmuz.starwars.dto.CharacterExernalApiDto
import pl.jarmuz.starwars.dto.CharacterDto
import pl.jarmuz.starwars.dto.PageDto
import pl.jarmuz.starwars.manager.StarWarsCharactersManager
import pl.jarmuz.starwars.service.StarWarsCharactersServiceImpl
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static pl.jarmuz.starwars.configuration.Constants.CHARACTERS

@WebMvcTest(StarWarCharactersController)
@AutoConfigureMockMvc
class StarWarControllerSpec extends Specification {

    public static final String CHARACTER_ID = "1"

    @Autowired
    private ObjectMapper objectMapper

    @Autowired
    MockMvc mockMvc

    @SpringBean
    private StarWarsCharactersManager starWarsCharactersManager = Stub()


    def "test endpoint getAllCharacters"(String page, String characterName) {

    }

    def "test endpoint getUser"(String characterId, String characterName) {


    }
}
