package bg.softuni.restassuredtests.all;

import bg.softuni.dtos.CustomerDTO;
import bg.softuni.rest.objects.CustomerRest;
import bg.softuni.restassuredtests.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerApiTests extends BaseTest {

    @Test
    public void test_getAllCustomers() {
        CustomerDTO[] customersList = CustomerRest.getAllCustomers();

        Assertions.assertTrue(customersList.length > 0);
    }

    @Test
    public void test_getCustomersById() {
        CustomerDTO[] customersList = CustomerRest.getAllCustomers();

        if (customersList.length == 0) {
            Assertions.fail("There are no Customers in the DB.");
        }

        CustomerDTO firstCustomer = customersList[0];
        Long firstCustomerId = firstCustomer.getId();

        CustomerDTO fetchedCustomer = CustomerRest.getCustomerById(firstCustomerId);

        Assertions.assertEquals(firstCustomer.toString(), fetchedCustomer.toString());
    }
}
