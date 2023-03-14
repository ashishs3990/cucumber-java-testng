package com.learn.cucumber.pages;

import com.learn.cucumber.base.execution.BaseWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseWebPage {
    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement login;

    @FindBy(xpath = "//div[@class='oxd-alert oxd-alert--error']//descendant::p[text()='Invalid credentials']")
    private WebElement errorInvalidCredentials;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        this.username.clear();
        this.username.sendKeys(username);
    }

    public void enterPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
    }

    public void pressLogin() {
        this.login.click();
    }

    public HomePage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        pressLogin();
        //wait
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        HomePage homePage = new HomePage(driver);
        return homePage;
    }

    public boolean isInvalidCredentials() {
        return errorInvalidCredentials.isDisplayed();
    }

}
