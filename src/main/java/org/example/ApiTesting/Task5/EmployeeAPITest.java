package org.example.ApiTesting.Task5;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EmployeeAPITest {

    String baseURI = "https://dummy.restapiexample.com/api/v1";
    static int employeeCount;
    static String createdEmployeeId;

    @Test(priority = 1)
    public void getAllEmployees() {

        RestAssured.baseURI = baseURI;

        Response response =
                given()
                        .when()
                        .get("/employees")
                        .then()
                        .extract().response();

        // Verify basic validations
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getStatusLine().contains("200"));
        Assert.assertTrue(response.getHeader("Content-Type").contains("application/json"));
        Assert.assertNotNull(response.getHeader("Content-Encoding"));
        Assert.assertEquals(response.jsonPath().getString("status"), "success");

        employeeCount = response.jsonPath().getList("data").size();
        System.out.println("Initial Employee Count: " + employeeCount);
    }

    @Test(priority = 2)
    public void createEmployee() {

        EmployeePOJO employee =
                new EmployeePOJO("Arun Reddy", "60000", "25");

        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .body(employee)
                        .when()
                        .post("/create")
                        .then()
                        .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getStatusLine().contains("200"));
        Assert.assertTrue(response.getHeader("Content-Type").contains("application/json"));
        Assert.assertEquals(response.jsonPath().getString("status"), "success");

        createdEmployeeId = response.jsonPath().getString("data.id");
        Assert.assertNotNull(createdEmployeeId);

        // Verify count increased
        Response getResponse = given().get("/employees");
        int newCount = getResponse.jsonPath().getList("data").size();
        Assert.assertEquals(newCount, employeeCount + 1);

        employeeCount = newCount;
    }

    @Test(priority = 3)
    public void getCreatedEmployee() {

        Response response =
                given()
                        .when()
                        .get("/employee/" + createdEmployeeId)
                        .then()
                        .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("status"), "success");

        Assert.assertEquals(response.jsonPath().getString("data.employee_name"), "Soujanya");
        Assert.assertEquals(response.jsonPath().getString("data.employee_salary"), "50000");
        Assert.assertEquals(response.jsonPath().getString("data.employee_age"), "28");
    }

    @Test(priority = 4)
    public void updateEmployee() {

        EmployeePOJO updatedEmployee =
                new EmployeePOJO("Arun Reddy", "70000", "30");

        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .body(updatedEmployee)
                        .when()
                        .put("/update/" + createdEmployeeId)
                        .then()
                        .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("status"), "success");
    }

    @Test(priority = 5)
    public void verifyUpdatedEmployee() {

        Response response =
                given()
                        .when()
                        .get("/employee/" + createdEmployeeId)
                        .then()
                        .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);

        Assert.assertEquals(response.jsonPath().getString("data.employee_salary"), "70000");
        Assert.assertEquals(response.jsonPath().getString("data.employee_age"), "30");
    }

    @Test(priority = 6)
    public void deleteEmployee() {

        Response response =
                given()
                        .when()
                        .delete("/delete/" + createdEmployeeId)
                        .then()
                        .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("status"), "success");

        // Verify count decreased
        Response getResponse = given().get("/employees");
        int finalCount = getResponse.jsonPath().getList("data").size();

        Assert.assertEquals(finalCount, employeeCount - 1);
    }
}
