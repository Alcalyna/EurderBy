package org.calinh.eurderbylinh.model.services;

import org.calinh.eurderbylinh.exception.exceptions.UserDoesNotExistException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void getCustomerById() {
        Throwable exception = catchThrowable(() -> userService.getCustomerById(UUID.fromString("9ba7b434-d014-4e55-9be7-6d22114fed47")));

        Assertions.assertEquals(UserDoesNotExistException.class, exception.getClass());
        Assertions.assertEquals("This user does not exist.", exception.getMessage());
    }
}