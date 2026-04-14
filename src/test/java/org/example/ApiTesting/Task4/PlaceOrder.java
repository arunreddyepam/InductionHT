package org.example.ApiTesting.Task4;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PlaceOrder {
    public static void main(String[] args) {
        // Set Base URI
        RestAssured.baseURI = "https://simple-books-api.glitch.me";

        // Use the access token obtained from the previous step
        String accessToken = GenerateAccessToken.accessToken; // Replace with the actual token

        // JSON payload for placing an order
        String payload = "{\n" +
                "  \"bookId\": 1,\n" +
                "  \"customerName\": \"John Doe\"\n" +
                "}";

        // POST request to place an order
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + accessToken)
                .body(payload)
                .when()
                .post("/orders")
                .then()
                .statusCode(201) // Validate status code is 201
                .body("orderId", notNullValue()) // Confirm orderId is returned
                .extract().response();

        // Extract and print the orderId
        String orderId = response.jsonPath().getString("orderId");
        System.out.println("Order ID: " + orderId);
    }
}