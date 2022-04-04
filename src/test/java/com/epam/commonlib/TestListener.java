package com.epam.commonlib;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestListener implements ITestListener {

	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	static String date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	static String reportName = "Test-Report-" + date + ".html";
	static String path = System.getProperty("user.dir") + "/extentreports/" + reportName;

	public void onStart(ITestContext context) {
		System.out.println("onStart method started");
		htmlReporter = new ExtentSparkReporter(path);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setDocumentTitle("Let's Work Test");
		htmlReporter.config().setReportName("Let's work report");
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish method started");
		extent.flush();
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess Method" + result.getName());
		logger = extent.createTest(result.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure Method" + result.getName());
		logger = extent.createTest(result.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		logger.log(Status.FAIL, "TEST FAILED" + result.getThrowable());
	}

}
