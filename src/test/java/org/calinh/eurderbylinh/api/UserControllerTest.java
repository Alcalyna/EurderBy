package org.calinh.eurderbylinh.api;

import io.restassured.RestAssured;
import org.calinh.eurderbylinh.domain.user.Address;
import org.calinh.eurderbylinh.domain.user.EmailAddress;
import org.calinh.eurderbylinh.domain.user.PhoneNumber;
import org.calinh.eurderbylinh.model.dtos.userdtos.CreateUserDto;
import org.calinh.eurderbylinh.model.dtos.userdtos.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import static io.restassured.http.ContentType.JSON;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class UserControllerTest {

    @Value("${server.port}")
    private int port;

    @Test
    void register() {
        Address address = Address.AddressBuilder.addressBuilder()
                .withCity("Brussels")
                .withStreetNumber("24")
                .withPostCode("1000")
                .withStreetName("Happiness Street")
                .build();

        CreateUserDto createUserDto = new CreateUserDto()
                .setEmailAddress(new EmailAddress("lala", "eurderby.com"))
                .setAddress(address)
                .setPhoneNumber(new PhoneNumber("+32", "470102525"))
                .setFirstName("Lala")
                .setLastName("Nguyen")
                .setPassword("lala");

        UserDto userDto = RestAssured
                .given()
                .body(createUserDto)
                .accept(JSON)
                .contentType(JSON)
                .when()
                .port(port)
                .post("/users")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(UserDto.class);

        Assertions.assertEquals(false, userDto.getId().toString().isBlank());
        Assertions.assertEquals("Lala", userDto.getFirstName());
        Assertions.assertEquals("Nguyen", userDto.getLastName());
        Assertions.assertEquals("+32 470102525", userDto.getPhoneNumber().toString());
        Assertions.assertEquals("lala@eurderby.com", userDto.getEmailAddress().toString());
        Assertions.assertEquals(address, userDto.getAddress());
    }

}