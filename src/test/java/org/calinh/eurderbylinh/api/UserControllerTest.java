package org.calinh.eurderbylinh.api;

import io.restassured.RestAssured;
import org.calinh.eurderbylinh.domain.user.Address;
import org.calinh.eurderbylinh.domain.user.EmailAddress;
import org.calinh.eurderbylinh.domain.user.PhoneNumber;
import org.calinh.eurderbylinh.exception.exceptions.UserDoesNotExistException;
import org.calinh.eurderbylinh.model.dtos.userdtos.CreateUserDto;
import org.calinh.eurderbylinh.model.dtos.userdtos.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.UUID;

import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

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

    @Test
    void getAllCustomers() {
        List<UserDto> users = RestAssured
                .given()
                .header("authorization", "Basic YWRtaW5AZXVyZGVyYnkuY29tOmFkbWlu")
                .accept(JSON)
                .contentType(JSON)
                .when()
                .port(port)
                .get("/users/customers")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(List.class);

        Assertions.assertTrue(users.size() > 0);
    }

    @Test
    void givenNonExistingUser() {
        RestAssured.given()
                .header("authorization", "Basic YWRtaW5AVyZGVyYnkuY29tOmFkbWlu")
                .accept(JSON)
                .contentType(JSON)
                .when()
                .port(port)
                .get("/users/customers")
                .then()
                .assertThat()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @Test
    void getCustomerById() {

        UserDto userDto = RestAssured
                .given()
                .header("authorization", "Basic YWRtaW5AZXVyZGVyYnkuY29tOmFkbWlu")
                .accept(JSON)
                .contentType(JSON)
                .when()
                .port(port)
                .pathParam("id", "3f9b2fa5-3f32-440b-b19e-974ef2666c77")
                .get("/users/customers/{id}")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(UserDto.class);

        Assertions.assertEquals(UUID.fromString("3f9b2fa5-3f32-440b-b19e-974ef2666c77"), userDto.getId());
    }
}