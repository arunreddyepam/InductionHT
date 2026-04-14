package org.example.ApiTesting.Task4;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UpdateOrder {
    public static void main(String[] args) {
        // Set Base URI
        RestAssured.baseURI = "https://simple-books-api.glitch.me";

        // Use the access token obtained previously
        String accessToken = GenerateAccessToken.accessToken; // Or use your method to get the token

        // Specify the orderId you want to update
        String orderId = "123"; // Replace with the actual orderId

        // JSON payload to update customerName
        String payload = "{\n" +
                "  \"customerName\": \"Jane Doe\"\n" +
                "}";

        // PUT request to update the order
        given()
                .header("Authorization", "Bearer " + accessToken)
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .put("/orders/" + orderId)
                .then()
                .statusCode(204); // Validate status code is 204 (No Content)

        // GET request to verify the update
        Response response = given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/orders/" + orderId)
                .then()
                .statusCode(200)
                .body("customerName", equalTo("Jane Doe")) // Verify the updated name
                .extract().response();

        // Print updated order details
        System.out.println("Order ID: " + response.jsonPath().getString("orderId"));
        System.out.println("Book ID: " + response.jsonPath().getInt("bookId"));
        System.out.println("Customer Name: " + response.jsonPath().getString("customerName"));
    }
}
