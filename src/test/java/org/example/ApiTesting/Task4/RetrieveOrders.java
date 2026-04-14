package org.example.ApiTesting.Task4;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RetrieveOrders {
    public static void main(String[] args) {
        // Set Base URI
        RestAssured.baseURI = "https://simple-books-api.glitch.me";

        // Use the access token obtained previously
        String accessToken = GenerateAccessToken.accessToken; // Or use your method to get the token

        // GET request to retrieve orders
        Response response = given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/orders")
                .then()
                .statusCode(200) // Validate status code is 200
                .extract().response();

        // Extract and print all orders
        // Assuming the response is a JSON array
        List<Map<String, Object>> orders = response.jsonPath().getList("");
        for (Map<String, Object> order : orders) {
            System.out.println("Order ID: " + order.get("orderId"));
            System.out.println("Book ID: " + order.get("bookId"));
            System.out.println("Customer Name: " + order.get("customerName"));
            System.out.println("---------------------------");
        }
    }
}