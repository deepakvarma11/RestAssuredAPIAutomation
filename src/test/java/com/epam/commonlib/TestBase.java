package com.epam.commonlib;

import static io.restassured.RestAssured.baseURI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	protected final String userID = "4140da0e-16e6-4a47-8c2c-96b7199f7cf0";
	protected final String userName = "deepakvarma";
	protected final String password = "Deepak@12";
	protected final String baseUrl = "https://bookstore.toolsqa.com";

	public static Logger logs = Logger.getLogger(TestBase.class);

	@BeforeSuite
	public void beforeSuite() {
		baseURI = baseUrl;

		logs.info("Excecution Started Before suite");
	}

	@AfterSuite
	public void afterSuite() {
		logs.info("After suite");
	}

}
