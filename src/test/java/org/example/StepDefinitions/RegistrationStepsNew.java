package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.context.TestContextNew;
import org.testng.Assert;

public class RegistrationStepsNew {

    private final TestContextNew context;

    // PicoContainer injects TestContext automatically
    public RegistrationStepsNew(TestContextNew context) {
        this.context = context;
    }

    @Given("the user is on the home page")
    public void user_is_on_home_page() {
        context.getHomePage().open();
    }

    @When("the user clicks on the Signup\\/Login link")
    public void user_clicks_signup_login() {
        context.getHomePage().clickSignupLogin();
    }

    @When("enters name {string} and email {string}")
    public void enters_name_and_email(String name, String email) {
        context.getSignupPage().enterSignupName(name);
        context.getSignupPage().enterSignupEmail(email);
        context.setData("signupEmail", email);
    }

    @When("clicks on the Signup button")
    public void clicks_signup_button() {
        context.getSignupPage().clickSignup();
    }

    @Then("the user should be navigated to the account information page")
    public void navigated_to_account_info() {
        Assert.assertTrue(context.getSignupPage().isAccountInfoPageDisplayed(),
                "Account info page not displayed");
    }

    @When("the user fills account information with password {string}")
    public void fill_account_info(String password) {
        context.getAccountPage().fillAccountInformation(password);
    }

    @And("fills the address details")
    public void fill_address_details() {
        context.getAccountPage().fillAddressDetails();
    }

    @And("clicks on the Create Account button")
    public void clicks_create_account() {
        context.getAccountPage().clickCreateAccount();
    }

    @Then("the account should be created successfully")
    public void account_created_successfully() {
        Assert.assertTrue(context.getAccountPage().isAccountCreated(),
                "Account was not created");
    }

    @Then("an error message {string} should be displayed")
    public void error_message_displayed(String expectedMsg) {
        String actualMsg = context.getSignupPage().getSignupErrorMessage();
        Assert.assertTrue(actualMsg.contains(expectedMsg),
                "Expected: " + expectedMsg + " | Actual: " + actualMsg);
    }

    @Then("a validation message should be displayed for the name field")
    public void validation_for_name_field() {
        String msg = context.getSignupPage().getNameFieldValidationMessage();
        Assert.assertFalse(msg.isEmpty(), "No validation message for name field");
    }

    @Then("a validation message should be displayed for the email field")
    public void validation_for_email_field() {
        String msg = context.getSignupPage().getEmailFieldValidationMessage();
        Assert.assertFalse(msg.isEmpty(), "No validation message for email field");
    }
}
