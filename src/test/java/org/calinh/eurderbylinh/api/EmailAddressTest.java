package org.calinh.eurderbylinh.api;

import org.calinh.eurderbylinh.domain.user.EmailAddress;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

class EmailAddressTest {


    @Test
    void givenEmail_CallingToString_ReturnCompleteEmail() {
        EmailAddress email = new EmailAddress("linh", "eurderby.com");

        Assertions.assertEquals("linh@eurderby.com", email.getFullEmail());
    }

    @Test
    void givenTwoEmailsWithSameUsernameAndDomain_CallinhEqualsMethod_ReturnTrue() {
        EmailAddress email1 = new EmailAddress("linh", "eurderby.com");
        EmailAddress email2 = new EmailAddress("linh", "eurderby.com");

        Assertions.assertEquals(true, email1.equals(email2));
    }

     @Test
    void givenWrongEmailAddress_ThrowError() {
        Throwable exception = catchThrowable(() -> new EmailAddress("linh", "eurderby"));

        Assertions.assertEquals("This email is not valid!",exception.getMessage());
     }

    @Test
    void givenEmptyUsername_ThrowError() {
        Throwable exception = catchThrowable(() -> new EmailAddress("", "eurderby.com"));

        Assertions.assertEquals("This email is not valid!",exception.getMessage());
    }
}