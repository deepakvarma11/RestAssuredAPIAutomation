package com.epam.scripts;

import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.serializer.SerializeException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.commonlib.PropertyReaderWriter;
import com.epam.commonlib.TestBase;
import com.epam.pojo.ISBN;
import com.epam.pojo.ListOfBooks;

import io.restassured.response.Response;

public class Test03AddBooksToUser extends TestBase {

	@Test
	public void addBooksToUser() throws SerializeException {

		String isbn = PropertyReaderWriter.getProperty("bookId");
		String token = PropertyReaderWriter.getProperty("token");

		ISBN[] isbn1 = { new ISBN(isbn) };
		ListOfBooks list = new ListOfBooks(userID, isbn1);

		JsonSerializer jsonSer = JsonSerializer.DEFAULT;
		String jsonBody = jsonSer.serialize(list);

		System.out.println(jsonBody);

		Response res = given().header("Authorization", "Bearer " + token).header("Content-Type", "application/json")
				.body(jsonBody).post("/BookStore/v1/Books").then().log().all().extract().response();
		Assert.assertEquals(HttpStatus.SC_CREATED, res.getStatusCode());

//		"{ \"userId\": \"" + userID + "\", " + "\"collectionOfIsbns\": [ { \"isbn\": \"" + bookId
//		+ "\" } ]}"
	}

}
