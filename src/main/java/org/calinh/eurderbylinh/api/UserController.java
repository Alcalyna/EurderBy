package org.calinh.eurderbylinh.api;

import org.calinh.eurderbylinh.domain.user.Feature;
import org.calinh.eurderbylinh.model.dtos.userdtos.CreateUserDto;
import org.calinh.eurderbylinh.model.dtos.userdtos.UserDto;
import org.calinh.eurderbylinh.model.services.SecurityService;
import org.calinh.eurderbylinh.model.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "users")
public class UserController {

    private UserService userService;
    private SecurityService securityService;

    public UserController(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto register(@RequestBody CreateUserDto newUser) {
        return userService.addCustomer(newUser);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getAllCustomers(@RequestHeader String authorization) {
        securityService.validateAccess(authorization, Feature.DISPLAY_CUSTOMERS);
        return userService.getAllCustomersInRepository();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getCustomer(@PathVariable("id") UUID id, @RequestHeader String authorization) {
        securityService.validateAccess(authorization, Feature.DISPLAY_CUSTOMER_DETAIL);
        return userService.getCustomerById(id);
    }
}
