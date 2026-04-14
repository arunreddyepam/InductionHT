package org.example.ApiTesting.Task4;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class GenerateAccessToken {
    public static String accessToken;
    public static void main(String[] args) {
        // Set Base URI
        RestAssured.baseURI = "https://simple-books-api.glitch.me";

        // JSON payload
        String payload = "{\n" +
                "  \"clientName\": \"TestUser\",\n" +
                "  \"clientEmail\": \"testuser@example.com\"\n" +
                "}";

        // POST request to generate access token
        Response response = given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/api-clients")
                .then()
                .statusCode(201) // Validate status code is 201
                .extract().response();

        // Extract accessToken from response
         accessToken = response.jsonPath().getString("accessToken");
        System.out.println("Access Token: " + accessToken);

        // Store the token for future use (example: as a static variable)
        // You can use this token in subsequent requests
    }
}