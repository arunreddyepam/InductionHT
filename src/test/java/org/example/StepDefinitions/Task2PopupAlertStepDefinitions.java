package org.example.StepDefinitions;

import org.example.Pages.PopupAlertPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Task2PopupAlertStepDefinitions {

    WebDriver driver;
    WebDriverWait wait;
    PopupAlertPage popupAlertPage;

    @Given("I have a web browser open")
    public void i_have_a_web_browser_open() {
        driver = new EdgeDriver();
        popupAlertPage = new PopupAlertPage(driver);
        driver.get("https://demoqa.com/alerts#google_vignette");
    }

    @When("I click the button to trigger Alert 1")
    public void i_click_the_button_to_trigger_alert_1() {
        popupAlertPage.clickAlert1Button();
    }

    @Then("I should see the alert with message {string}")
    public void i_should_see_the_alert_with_message(String expectedMessage) {
        String actualMessage = popupAlertPage.getAlertText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @And("I accept the alert")
    public void i_accept_the_alert() {
        popupAlertPage.acceptAlert();

    }

    @When("I click the button to trigger Alert 2")
    public void i_click_the_button_to_trigger_alert_2() {
        popupAlertPage.clickAlert2Button();
    }

    @Then("I wait for the alert to appear")
    public void i_wait_for_the_alert_to_appear() {
        popupAlertPage.waitForAlert2();
    }

    @When("I click the button to trigger Alert 3")
    public void i_click_the_button_to_trigger_alert_3() {
        popupAlertPage.clickAlert3Button();
    }

    @And("I dismiss the alert")
    public void i_dismiss_the_alert() {
        popupAlertPage.dismissAlert();

    }

    @Then("I should see the cancel message {string}")
    public void i_should_see_the_cancel_message(String expectedMessage) {
        String actualMessage = popupAlertPage.getAlert3CancelMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @When("I click the button to trigger Alert 4")
    public void i_click_the_button_to_trigger_alert_4() {
        popupAlertPage.clickAlert4Button();
    }

    @When("I enter {string} in the alert")
    public void i_enter_in_the_alert(String inputText) {
        popupAlertPage.sendTextToAlert(inputText);

    }

    @Then("I should see the entered message {string}")
    public void i_should_see_the_entered_message(String expectedMessage) {
        String actualMessage = popupAlertPage.getAlert4Message();
        Assert.assertEquals(actualMessage, expectedMessage);

    }
    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}

