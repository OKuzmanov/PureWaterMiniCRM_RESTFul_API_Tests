package bg.softuni.restassuredtests.all;

import bg.softuni.dtos.ProductDTO;
import bg.softuni.rest.objects.ProductRest;
import bg.softuni.restassuredtests.BaseTest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class ProductApiTests extends BaseTest {

    @Test
    public void test_getAllProducts() {
        ProductDTO[] productDTOsList = ProductRest.getAllProducts();

        Assertions.assertTrue(productDTOsList.length > 0);
    }

    @Test
    public void test_getProductById() {
        ProductDTO[] productDTOsList = ProductRest.getAllProducts();

        if (productDTOsList.length == 0) {
            Assertions.fail("There are no Products in the DB.");
        }

        ProductDTO firstProduct = productDTOsList[0];
        Long firstProductId = firstProduct.getId();

        ProductDTO fetchedProduct = ProductRest.getProductById(firstProductId);

        Assertions.assertEquals(firstProduct.toString(), fetchedProduct.toString());
    }
}
