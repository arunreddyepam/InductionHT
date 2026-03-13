package org.example.StepDefinitions;

import org.example.Pages.BDDLoginPage;
import org.example.context.TestContext;
import io.cucumber.java.en.*;

public class BDDTaskLoginSteps {

    private TestContext context;
    private BDDLoginPage loginPage;

    public BDDTaskLoginSteps(TestContext context) {
        this.context = context;
        loginPage = new BDDLoginPage(context.getDriver());
    }

    @When("User enters valid email and password")
    public void enter_credentials() {
        loginPage.enterLoginCredentials("test@test.com", "123456");
    }

    @When("User clicks login")
    public void click_login() {
        loginPage.clickLogin();
    }
}
