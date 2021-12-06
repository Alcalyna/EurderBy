package org.calinh.eurderbylinh.api;

import org.calinh.eurderbylinh.domain.user.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddressTest {

    @Test
    public void createAddressWithBuilder() {
        Address address = Address.AddressBuilder.addressBuilder()
                .withCity("Brussels")
                .withPostCode("1000")
                .withStreetName("Happiness street")
                .withStreetNumber("24")
                .build();

        Assertions.assertEquals("Brussels", address.getCity());
        Assertions.assertEquals("1000", address.getPostCode());
        Assertions.assertEquals("Happiness street", address.getStreetName());
        Assertions.assertEquals("24", address.getStreetNumber());
    }
}