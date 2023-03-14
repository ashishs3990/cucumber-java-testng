package com.learn.cucumber.pages;

import com.learn.cucumber.base.execution.BaseWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseWebPage<HomePage> {

    @FindBy(className = "oxd-userdropdown-name")
    WebElement dashboardText;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isUserLoggedIn() {
        return dashboardText.isDisplayed();
    }
}
