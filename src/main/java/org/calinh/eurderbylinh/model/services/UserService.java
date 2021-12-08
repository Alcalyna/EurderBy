package org.calinh.eurderbylinh.model.services;

import org.calinh.eurderbylinh.domain.user.User;
import org.calinh.eurderbylinh.exception.exceptions.UserDoesNotExistException;
import org.calinh.eurderbylinh.exception.exceptions.UserNotAuthorizedException;
import org.calinh.eurderbylinh.model.dtos.userdtos.CreateUserDto;
import org.calinh.eurderbylinh.model.dtos.userdtos.UserDto;
import org.calinh.eurderbylinh.model.mappers.UserMapper;
import org.calinh.eurderbylinh.repository.users.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public List<UserDto> getAllCustomersInRepository() {
        return userRepository.getAllCustomers().stream()
                .map(user -> userMapper.mapUserToUserDto(user))
                .collect(Collectors.toList());
    }


    public UserDto getCustomerById(UUID id) {
        User user = userRepository.getUserById(id);
        if (user == null) {
            throw new UserDoesNotExistException();
        } else if (user.getRole().equals(User.Role.CUSTOMER)) {
            return userMapper.mapUserToUserDto(user);
        } else {
            throw new UserNotAuthorizedException();
        }
    }
}
