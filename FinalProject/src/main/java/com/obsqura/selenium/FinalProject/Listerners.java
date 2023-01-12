package com.obsqura.selenium.FinalProject;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.ExtendedReportUtility;

public class Listerners implements ITestListener {

	ExtentTest test;

	ExtentReports extent=ExtendedReportUtility.getReportObject();
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();

@Override
public void onTestStart(ITestResult iTestResult) {
	ITestListener.super.onTestStart(iTestResult);
	test =extent.createTest(iTestResult.getMethod().getMethodName());
	extentTest.set(test);

    //System.out.println("onTestStart");
}

@Override
public void onTestSuccess(ITestResult iTestResult) {
    System.out.println("onTestSuccess");
}

@Override
public void onTestFailure(ITestResult iTestResult) {
    System.out.println("onTestFailure");
}

@Override
public void onTestSkipped(ITestResult iTestResult) {
    System.out.println("onTestSkipped");
}

@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    System.out.println("onTestFailedButWithinSuccessPercentage");
}

@Override
public void onStart(ITestContext iTestContext) {
    System.out.println("onTestFailedButWithinSuccessPercentage");
}

//@Override
/*public void onFinish(ITestContext iTestContext) {
	ITestListener.super.onFinish(iTestContext);
	extent.flush();
    System.out.println("onFinish");
    ITestListener.super.onFinish(iTestContext);
}*/
}
