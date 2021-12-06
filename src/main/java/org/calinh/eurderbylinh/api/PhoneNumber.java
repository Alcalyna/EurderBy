package org.calinh.eurderbylinh.api;

import org.calinh.eurderbylinh.exception.exceptions.PhoneNumberIsNotValidException;

import java.util.regex.Pattern;

public class PhoneNumber {
    private String prefix;
    private String number;
    private final String phoneRegex = "\\+(9[976]\\d|8[987530]\\d|6[987]\\d|5[90]\\d|42\\d|3[875]\\d|\n" +
            "2[98654321]\\d|9[8543210]|8[6421]|6[6543210]|5[87654321]|\n" +
            "4[987654310]|3[9643210]|2[70]|7|1)\\d{1,14}$";

    public PhoneNumber(String prefix, String number) {
        if(!isValid(prefix, number)){
            throw new PhoneNumberIsNotValidException();
        }
        this.prefix = prefix;
        this.number = number;
    }

    public boolean isValid(String prefix, String number) {
        return Pattern.compile(phoneRegex).matcher(prefix + number).matches();
    }

    @Override
    public String toString() {
        return prefix + " " + number;
    }
}

