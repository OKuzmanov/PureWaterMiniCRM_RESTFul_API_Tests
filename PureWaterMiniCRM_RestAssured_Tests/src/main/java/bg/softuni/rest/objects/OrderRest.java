package bg.softuni.rest.objects;

import bg.softuni.dtos.OrderDTO;
import bg.softuni.rest.utils.Commons;

import static io.restassured.RestAssured.given;

public class OrderRest extends Commons {

    public static OrderDTO[] getAllOrders() {
        return given()
                .when().get(GET_ALL_ORDERS_RESOURCE)
                .then().statusCode(200)
                .extract().response().body().as(OrderDTO[].class);
    }

    public static OrderDTO getOrderById(Long id) {
        return given()
                .when().get(GET_ORDER_BY_ID_RESOURCE + id)
                .then().statusCode(200)
                .extract().response().body().as(OrderDTO.class);
    }
}
