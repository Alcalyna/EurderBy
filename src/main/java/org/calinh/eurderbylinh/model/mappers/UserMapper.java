package org.calinh.eurderbylinh.model.mappers;

import org.calinh.eurderbylinh.domain.user.User;
import org.calinh.eurderbylinh.model.dtos.userdtos.CreateUserDto;
import org.calinh.eurderbylinh.model.dtos.userdtos.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto mapUserToUserDto(User user) {
        System.out.println("user " + user);
        return new UserDto()
                .setId(user.getId())
                .setAddress(user.getAddress())
                .setEmailAddress(user.getEmailAddress())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setPassword(user.getPassword())
                .setPhoneNumber(user.getPhoneNumber())
                .setRole(user.getRole());


    }

    public User mapCreateUserDtoToUser(CreateUserDto createUserDto) {
        return User.UserBuilder.userBuilder()
                .withId()
                .withFirstName(createUserDto.getFirstName())
                .withLastName(createUserDto.getLastName())
                .withEmailAddress(createUserDto.getEmailAddress())
                .withAddress(createUserDto.getAddress())
                .withPassword(createUserDto.getPassword())
                .withPhoneNumber(createUserDto.getPhoneNumber())
                .withRole(User.Role.CUSTOMER)
                .build();
    }
}
