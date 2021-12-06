package org.calinh.eurderbylinh.api;

import org.calinh.eurderbylinh.exception.exceptions.EmailIsNotValidException;

import java.util.Objects;
import java.util.regex.Pattern;

public class EmailAddress {
    private final String username;
    private final String domain;
    private final String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

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
