package org.calinh.eurderbylinh.repository.users;

import org.calinh.eurderbylinh.domain.user.Address;
import org.calinh.eurderbylinh.domain.user.EmailAddress;
import org.calinh.eurderbylinh.domain.user.PhoneNumber;
import org.calinh.eurderbylinh.domain.user.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class UserDataFactory {

    public Map<UUID, User> getDefaultUsers() {
        Map<UUID, User> result = new HashMap<>();

        User admin = User.UserBuilder.userBuilder()
                .withIdNotRandom(UUID.fromString("4f9b2fa5-3f32-440b-b19e-974ef2666c77"))
                .withAddress(Address.AddressBuilder.addressBuilder()
                        .withCity("Brussels")
                        .withStreetName("Happiness street")
                        .withStreetNumber("87")
                        .withPostCode("1234")
                        .build())
                .withEmailAddress(new EmailAddress("admin", "eurderby.com"))
                .withPassword("admin")
                .withFirstName("Admin")
                .withLastName("Istrator")
                .withRole(User.Role.ADMIN)
                .withPhoneNumber(new PhoneNumber("+32", "470151516"))
                .build();
        result.put(admin.getId(), admin);

        User linh = User.UserBuilder.userBuilder()
                .withIdNotRandom(UUID.fromString("3f9b2fa5-3f32-440b-b19e-974ef2666c77"))
                .withAddress(Address.AddressBuilder.addressBuilder()
                        .withCity("Brussels")
                        .withStreetName("Calinh street")
                        .withStreetNumber("9")
                        .withPostCode("1000")
                        .build())
                .withEmailAddress(new EmailAddress("linh", "eurderby.com"))
                .withPassword("linh")
                .withFirstName("Linh")
                .withLastName("Nguyen")
                .withRole(User.Role.CUSTOMER)
                .withPhoneNumber(new PhoneNumber("+32", "470151515"))
                .build();

        result.put(linh.getId(), linh);

        return result;
    }
}
