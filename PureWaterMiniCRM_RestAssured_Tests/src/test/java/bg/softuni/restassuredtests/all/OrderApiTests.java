package bg.softuni.restassuredtests.all;

import bg.softuni.dtos.OrderDTO;
import bg.softuni.rest.objects.OrderRest;
import bg.softuni.restassuredtests.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.CoreMatchers.hasItems;

public class OrderApiTests extends BaseTest {

    @Test
    public void test_getAllOrders() {
        OrderDTO[] orderDTOsList = OrderRest.getAllOrders();

        Assertions.assertTrue(orderDTOsList.length > 0);
    }

    @Test
    public void test_getOrderById() {
        OrderDTO[] orderDTOsList = OrderRest.getAllOrders();

        if (orderDTOsList.length == 0) {
            Assertions.fail("There are no Orders in the DB.");
        }

        OrderDTO firstOrder = orderDTOsList[0];
        Long firstOrderId = firstOrder.getId();

        OrderDTO fetchedOrder = OrderRest.getOrderById(firstOrderId);

        Assertions.assertEquals(firstOrder.toString(), fetchedOrder.toString());
    }
}
