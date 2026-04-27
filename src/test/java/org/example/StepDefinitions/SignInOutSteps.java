package org.example.StepDefinitions;

import org.example.context.TestContextNew;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SignInOutSteps {

    private final TestContextNew context;

    // Same TestContext injected here — shared state across step classes
    public SignInOutSteps(TestContextNew context) {
        this.context = context;
    }

    @When("the user enters login email {string} and password {string}")
    public void user_enters_login_credentials(String email, String password) {
        context.getLoginPage().enterLoginEmail(email);
        context.getLoginPage().enterLoginPassword(password);
        context.setData("loginEmail", email);
    }

    @And("clicks on the Login button")
    public void clicks_login_button() {
        context.getLoginPage().clickLogin();
    }

    @Then("the user should be logged in successfully")
    public void user_logged_in() {
        Assert.assertTrue(context.getHomePage().isLoggedInDisplayed(),
                "User is NOT logged in");
    }

    @And("a {string} message should be displayed")
    public void logged_in_message_displayed(String expectedText) {
        String actualText = context.getHomePage().getLoggedInText();
        Assert.assertTrue(actualText.contains(expectedText),
                "Expected: " + expectedText + " | Actual: " + actualText);
    }

    @When("the user clicks on the Logout link")
    public void user_clicks_logout() {
        context.getHomePage().clickLogout();
    }

    @Then("the user should be redirected to the login page")
    public void redirected_to_login_page() {
        Assert.assertTrue(context.getLoginPage().isLoginPageDisplayed(),
                "User not redirected to login page");
    }

    @Then("the user should remain on the login page")
    public void user_remains_on_login_page() {
        Assert.assertTrue(context.getLoginPage().isLoginPageDisplayed(),
                "User is not on login page");
    }
}
