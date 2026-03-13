package org.example.ApiTesting.Task4;

import io.restassured.response.Response;
import org.testng.Assert;
import java.util.List;
import static io.restassured.RestAssured.given;

public class FilterBooksByType {
    public static void main(String[] args) {
        String baseUrl ="https://simple-books-api.glitch.me/books";
        Response response = given()
                .contentType("application/json")
                .queryParam("type","fiction")
                .when()
                .get(baseUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();
        List<String> booktype = response.jsonPath().getList("type");
        for(String type : booktype){
            Assert.assertEquals(type,"fiction");
        }
    }
}