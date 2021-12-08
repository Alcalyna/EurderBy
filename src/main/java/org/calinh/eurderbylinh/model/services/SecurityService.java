package org.calinh.eurderbylinh.model.services;

import org.calinh.eurderbylinh.domain.user.Feature;
import org.calinh.eurderbylinh.domain.user.User;
import org.calinh.eurderbylinh.exception.exceptions.UserDoesNotExistException;
import org.calinh.eurderbylinh.exception.exceptions.UserInputIsNotValidException;
import org.calinh.eurderbylinh.exception.exceptions.UserNotAuthorizedException;
import org.calinh.eurderbylinh.repository.users.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.UUID;

@Service
public class SecurityService {

    private UserRepository userRepository;

    public SecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateAccess(String authorization, Feature feature) {
        String decodeUsernamePassword = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        String email = decodeUsernamePassword.substring(0, decodeUsernamePassword.indexOf(":"));
        String password = decodeUsernamePassword.substring(decodeUsernamePassword.indexOf(":") + 1);
        User user = userRepository.getUserByEmail(email);
        if(user == null){
            throw new UserDoesNotExistException();
        }
        if(!user.getPassword().equals(password)){
            throw new UserInputIsNotValidException("Sorry, wrong password!");
        }
        if(!user.hasAccessTo(feature)){
            throw new UserNotAuthorizedException();
        }
    }

    public User getCurrentUser(String authorization) {
        String decodeUsernamePassword = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        String email = decodeUsernamePassword.substring(0, decodeUsernamePassword.indexOf(":"));
        User user = userRepository.getUserByEmail(email);
        return user;
    }

    public void isCorrectUser(UUID currentUserId, UUID candidateId) {
        if (!currentUserId.equals(candidateId)) {
            throw new UserNotAuthorizedException();
        }
    }
}
