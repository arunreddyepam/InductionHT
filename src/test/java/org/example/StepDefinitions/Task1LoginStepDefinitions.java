package org.example.StepDefinitions;

import org.example.Pages.SeleniumTask1LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Task1LoginStepDefinitions {
    WebDriver driver;
    SeleniumTask1LoginPage loginPage;
    WebDriverWait wait;
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage = new SeleniumTask1LoginPage(driver);
    }
    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
    }
    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();

    }
    @Then("I should see the successful login message {string}")
    public void i_should_see_the_successful_login_message(String expectedMessage) {
        String actualMessage = loginPage.getSuccessFlashMessage();

        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @When("I enter invalid username and valid password")
    public void i_enter_invalid_username_and_valid_password() {
        loginPage.enterUsername("invalidUser");
        loginPage.enterPassword("SuperSecretPassword!");
    }

    @Then("I should see the error message {string}")
    public void i_should_see_the_error_message(String expectedMessage) {
        String actualMessage = loginPage.getErrorFlashMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @When("I enter valid username and invalid password")
    public void i_enter_valid_username_and_invalid_password() {
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("invalidPassword");
    }
    @When("I click the logout button")
    public void i_click_the_logout_button() {
        loginPage.clickLogOutButton();
    }
    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://the-internet.herokuapp.com/login";

        Assert.assertTrue(currentUrl.contains(expectedUrl));
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
