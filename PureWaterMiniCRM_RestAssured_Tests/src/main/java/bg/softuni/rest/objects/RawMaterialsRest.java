package bg.softuni.rest.objects;

import bg.softuni.dtos.RawMaterialDTO;
import bg.softuni.rest.utils.Commons;

import static io.restassured.RestAssured.given;

public class RawMaterialsRest extends Commons {
    public static RawMaterialDTO[] getAllMaterials() {
        return given()
                .when().get(GET_ALL_MATERIALS_RESOURCE)
                .then().statusCode(200)
                .extract().response().body().as(RawMaterialDTO[].class);
    }

    public static RawMaterialDTO getRawMaterialsById(Long id) {
        return given()
                .when().get(GET_MATERIAL_BY_ID_RESOURCE + id)
                .then().statusCode(200)
                .extract().response().body().as(RawMaterialDTO.class);
    }
}
