package org.calinh.eurderbylinh.api;

import io.restassured.RestAssured;
import org.calinh.eurderbylinh.domain.order.ItemGroup;
import org.calinh.eurderbylinh.model.dtos.itemsdtos.CreateItemDto;
import org.calinh.eurderbylinh.model.dtos.itemsdtos.ItemDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.List;

import static io.restassured.http.ContentType.JSON;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class OrderControllerTest {

    @Value("${server.port}")
    private int port;

    @Test
    void createOrder() {
//        List<ItemGroup> items = List.of(
////                new ItemGroup()
//        );
//        CreateItemDto createItemDto = new CreateItemDto()
//                .setName("Foco")
//                .setDescription("Coconut juice")
//                .setPrice(1.15)
//                .setAmount(15);
//
//        ItemDto itemDto = RestAssured
//                .given()
//                .header("authorization", "Basic bGluaEBldXJkZXJieS5jb206bGluaA==")
//                .body(createItemDto)
//                .accept(JSON)
//                .contentType(JSON)
//                .when()
//                .port(port)
//                .post("/orders")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.CREATED.value())
//                .extract()
//                .as(ItemDto.class);
//
//        Assertions.assertEquals("Foco", itemDto.getName());
//        Assertions.assertEquals("Coconut juice", itemDto.getDescription());
//        Assertions.assertEquals(1.15, itemDto.getPrice(), 0.01);
//        Assertions.assertEquals(15, itemDto.getAmount());
    }
}