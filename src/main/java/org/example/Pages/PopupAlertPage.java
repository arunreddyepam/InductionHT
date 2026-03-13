package org.example.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupAlertPage {
    WebDriver driver;
    WebDriverWait wait;

    public PopupAlertPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="alertButton")
    private WebElement alert1Button;

    @FindBy(id="timerAlertButton")
    private WebElement alert2Button;

    @FindBy(id="confirmButton")
    private WebElement alert3Button;

    @FindBy(id="promtButton")
    private WebElement alert4Button;

    @FindBy(id="confirmResult")
    private WebElement alert3CancelMessage;

    @FindBy(id="promptResult")
    private WebElement alert4Message;

    private void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickAlert1Button(){
        scrollToElement(alert1Button);
        alert1Button.click();
    }

    public void clickAlert2Button(){
        scrollToElement(alert2Button);
        alert2Button.click();
    }

    public void clickAlert3Button(){
        scrollToElement(alert3Button);
        alert3Button.click();
    }

    public void clickAlert4Button(){
        scrollToElement(alert4Button);
        alert4Button.click();
    }

    public String getAlertText(){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }

    public void acceptAlert(){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }

    public void sendTextToAlert(String text){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text);
    }

    public String getAlert3CancelMessage(){
        return alert3CancelMessage.getText();
    }

    public String getAlert4Message() {
        return alert4Message.getText();
    }

    public void waitForAlert2() {
        wait.until(ExpectedConditions.alertIsPresent());
    }
}