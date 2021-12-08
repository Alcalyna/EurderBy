package org.calinh.eurderbylinh.api;

import io.restassured.RestAssured;
import org.calinh.eurderbylinh.model.dtos.itemsdtos.CreateItemDto;
import org.calinh.eurderbylinh.model.dtos.itemsdtos.ItemDto;
import org.calinh.eurderbylinh.model.dtos.itemsdtos.UpdateItemDto;
import org.calinh.eurderbylinh.model.dtos.userdtos.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.UUID;

import static io.restassured.http.ContentType.JSON;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ItemControllerTest {

    @Value("${server.port}")
    private int port;

    @Test
    void addItem() {

        CreateItemDto createItemDto = new CreateItemDto()
                .setName("Foco")
                .setDescription("Coconut juice")
                .setPrice(1.15)
                .setAmount(15);

        ItemDto itemDto = RestAssured
                .given()
                .header("authorization", "Basic YWRtaW5AZXVyZGVyYnkuY29tOmFkbWlu")
                .body(createItemDto)
                .accept(JSON)
                .contentType(JSON)
                .when()
                .port(port)
                .post("/items")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(ItemDto.class);

        Assertions.assertEquals("Foco", itemDto.getName());
        Assertions.assertEquals("Coconut juice", itemDto.getDescription());
        Assertions.assertEquals(1.15, itemDto.getPrice(), 0.01);
        Assertions.assertEquals(15, itemDto.getAmount());
    }

    @Test
    void getAllItems() {
        List<ItemDto> items = RestAssured
                .given()
                .header("authorization", "Basic YWRtaW5AZXVyZGVyYnkuY29tOmFkbWlu")
                .accept(JSON)
                .contentType(JSON)
                .when()
                .port(port)
                .get("/items")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(List.class);

        Assertions.assertTrue(items.size() > 0);
    }

    @Test
    void updateItem() {
        UpdateItemDto updateItemDto = new UpdateItemDto()
                .setItemId(UUID.fromString("0e3a2883-eca0-4127-aef7-28c6a4a7fd39"))
                .setName("MacBookAir")
                .setDescription("Lighter than a feather")
                .setPrice(900)
                .setAmount(9);

        ItemDto itemDto = RestAssured
                .given()
                .header("authorization", "Basic YWRtaW5AZXVyZGVyYnkuY29tOmFkbWlu")
                .body(updateItemDto)
                .accept(JSON)
                .contentType(JSON)
                .when()
                .port(port)
                .put("/items")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(ItemDto.class);

        Assertions.assertEquals("MacBookAir", itemDto.getName());
        Assertions.assertEquals("Lighter than a feather", itemDto.getDescription());
        Assertions.assertEquals(900, itemDto.getPrice(), 0.01);
        Assertions.assertEquals(9, itemDto.getAmount());
    }
}