package org.example.ApiTesting.Task3;

import static io.restassured.RestAssured.given;

public class FirstTask {
    public static void main(String[] args) {
        String pet = "{\n" +
                "  \"id\": 123456,\n" +
                "  \"category\": {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"dogg\"\n" +
                "  },\n" +
                "  \"name\": \"snoopiee\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"pending\"\n" +
                "}";
        given()
                .contentType("application/json")
                .body(pet)
                .when()
                .post("https://petstore.swagger.io/v2/pet/addPet")
                .then()
                .statusCode(201);

    }
}
