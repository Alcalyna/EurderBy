package org.calinh.eurderbylinh.exception.exceptions;

public class PhoneNumberIsNotValidException extends UserInputIsNotValidException {
    public PhoneNumberIsNotValidException() {
        super("The phone number is not correct!");
    }
}
