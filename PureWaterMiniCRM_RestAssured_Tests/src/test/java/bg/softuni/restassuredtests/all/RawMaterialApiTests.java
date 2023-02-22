package bg.softuni.restassuredtests.all;

import bg.softuni.dtos.RawMaterialDTO;
import bg.softuni.rest.objects.RawMaterialsRest;
import bg.softuni.restassuredtests.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class RawMaterialApiTests extends BaseTest {

    @Test
    public void test_getAllRawMaterials() {
        RawMaterialDTO[] rawMaterialDTOsList = RawMaterialsRest.getAllMaterials();

        Assertions.assertTrue(rawMaterialDTOsList.length > 0);
    }

    @Test
    public void test_getRawMaterialById() {
        RawMaterialDTO[] rawMaterialDTOsList = RawMaterialsRest.getAllMaterials();

        if (rawMaterialDTOsList.length == 0) {
            Assertions.fail("There are no Raw Materials in the DB.");
        }

        RawMaterialDTO firstRawMaterial = rawMaterialDTOsList[0];
        Long firstRawMaterialId = firstRawMaterial.getId();

        RawMaterialDTO fetchedRawMaterial = RawMaterialsRest.getRawMaterialsById(firstRawMaterialId);

        Assertions.assertEquals(firstRawMaterial.toString(), fetchedRawMaterial.toString());
    }
}
