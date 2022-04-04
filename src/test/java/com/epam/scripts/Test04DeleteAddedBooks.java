package com.epam.scripts;

import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.serializer.SerializeException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.commonlib.PropertyReaderWriter;
import com.epam.commonlib.TestBase;
import com.epam.pojo.DeleteBook;

import io.restassured.response.Response;

public class Test04DeleteAddedBooks extends TestBase {

	@Test
	public void deleteBooksAdded() throws SerializeException {
		String isbn = PropertyReaderWriter.getProperty("bookId");
		String token = PropertyReaderWriter.getProperty("token");

		DeleteBook deleteBookJson = new DeleteBook(isbn, userID);

		JsonSerializer jsonSer = JsonSerializer.DEFAULT;
		String jsonBody = jsonSer.serialize(deleteBookJson);

		System.out.println(jsonBody);

		Response response = given().header("Authorization", "Bearer " + token)
				.header("Content-Type", "application/json").body(jsonBody).delete("/BookStore/v1/Book").then().log()
				.all().extract().response();

		Assert.assertEquals(204, response.getStatusCode());

//		/"{ \"isbn\": \"" + bookId + "\", \"userId\": \"" + userID + "\"}"
	}

}
