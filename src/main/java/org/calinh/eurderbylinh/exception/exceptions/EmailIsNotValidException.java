package org.calinh.eurderbylinh.exception.exceptions;

public class EmailIsNotValidException extends RuntimeException {
    public EmailIsNotValidException() {
        super("This email is not valid!");
    }
}
