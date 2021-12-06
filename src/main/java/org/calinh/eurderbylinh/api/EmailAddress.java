package org.calinh.eurderbylinh.api;

import org.calinh.eurderbylinh.exception.exceptions.EmailIsNotValidException;

import java.util.Objects;
import java.util.regex.Pattern;

public class EmailAddress {
    private final String username;
    private final String domain;
    private final String emailRegex = "^\\+((?:9[679]|8[035789]|6[789]|5[90]|42|3[578]|2[1-689])|9[0-58]|8[1246]|6[0-6]|5[1-8]|4[013-9]|3[0-469]|2[70]|7|1)(?:\\W*\\d){0,13}\\d$";

    public String getFullEmail() {
        return username + "@" + domain;
    }

    public EmailAddress(String username, String domain) {
        if(!isValid(username, domain)) {
            throw new EmailIsNotValidException();
        }
        this.username = username;
        this.domain = domain;
    }

    public boolean isValid(String username, String domain) {
        return Pattern.compile(emailRegex).matcher(username + "@" + domain).matches();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailAddress that = (EmailAddress) o;
        return Objects.equals(username, that.username) && Objects.equals(domain, that.domain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, domain);
    }

    @Override
    public String toString() {
        return "EmailAddress{" + username + "@" + domain + "}";
    }


}
