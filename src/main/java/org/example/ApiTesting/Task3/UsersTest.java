package org.example.ApiTesting.Task3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UsersTest {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test(priority = 1,
            description = "GET /users – TC-ALL: All validations in one request")
    public void verifyAllConditionsInOneRequest() {
        given()
                .when()
                .get("/users")
                .then()
                .log().all()
                .statusCode(200)                              // TC-01
                .body("size()",  greaterThan(3))              // TC-02
                .body("name",    hasItem("Ervin Howell"));    // TC-03

        System.out.println("✅ TC-ALL PASSED: All 3 validations passed in a single request.");
    }
}
