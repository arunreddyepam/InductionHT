package org.example.ApiTesting.Task3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PetStoreTest {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    private static final int PET_ID = 12345;

    private static final String PET_REQUEST_BODY = """
            {
              "id": 12345,
              "category": {
                "id": 1,
                "name": "dog"
              },
              "name": "snoopie",
              "photoUrls": [
                "string"
              ],
              "tags": [
                {
                  "id": 0,
                  "name": "string"
                }
              ],
              "status": "pending"
            }
            """;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URL;
    }


    @Test(priority = 1, description = "POST /pet – Create pet 'snoopie'")
    public void createPet() {
        given()
                .contentType(ContentType.JSON)
                .body(PET_REQUEST_BODY)
                .when()
                .post("/pet")
                .then()
                .log().ifError()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(PET_ID))
                .body("category.id", equalTo(1))
                .body("category.name", equalTo("dog"))
                .body("name", equalTo("snoopie"))
                .body("photoUrls[0]", equalTo("string"))
                .body("tags[0].id", equalTo(0))
                .body("tags[0].name", equalTo("string"))
                .body("status", equalTo("pending"));

        System.out.println("✅ Pet 'snoopie' (id=" + PET_ID + ") created successfully.");
    }
}