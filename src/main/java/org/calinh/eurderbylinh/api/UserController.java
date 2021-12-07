package org.calinh.eurderbylinh.api;

import org.calinh.eurderbylinh.model.dtos.userdtos.CreateUserDto;
import org.calinh.eurderbylinh.model.dtos.userdtos.UserDto;
import org.calinh.eurderbylinh.model.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto register(@RequestBody CreateUserDto newUser) {
        return userService.addCustomer(newUser);
    }
}
