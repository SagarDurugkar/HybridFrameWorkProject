package com.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utilities.ExtentReporter;
import com.utilities.Utilis;

public class MyListeners implements ITestListener {

	ExtentReports extentReport;
	ExtentTest extentTest;
	// String testName;

	public void onStart(ITestContext context) {
		extentReport = ExtentReporter.generateExtentReport();
	}

	public void onTestStart(ITestResult result) {
		// testName = result.getName();
		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName() + " Started Executing...");
		// System.out.println(testName+" Started Executing...");

	}

	public void onTestSuccess(ITestResult result) {

		// String testName = result.getName();
		extentTest.log(Status.PASS, result.getName() + " Successfully Executed...");
		// System.out.println(testName+" Successfully Executed...");

	}

	public void onTestFailure(ITestResult result) {

		// String testName = result.getName();
		// System.out.println(testName+" Got Failed...");
		// System.out.println(result.getThrowable());
		// System.out.println("Screenshot Taken");

		WebDriver driver = null;
		// WebDriver driver =
		// (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}

//		File srcsrcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		String destinationSereenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
//		try {
//			FileHandler.copy(srcsrcScreenshot, new File(destinationSereenshotPath));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		String destinationSereenshotPath = Utilis.captureScreenshot(driver, result.getName());

		extentTest.addScreenCaptureFromPath(destinationSereenshotPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, result.getName() + " Got Failed...");

	}

	public void onTestSkipped(ITestResult result) {
		// String testName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName() + " Got Skipped...");
		// System.out.println(testName+" Got Skipped...");
		// System.out.println(result.getThrowable());

	}

	public void onFinish(ITestContext context) {
		// System.out.println("Execution of Project Finished...");

		extentReport.flush();

		String pathOfExtentReport = System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html";
		File extentReport = new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
