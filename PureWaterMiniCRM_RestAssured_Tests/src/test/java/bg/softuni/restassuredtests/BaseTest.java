package bg.softuni.restassuredtests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    final static String BASIC_URL = "http://localhost:8080";

    @BeforeAll
    public static void setup() {

        RequestSpecification customReqSpec = new RequestSpecBuilder()
                .setBaseUri(BASIC_URL)
                .log(LogDetail.ALL)
                .setRelaxedHTTPSValidation()
                .build();

        ResponseSpecification customRespSpec = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectResponseTime(Matchers.lessThan(20000L))
                .build();

        RestAssured.requestSpecification = customReqSpec;
        RestAssured.responseSpecification = customRespSpec;
    }
}
