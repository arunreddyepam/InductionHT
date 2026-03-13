package org.example.ApiTesting.Task4;

import io.restassured.response.Response;
import org.testng.Assert;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class GetRequestTwo {
    public static void main(String[] args) {
        String baseUrl= "https://simple-books-api.glitch.me/books";
        Response response=given()
                .contentType("application/json")
                .when()
                .get(baseUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();

        List<Map<String, Object>> books = response.jsonPath().getList("");
        Assert.assertTrue(books.size()>0);
        for (Map<String, Object> book : books) {
            String title = (String) book.get("name");
            String type = (String) book.get("type");
            System.out.println("Book title: " + title + ", Book Type: " + type);
        }
    }
}
