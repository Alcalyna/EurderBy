package org.calinh.eurderbylinh.model.dtos.userdtos;

import org.calinh.eurderbylinh.domain.user.Address;
import org.calinh.eurderbylinh.domain.user.EmailAddress;
import org.calinh.eurderbylinh.domain.user.PhoneNumber;
import org.calinh.eurderbylinh.domain.user.User;

import java.util.UUID;

public class UserDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private EmailAddress emailAddress;
    private String password;
    private Address address;
    private PhoneNumber phoneNumber;
    private User.Role role;

    public UserDto() {
    }

    public UserDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserDto setEmailAddress(EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public UserDto setId(UUID id) {
        this.id = id;
        return this;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserDto setAddress(Address address) {
        this.address = address;
        return this;
    }

    public UserDto setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public UserDto setRole(User.Role role) {
        this.role = role;
        return this;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress=" + emailAddress +
                ", password='" + password + '\'' +
                ", address=" + address +
                ", phoneNumber=" + phoneNumber +
                ", role=" + role +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public Address getAddress() {
        return address;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public User.Role getRole() {
        return role;
    }
}
