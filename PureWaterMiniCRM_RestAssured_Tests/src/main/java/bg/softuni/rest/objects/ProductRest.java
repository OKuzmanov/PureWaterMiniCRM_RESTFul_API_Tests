package bg.softuni.rest.objects;

import bg.softuni.dtos.ProductDTO;
import bg.softuni.rest.utils.Commons;

import static io.restassured.RestAssured.given;

public class ProductRest extends Commons {

    public static ProductDTO[] getAllProducts() {
        return given()
                .when().get(GET_ALL_PRODUCTS_RESOURCE)
                .then().statusCode(200)
                .extract().response().body().as(ProductDTO[].class);
    }

    public static ProductDTO getProductById(Long id) {
        return given()
                .when().get(GET_PRODUCT_BY_ID_RESOURCE + id)
                .then().statusCode(200)
                .extract().response().body().as(ProductDTO.class);
    }
}
