package pl.jarmuz.starwars.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.jarmuz.starwars.dto.CharacterDto;
import pl.jarmuz.starwars.dto.PageDto;
import pl.jarmuz.starwars.manager.StarWarsCharactersManager;

import static pl.jarmuz.starwars.configuration.Constants.CHARACTERS;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(CHARACTERS)
public class StarWarCharactersController {

    @NonNull
    private StarWarsCharactersManager charactersManager;

    @ApiOperation(value = "Find person by id", notes = "provide information about person by given id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    CharacterDto getById(@ApiParam(value = "unique id of person", example = "1") @PathVariable("id") String id) {
        return charactersManager.getCharacterById(id);
    }

    @ApiOperation(value = "Find page by id", notes = "provide information about page by given id")
    @GetMapping()
    PageDto getAll(@RequestParam(name = "page") String page) {
        return charactersManager.getAllCharacters(page);
    }

}