package com.learn.cucumber.runners;

import com.learn.cucumber.base.listeners.TestListener;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;

public class CucumberTestRunner {
    @CucumberOptions(
            tags = "@sanity",
            features = {"src/test/resources/features/login"},
            glue = {"com.learn.cucumber.definitions"},
            monochrome = true,
            plugin = {"html:target/html-report/report.html", "json:target/json-report/report.json", "testng:target/xml-report/report.xml", "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
    )
    public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
        @Before
        public void before() {
            System.out.println("CucumberRunnerTests.before");
        }
    }
}
