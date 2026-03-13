package org.example.ApiTesting.Task3;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SecondTask {
    public static void main(String[] args) {
        given()
                .baseUri("https://jsonplaceholder.typicode.com/users")
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("size()",greaterThan(3))
                .body("name",hasItem("Ervin Howell"));
    }
}
