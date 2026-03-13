package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumTask1LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id="username")
    private WebElement usernameFiled;
    @FindBy(id="password")
    private WebElement passwordFiled;
    @FindBy(xpath= "//i[@class='fa fa-2x fa-sign-in']")
    private WebElement loginButton;
    @FindBy (xpath="//div[@class='flash success']")
    private WebElement successflash;
    @FindBy(xpath= "//i[text()= ' Logout']")
    private WebElement logoutButton;
    @FindBy (xpath="//div[@class='flash error']")
    private WebElement errorFlash;

    public SeleniumTask1LoginPage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        PageFactory.initElements(driver,this);
    }
    public void enterUsername(String username){
        usernameFiled.sendKeys(username);
    }
    public void enterPassword(String password){
        passwordFiled.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
    public String getSuccessFlashMessage(){
        wait.until(driver -> successflash.isDisplayed());
        return successflash.getText();
    }
    public void clickLogOutButton(){
        logoutButton.click();
    }
    public String getErrorFlashMessage(){
        wait.until(driver -> errorFlash.isDisplayed());
        return errorFlash.getText();
    }


}
