package org.calinh.eurderbylinh.repository.users;

import org.calinh.eurderbylinh.domain.user.User;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

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
        this.getUsers().put(user.getId(), user);
        return user;
    }
}
