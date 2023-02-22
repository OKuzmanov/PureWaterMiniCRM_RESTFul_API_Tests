package bg.softuni.rest.objects;

import bg.softuni.dtos.CustomerDTO;
import bg.softuni.rest.utils.Commons;

import static io.restassured.RestAssured.given;

public class CustomerRest extends Commons {

    public static CustomerDTO[] getAllCustomers() {
        return given()
                .when().get(GET_ALL_CUSTOMERS_RESOURCE)
                .then().statusCode(200)
                .extract().response().body().as(CustomerDTO[].class);
    }

    public static CustomerDTO getCustomerById(Long id) {
        return given()
                .when().get(GET_CUSTOMER_BY_ID_RESOURCE + id)
                .then().statusCode(200)
                .extract().response().body().as(CustomerDTO.class);
    }
}
