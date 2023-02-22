package bg.softuni.rest.objects;

import bg.softuni.dtos.UserDTO;
import bg.softuni.rest.utils.Commons;

import static io.restassured.RestAssured.given;

public class UserRest extends Commons {

    public static UserDTO[] getAllUsers() {
        return given()
                .when().get(GET_ALL_USERS_RESOURCE)
                .then().statusCode(200)
                .extract().response().body().as(UserDTO[].class);
    }

    public static UserDTO getUserById(Long id) {
        return given()
                .when().get(GET_USER_BY_ID_RESOURCE + id)
                .then().statusCode(200)
                .extract().response().body().as(UserDTO.class);
    }
}
