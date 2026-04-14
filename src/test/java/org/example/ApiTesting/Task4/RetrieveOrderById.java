package org.example.ApiTesting.Task4;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RetrieveOrderById {
    public static void main(String[] args) {
        // Set Base URI
        RestAssured.baseURI = "https://simple-books-api.glitch.me";

        // Use the access token obtained previously
        String accessToken = GenerateAccessToken.accessToken; // Or use your method to get the token

        // Specify the orderId you want to retrieve
        String orderId = "123"; // Replace with the actual orderId

        // GET request to retrieve order details by ID
        Response response = given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/orders/" + orderId)
                .then()
                .statusCode(200) // Validate status code is 200
                .body("orderId", equalTo(orderId)) // Validate correct orderId in response
                .extract().response();

        // Print order details
        System.out.println("Order ID: " + response.jsonPath().getString("orderId"));
        System.out.println("Book ID: " + response.jsonPath().getInt("bookId"));
        System.out.println("Customer Name: " + response.jsonPath().getString("customerName"));
    }
}
