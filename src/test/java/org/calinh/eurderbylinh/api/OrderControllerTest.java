package org.calinh.eurderbylinh.api;

import io.restassured.RestAssured;
import org.calinh.eurderbylinh.domain.order.Order;
import org.calinh.eurderbylinh.model.dtos.orderdtos.CreateOrderDto;
import org.calinh.eurderbylinh.model.dtos.orderdtos.ItemGroupDto;
import org.calinh.eurderbylinh.model.dtos.orderdtos.OrderDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.UUID;

import static io.restassured.http.ContentType.JSON;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class OrderControllerTest {
    public static final String ANSI_GREEN = "\u001B[32m";
    @Value("${server.port}")
    private int port;

    @Test
    void createOrder() {
        List<ItemGroupDto> items = List.of(
                new ItemGroupDto()
                        .setItemId(UUID.fromString("256c95a4-a43b-42aa-8f53-e2dbf4849855"))
                        .setAmount(2),
                new ItemGroupDto()
                        .setItemId(UUID.fromString("5080b865-7d04-4aa6-b34a-89c3318072d3"))
                        .setAmount(4)
        );

        CreateOrderDto createOrderDto = new CreateOrderDto()
                .setItemGroupList(items);

        OrderDto orderDto = RestAssured
                .given()
                .header("authorization", "Basic bGluaEBldXJkZXJieS5jb206bGluaA==")
                .body(createOrderDto)
                .accept(JSON)
                .contentType(JSON)
                .when()
                .port(port)
                .post("/orders")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(OrderDto.class);

        Assertions.assertFalse(orderDto.getId().toString().isBlank());
    }

    @Test
    void getAllOrders() {
        List<ItemGroupDto> items = List.of(
                new ItemGroupDto()
                        .setItemId(UUID.fromString("256c95a4-a43b-42aa-8f53-e2dbf4849855"))
                        .setAmount(2),
                new ItemGroupDto()
                        .setItemId(UUID.fromString("5080b865-7d04-4aa6-b34a-89c3318072d3"))
                        .setAmount(4)
        );

        CreateOrderDto createOrderDto = new CreateOrderDto()
                .setItemGroupList(items);

        RestAssured
                .given()
                .header("authorization", "Basic bGluaEBldXJkZXJieS5jb206bGluaA==")
                .body(createOrderDto)
                .accept(JSON)
                .contentType(JSON)
                .when()
                .port(port)
                .post("/orders")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(OrderDto.class);

        List<OrderDto> orders = RestAssured
                .given()
                .header("authorization", "Basic bGluaEBldXJkZXJieS5jb206bGluaA==")
                .accept(JSON)
                .contentType(JSON)
                .when()
                .port(port)
                .get("/orders")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(List.class);

        Assertions.assertEquals(1, orders.size());
    }
}