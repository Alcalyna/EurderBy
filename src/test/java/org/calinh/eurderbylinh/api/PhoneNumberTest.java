package org.calinh.eurderbylinh.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

class PhoneNumberTest {

    @Test
    public void givenPhoneNumber_ReturnNumberToString() {
        PhoneNumber phoneNumber = new PhoneNumber("+32", "470111111");

        Assertions.assertEquals("+32 470111111", phoneNumber.toString());
    }

    @Test
    public void givenIncorrectNumber_ThrowNumber() {
        Throwable exception = catchThrowable(() -> new PhoneNumber("98", "778955"));

        Assertions.assertEquals("The phone number is not correct!",exception.getMessage());
    }
}