package org.calinh.eurderbylinh.domain.user;

import org.calinh.eurderbylinh.domain.user.Address;
import org.calinh.eurderbylinh.domain.user.EmailAddress;
import org.calinh.eurderbylinh.domain.user.PhoneNumber;
import org.calinh.eurderbylinh.domain.user.User;
import org.calinh.eurderbylinh.exception.exceptions.UserInputIsNotValidException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

class UserTest {
    Address address;

    private void init() {
        address = Address.AddressBuilder.addressBuilder()
                .withStreetNumber("Happiness street")
                .withStreetNumber("24")
                .withPostCode("1000")
                .withCity("Brussels")
                .build();
    }

    @Test
    public void createAnCustomer() {

        User user = User.UserBuilder.userBuilder()
                .withId()
                .withFirstName("Linh")
                .withLastName("Nguyen")
                .withEmailAddress(new EmailAddress("linh", "eurderby.com"))
                .withPassword("linh")
                .withAddress(address)
                .withPhoneNumber(new PhoneNumber("+32", "470111111"))
                .withRole(User.Role.CUSTOMER)
                .build();

        Assertions.assertEquals(UUID.class, user.getId().getClass());
        Assertions.assertEquals("Linh", user.getFirstName());
        Assertions.assertEquals("Nguyen", user.getLastName());
        Assertions.assertEquals("linh", user.getEmailAddress().getUsername());
        Assertions.assertEquals("eurderby.com", user.getEmailAddress().getDomain());
        Assertions.assertEquals(address, user.getAddress());
        Assertions.assertEquals(User.Role.CUSTOMER, user.getRole());
        Assertions.assertEquals("+32 470111111", user.getPhoneNumber().toString());
    }

    @Test
    void givenEmptyFirstName_ThrowError() {
        Throwable exception = catchThrowable(() -> User.UserBuilder.userBuilder()
                .withId()
                .withFirstName("")
                .withLastName("Nguyen")
                .withEmailAddress(new EmailAddress("linh", "eurderby.com"))
                .withPassword("linh")
                .withAddress(address)
                .withPhoneNumber(new PhoneNumber("+32", "470111111"))
                .withRole(User.Role.CUSTOMER)
                .build());

        Assertions.assertEquals(exception.getClass(), UserInputIsNotValidException.class);
        Assertions.assertEquals("The first name should be provided!",exception.getMessage());
    }
}