package org.example.ApiTesting.Task4;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest {
    public static void main(String[] args) {
        String baseUrl = "https://simple-books-api.click/status";
        given()
                .when()
                .get(baseUrl)
                .then()
                .statusCode(200)
                .assertThat()
                .body("status",equalTo("OK"));
    }
}