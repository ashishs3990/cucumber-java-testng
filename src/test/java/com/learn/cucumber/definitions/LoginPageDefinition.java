package com.learn.cucumber.definitions;

import com.learn.cucumber.pages.HomePage;
import com.learn.cucumber.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class LoginPageDefinition {
    LoginPage loginPage;
    HomePage homePage;
    private WebDriver driver;

    @Before
    public void setup(Scenario scenario) {
        System.out.println("----" + scenario.getName() + "----");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Given("User is on HRMLogin page {string}")
    public void loginTest(String url) {
        driver.get(url);
    }

    @When("User enters username as {string} and password as {string}")
    public void goToHomePage(String userName, String passWord) {
        homePage = loginPage.login(userName, passWord);
    }

    @Then("User should be able to login successfully and new page open")
    public void verifyLogin() {
        Assert.assertEquals(homePage.isUserLoggedIn(), true);

    }

    @Then("User should be able to see error message {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {
        Assert.assertEquals(loginPage.isInvalidCredentials(), true);
    }


}
