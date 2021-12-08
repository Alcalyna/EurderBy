package org.calinh.eurderbylinh.domain.user;

import org.calinh.eurderbylinh.exception.exceptions.UserInputIsNotValidException;

import java.util.List;
import java.util.UUID;

public class User {
    private UUID id;
    private final String firstName;
    private final String lastName;
    private final EmailAddress emailAddress;
    private String password;
    private Address address;
    private PhoneNumber phoneNumber;
    private Role role;

    public enum Role {
        ADMIN(List.of(Feature.ADD_ITEM, Feature.DISPLAY_CUSTOMERS, Feature.DISPLAY_CUSTOMER_DETAIL, Feature.DISPLAY_ITEMS, Feature.UPDATE_ITEM)),
        CUSTOMER(List.of(Feature.ADD_ORDER, Feature.DISPLAY_ITEMS));

        private List<Feature> featureList;

        Role(List<Feature> featureList) {
            this.featureList = featureList;
        }

        public boolean containsFeature(Feature feature) {
            return featureList.contains(feature);
        }
    }

    public boolean hasAccessTo(Feature feature) {
        return this.role.containsFeature(feature);
    }

    public User(UserBuilder builder) {
        isValidInput(builder.firstName, builder.lastName, builder.phoneNumber);
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.emailAddress = builder.emailAddress;
        this.password = builder.password;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.role = builder.role;
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

    public Address getAddress() {
        return address;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public static final class UserBuilder {
        private UUID id;
        private String firstName;
        private String lastName;
        private EmailAddress emailAddress;
        private String password;
        private Address address;
        private PhoneNumber phoneNumber;
        private Role role;

        private UserBuilder() {
        }

        public static UserBuilder userBuilder() {
            return new UserBuilder();
        }

        public User build() {
            return new User(this);
        }

        public UserBuilder withId() {
            this.id = UUID.randomUUID();
            return this;
        }

        public UserBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder withEmailAddress(EmailAddress emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public UserBuilder withPhoneNumber(PhoneNumber phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserBuilder withRole(Role role) {
            this.role = role;
            return this;
        }
    }

    public void isValidInput(String firstName, String lastName, PhoneNumber phoneNumber) {
        if (firstName == null || firstName.trim() == "") {
            throw new UserInputIsNotValidException("The first name should be provided!");
        }
        if (lastName == null || lastName.trim() == "") {
            throw new UserInputIsNotValidException("The last name should be provided!");
        }
        if (phoneNumber == null) {
            throw new UserInputIsNotValidException("The phone number should be provided!");
        }
    }

    @Override
    public String toString() {
        return "User{" +
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
}
