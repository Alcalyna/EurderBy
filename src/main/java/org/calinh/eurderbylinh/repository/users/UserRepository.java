package org.calinh.eurderbylinh.repository.users;

import org.calinh.eurderbylinh.domain.user.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UserRepository {
    private Map<UUID, User> users;

    public UserRepository(UserDataFactory userDataFactory) {
        this.users = userDataFactory.getDefaultUsers();
    }

    public Map<UUID, User> getUsers() {
        return users;
    }

    public User save(User user) {
        users.put(user.getId(), user);
        return user;
    }

    public User getUserById(UUID id) {
        return users.get(id);
    }

    public User getUserByEmail(String email) {
        for(User user: users.values()) {
            if(user.getEmailAddress().toString().equals(email))
                return user;
        }
        return null;
    }

    public List<User> getAllCustomers() {
        return users.values().stream()
                .filter(user -> user.getRole().equals(User.Role.CUSTOMER))
                .collect(Collectors.toList());
    }
}
