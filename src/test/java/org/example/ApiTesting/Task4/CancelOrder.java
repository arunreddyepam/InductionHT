package org.example.ApiTesting.Task4;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CancelOrder {
    public static void main(String[] args) {
        // Set Base URI
        RestAssured.baseURI = "https://simple-books-api.glitch.me";

        // Use the access token obtained previously
        String accessToken = GenerateAccessToken.accessToken; // Or use your method to get the token

        // Specify the orderId you want to cancel
        String orderId = "123"; // Replace with the actual orderId

        // DELETE request to cancel the order
        given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .delete("/orders/" + orderId)
                .then()
                .statusCode(204); // Validate status code is 204 (No Content)

        // GET request to verify the order is deleted (should return 404)
        given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/orders/" + orderId)
                .then()
                .statusCode(404); // Validate status code is 404 (Not Found)
    }
}