package org.calinh.eurderbylinh.api;

import org.calinh.eurderbylinh.domain.user.Address;
import org.calinh.eurderbylinh.domain.user.EmailAddress;
import org.calinh.eurderbylinh.domain.user.PhoneNumber;
import org.calinh.eurderbylinh.domain.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    public void createAnCustomer() {
        Address address = Address.AddressBuilder.addressBuilder()
                .withStreetNumber("Happiness street")
                .withStreetNumber("24")
                .withPostCode("1000")
                .withCity("Brussels")
                .build();

        User user = User.UserBuilder.userBuilder()
                .withId()
                .withFirstName("Linh")
                .withLastName("Nguyen")
                .withEmailAddress(new EmailAddress("linh", "eurderby.com"))
                .withPassword("linh")
                .withAddress(address)
                .withPhoneNumber(new PhoneNumber("+32", "470111111"))
                .build();

        Assertions.assertEquals("Linh", user.getFirstName());
        Assertions.assertEquals("Nguyen", user.getLastName());
        Assertions.assertEquals("linh", user.getEmailAddress().getUsername());
        Assertions.assertEquals("eurderby.com", user.getEmailAddress().getDomain());
        Assertions.assertEquals(address, user.getAddress());
        Assertions.assertEquals("+32 470111111", user.getPhoneNumber().toString());
    }

}