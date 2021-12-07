package org.calinh.eurderbylinh.repository.users;

import org.calinh.eurderbylinh.domain.user.Address;
import org.calinh.eurderbylinh.domain.user.EmailAddress;
import org.calinh.eurderbylinh.domain.user.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class UserDataFactory {

    public Map<UUID, User> getDefaultUsers() {
        User customer0 = User.UserBuilder.userBuilder()
                .withAddress(Address.AddressBuilder.addressBuilder().withCity("Ghent").build())
                .withEmailAddress(new EmailAddress("admin", "lolweb.com"))
                .withPassword("admin")
                .withFirstName("Admin")
                .withLastName("Istrator")
                .withRole(User.Role.CUSTOMER)
                .build();

        Map<UUID, User> result = new HashMap<>();
        result.put(customer0.getId(), customer0);
        return result;
    }
}
