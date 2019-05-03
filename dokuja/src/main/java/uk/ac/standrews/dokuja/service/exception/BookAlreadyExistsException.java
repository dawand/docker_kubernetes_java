package uk.ac.standrews.dokuja.service.exception;

public class BookAlreadyExistsException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public BookAlreadyExistsException(final String message) {
        super(message);
    }

}