package org.calinh.eurderbylinh.exception.exceptions;

public class EmailIsNotValidException extends UserInputIsNotValidException {
    public EmailIsNotValidException() {
        super("This email is not valid!");
    }
}
