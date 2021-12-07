package org.calinh.eurderbylinh.model.services;

import org.calinh.eurderbylinh.domain.user.User;
import org.calinh.eurderbylinh.model.dtos.userdtos.CreateUserDto;
import org.calinh.eurderbylinh.model.dtos.userdtos.UserDto;
import org.calinh.eurderbylinh.model.mappers.UserMapper;
import org.calinh.eurderbylinh.repository.users.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto addCustomer(CreateUserDto createUserDto) {
        User newUser = userMapper.mapCreateUserDtoToUser(createUserDto);
        userRepository.save(newUser);
        return userMapper.mapUserToUserDto(newUser);
    }
}
