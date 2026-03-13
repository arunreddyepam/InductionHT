package org.example.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.Pages.BDDHomePage;
import org.example.context.TestContext;

public class RegistrationSteps {

    private TestContext context;
    private BDDHomePage homePage;

    public RegistrationSteps(TestContext context) {
        this.context = context;
        homePage = new BDDHomePage(context.getDriver());
    }

    @Given("User is on home page")
    public void user_is_on_home_page() {
        homePage.openHomePage();
    }

    @When("User clicks on sign in")
    public void user_clicks_sign_in() {
        homePage.clickSignIn();
    }
}
