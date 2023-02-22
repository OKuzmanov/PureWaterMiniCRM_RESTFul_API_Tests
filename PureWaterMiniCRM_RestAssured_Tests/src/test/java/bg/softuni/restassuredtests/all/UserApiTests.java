package bg.softuni.restassuredtests.all;

import bg.softuni.dtos.UserDTO;
import bg.softuni.rest.objects.UserRest;
import bg.softuni.restassuredtests.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserApiTests extends BaseTest {

    @Test
    public void test_getAllUsers() {
        UserDTO[] userDTOsList = UserRest.getAllUsers();

        Assertions.assertTrue(userDTOsList.length > 0);
    }

    @Test
    public void test_getUserById() {
        UserDTO[] userDTOsList = UserRest.getAllUsers();

        if (userDTOsList.length == 0) {
            Assertions.fail("There are no Users in the DB.");
        }

        UserDTO firstUser = userDTOsList[0];
        Long firstUserId = firstUser.getId();

        UserDTO fetchedUser = UserRest.getUserById(firstUserId);

        Assertions.assertEquals(firstUser.toString(), fetchedUser.toString());
    }
}
