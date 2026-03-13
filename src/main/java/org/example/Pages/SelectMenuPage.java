package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class SelectMenuPage {
    WebDriver driver;
    WebDriverWait wait;

    public SelectMenuPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Modern Select dropdown
    @FindBy(id = "withOptGroup")
    public WebElement modernSelectDropdown;

    @FindBy(xpath = "//div[@id='withOptGroup']//div[contains(@class,'singleValue')]")
    public WebElement modernSelectSelectedValue;

    // Modern Select One dropdown
    @FindBy(id = "selectOne")
    public WebElement modernSelectOneDropdown;

    @FindBy(xpath = "//div[@id='selectOne']//div[contains(@class,'singleValue')]")
    public WebElement modernSelectOneSelectedValue;

    // Old Style Select Dropdown
    @FindBy(id = "oldSelectMenu")
    public WebElement oldStyleSelectDropdown;

    // Multiselect dropdown (Modern)
    @FindBy(xpath = "//div[@class=\" css-1wa3eu0-placeholder\"]")
    public WebElement multiSelectDropdown;


    @FindBy(xpath = "//b[text()='Multiselect drop down']/..//following-sibling::div//child::div[@class='css-12jo7m5']")

    public List<WebElement> multiSelectSelectedOptions;

    // Standard multi select dropdown
    @FindBy(id = "cars")
    public WebElement standardMultiSelectDropdown;

    // Actions
    public void open() {
        driver.get("https://demoqa.com/select-menu");
    }
    public void clickOutside() {
        // Click on the page header or any neutral area to close open dropdowns
        driver.findElement(By.cssSelector("body")).click();
    }

    // Modern Select dropdown (dynamic)
    public void selectModernDropdown(String option) {
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", modernSelectDropdown);
        modernSelectDropdown.click();
        WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text()='" + option + "']")));
        optionElement.click();
    }

    public String getModernDropdownSelected() {
        return modernSelectSelectedValue.getText();
    }

    public void selectModernOneDropdown(String option) {
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", modernSelectOneDropdown);
        modernSelectOneDropdown.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text()='" + option + "']"))).click();


    }

    public String getModernOneDropdownSelected() {
        return modernSelectOneSelectedValue.getText();
    }

    // Old Style Select Dropdown
    public void selectOldStyleDropdown(String option) {
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", oldStyleSelectDropdown);
        Select select = new Select(oldStyleSelectDropdown);
        select.selectByVisibleText(option);
    }

    public String getOldStyleDropdownSelected() {
        Select select = new Select(oldStyleSelectDropdown);
        return select.getFirstSelectedOption().getText();
    }

    // Multiselect dropdown (Modern, dynamic)
    public void selectMultiSelectDropdown(String option) {
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", multiSelectDropdown);
        multiSelectDropdown.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text()='" + option + "']"))).click();
        clickOutside();
    }

    public boolean isMultiSelectOptionSelected(String option) {
        return multiSelectSelectedOptions.stream().anyMatch(e -> e.getText().equalsIgnoreCase(option));
    }

    // Standard multi select dropdown
    public void selectStandardMultiSelectDropdown(String option1, String option2) {
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", standardMultiSelectDropdown);

        Select select = new Select(standardMultiSelectDropdown);
        select.selectByVisibleText(option1);
        select.selectByVisibleText(option2);
    }

    public boolean isStandardMultiSelectOptionSelected(String option) {
        Select select = new Select(standardMultiSelectDropdown);
        return select.getAllSelectedOptions().stream().anyMatch(e -> e.getText().equalsIgnoreCase(option));
    }
}
