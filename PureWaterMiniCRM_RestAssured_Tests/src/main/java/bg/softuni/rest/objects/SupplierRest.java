package bg.softuni.rest.objects;

import bg.softuni.dtos.SupplierDTO;
import bg.softuni.rest.utils.Commons;

import static io.restassured.RestAssured.given;

public class SupplierRest extends Commons {

    public static SupplierDTO[] getAllSuppliers() {
        return given()
                .when().get(GET_ALL_SUPPLIERS_RESOURCE)
                .then().statusCode(200)
                .extract().response().body().as(SupplierDTO[].class);
    }

    public static SupplierDTO getSupplierById(Long id) {
        return given()
                .when().get(GET_SUPPLIER_BY_ID_RESOURCE + id)
                .then().statusCode(200)
                .extract().response().body().as(SupplierDTO.class);
    }
}
