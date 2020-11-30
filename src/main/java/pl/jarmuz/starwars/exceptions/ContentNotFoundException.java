package pl.jarmuz.starwars.exceptions;

public class ContentNotFoundException extends RuntimeException {

    public ContentNotFoundException(Throwable throwable) {
        super(throwable);
    }
}