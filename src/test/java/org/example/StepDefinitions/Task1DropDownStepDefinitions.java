package org.example.StepDefinitions;

import org.example.Pages.SelectMenuPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Task1DropDownStepDefinitions {
    WebDriver driver;
    SelectMenuPage selectMenuPage;

    @Given("I am on the Select Menu page")
    public void i_am_on_the_select_menu_page() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        selectMenuPage = new SelectMenuPage(driver);
        selectMenuPage.open();
    }

    @When("I select {string} from the Modern Select dropdown")
    public void i_select_from_modern_select_dropdown(String option) {
        selectMenuPage.selectModernDropdown(option);
    }

    @When("I select {string} from the Modern Select one dropdown")
    public void i_select_from_modern_select_one_dropdown(String option) {
        selectMenuPage.selectModernOneDropdown(option);
    }

    @When("I select {string} from the Old Style Select Dropdown Menu")
    public void i_select_from_old_style_select_dropdown_menu(String option) {
        selectMenuPage.selectOldStyleDropdown(option);
    }

    @When("I select {string} from the Multiselect dropdown")
    public void i_select_from_multiselect_dropdown(String option) {
        selectMenuPage.selectMultiSelectDropdown(option);
    }

    @When("I select {string} and {string} from the Standard multi select dropdown")
    public void i_select_from_standard_multi_select_dropdown(String option1, String option2) {
        selectMenuPage.selectStandardMultiSelectDropdown(option1, option2);
    }

    @Then("the correct options should be selected in all dropdowns")
    public void the_correct_options_should_be_selected_in_all_dropdowns() {
        Assert.assertTrue(selectMenuPage.getModernDropdownSelected().contains("Group 1, option 1"));
        Assert.assertTrue(selectMenuPage.getModernOneDropdownSelected().contains("Mr."));
        Assert.assertEquals(selectMenuPage.getOldStyleDropdownSelected(), "Purple");
        Assert.assertTrue(selectMenuPage.isMultiSelectOptionSelected("Green"));
        Assert.assertTrue(selectMenuPage.isStandardMultiSelectOptionSelected("Volvo"));
        Assert.assertTrue(selectMenuPage.isStandardMultiSelectOptionSelected("Saab"));
        driver.quit();
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
