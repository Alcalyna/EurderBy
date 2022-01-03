package org.calinh.eurderbylinh.model.services;

import org.calinh.eurderbylinh.domain.user.Feature;
import org.calinh.eurderbylinh.exception.exceptions.UserDoesNotExistException;
import org.calinh.eurderbylinh.exception.exceptions.UserInputIsNotValidException;
import org.calinh.eurderbylinh.exception.exceptions.UserNotAuthorizedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SecurityServiceTest {

    @Autowired
    private SecurityService securityService;

    @Test
    void validateAccess() {
        Throwable exception = catchThrowable(() -> securityService.validateAccess("Basic bGluaEBldXJkZXJieS5jb206bGluaA==", Feature.DISPLAY_CUSTOMER_DETAIL));

        Assertions.assertEquals(UserNotAuthorizedException.class, exception.getClass());
        Assertions.assertEquals("You are not allowed to do this action.", exception.getMessage());
    }

    @Test
    void validateAccess_WrongPassword() {
        Throwable exception = catchThrowable(() -> securityService.validateAccess("Basic YWRtaW5AZXVyZGVyYnkuY29tOmFkbWlp", Feature.DISPLAY_CUSTOMER_DETAIL));

        Assertions.assertEquals(UserInputIsNotValidException.class, exception.getClass());
        Assertions.assertEquals("Sorry, wrong password!", exception.getMessage());
    }

    @Test
    void validateAccess_UserNull() {
        Throwable exception = catchThrowable(() -> securityService.validateAccess("Basic YWRtazdAZXVyZGVyYnkuY29tOmFkbWlp", Feature.DISPLAY_CUSTOMER_DETAIL));

        Assertions.assertEquals(UserDoesNotExistException.class, exception.getClass());
        Assertions.assertEquals("This user does not exist.", exception.getMessage());
    }

    @Test
    void isCorrectUser() {
        Throwable exception = catchThrowable(() -> securityService.isCorrectUser(UUID.fromString("4f9b2fa5-3f32-440b-b19e-974ef2666c77"), UUID.fromString("4f9b2fa5-3f32-440b-b19e-974ef2666c78")));

        Assertions.assertEquals(UserNotAuthorizedException.class, exception.getClass());
        Assertions.assertEquals("You are not allowed to do this action.", exception.getMessage());
    }
}