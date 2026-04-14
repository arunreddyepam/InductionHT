package org.example.ApiTesting.Task4;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class NegativeTests {
    public static void main(String[] args) {
        // Set Base URI
        RestAssured.baseURI = "https://simple-books-api.glitch.me";

        // Use the access token obtained previously
        String accessToken = GenerateAccessToken.accessToken; // Or use your method to get the token

        // 1. Place an order with invalid bookId (e.g., 999)
        String invalidOrderPayload = "{\n" +
                "  \"bookId\": 999,\n" +
                "  \"customerName\": \"John Doe\"\n" +
                "}";

        given()
                .header("Authorization", "Bearer " + accessToken)
                .header("Content-Type", "application/json")
                .body(invalidOrderPayload)
                .when()
                .post("/orders")
                .then()
                .statusCode(400) // Validate status code is 400
                .body("error", equalTo("Invalid or non-existent book ID.")); // Verify error message

        // 2. GET order with non-existent orderId (e.g., 999)
        given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/orders/999")
                .then()
                .statusCode(404) // Validate status code is 404
                .body("error", equalTo("Invalid order ID.")); // Verify error message
    }
}
