package org.calinh.eurderbylinh.model.services;

import org.calinh.eurderbylinh.domain.user.EmailAddress;
import org.calinh.eurderbylinh.domain.user.Feature;
import org.calinh.eurderbylinh.exception.exceptions.UserNotAuthorizedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

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
}