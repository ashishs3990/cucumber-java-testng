package com.learn.cucumber.base.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        System.out.println("TestListener.onStart");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("TestListener.onTestFailure");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("TestListener.onTestSuccess");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("TestListener.onFinish");
    }
}
