package bg.softuni.restassuredtests.all;

import bg.softuni.dtos.SupplierDTO;
import bg.softuni.rest.objects.SupplierRest;
import bg.softuni.restassuredtests.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class SupplierApiTests extends BaseTest {

    @Test
    public void test_getAllSuppliers() {
        SupplierDTO[] supplierDTOsList = SupplierRest.getAllSuppliers();

        Assertions.assertTrue(supplierDTOsList.length > 0);
    }

    @Test
    public void test_getSupplierById() {
        SupplierDTO[] supplierDTOsList = SupplierRest.getAllSuppliers();

        if (supplierDTOsList.length == 0) {
            Assertions.fail("There are no Suppliers in the DB.");
        }

        SupplierDTO firstSupplier = supplierDTOsList[0];
        Long firstSupplierId = firstSupplier.getId();

        SupplierDTO fetchedSupplier = SupplierRest.getSupplierById(firstSupplierId);

        Assertions.assertEquals(firstSupplier.toString(), fetchedSupplier.toString());
    }
}
