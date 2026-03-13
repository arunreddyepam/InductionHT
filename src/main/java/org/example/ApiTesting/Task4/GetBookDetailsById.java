package org.example.ApiTesting.Task4;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetBookDetailsById {

    @Test
    public void getBookDetailsById() {

        int bookId = 1;
        RestAssured.baseURI = "https://simple-books-api.glitch.me";

        Response response = RestAssured
                .given()
                .pathParam("bookId", bookId)
                .when()
                .get("/books/{bookId}");

        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200");

        int returnedId = response.jsonPath().getInt("id");
        String title = response.jsonPath().getString("name");
        String type = response.jsonPath().getString("type");
        int stock = response.jsonPath().getInt("available");

        // Validate ID
        Assert.assertEquals(returnedId, bookId, "Book ID does not match");

    }
}