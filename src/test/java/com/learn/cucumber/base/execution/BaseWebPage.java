package com.learn.cucumber.base.execution;

import org.openqa.selenium.WebDriver;

public class BaseWebPage<T extends BaseWebPage<T>> {
    protected WebDriver driver;

    protected BaseWebPage(WebDriver driver) {
        this.driver = driver;
    }
}
