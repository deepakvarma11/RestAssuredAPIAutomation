package com.epam.scripts;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.commonlib.PropertyReaderWriter;
import com.epam.commonlib.TestBase;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test01Authorization extends TestBase {

	@Test
	public void authorization() throws IOException {
		Response response = given().header("Content-Type", "application/json")
				.body("{ \"userName\":\"" + userName + "\", \"password\":\"" + password + "\"}")
				.post("/Account/v1/GenerateToken").then().log().all().extract().response();
		
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

		if (response.getStatusCode() == HttpStatus.SC_OK) {

			String jsonString = response.asString();
			Assert.assertTrue(jsonString.contains("token"));

			String token = JsonPath.from(jsonString).get("token");

			PropertyReaderWriter.addIntoProperties("token", token);
		}
	}

}
