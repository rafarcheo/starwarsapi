package pl.jarmuz.starwars.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerController {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Not all mandatory fields wos given")
    @ExceptionHandler(ContentNotFoundException.class)
    public void handleEmptyFieldException(ContentNotFoundException e) {
        log.error("Page or person not found", e);
    }

}