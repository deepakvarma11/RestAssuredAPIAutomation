package com.epam.scripts;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.commonlib.PropertyReaderWriter;
import com.epam.commonlib.TestBase;
import com.epam.pojo.Books;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test02GetListOfBooks extends TestBase {

	@Test
	public void getBooks() throws JSONException, IOException {
		// Get Books - No Auth is required for this.
		Response response = given().get("/BookStore/v1/Books").then().log().all().extract().response();

		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

		if (response.statusCode() == HttpStatus.SC_OK) {

			String jsonString = response.asString();

			JSONObject json = new JSONObject(jsonString);

			JSONArray jsonArray = json.getJSONArray("books");

			List<Books> books = new Gson().fromJson(jsonArray.toString(), new TypeToken<List<Books>>() {
			}.getType());

			List<Long> ListOfBooksISBN = books.stream()
					.filter(p -> (p.getPublisher().equals("No Starch Press")))
					.map(p -> p.getIsbn())
					.collect(Collectors.toList());

			ListOfBooksISBN.forEach(i -> System.out.println(i));

			Long isbn = ListOfBooksISBN.get(0);

			PropertyReaderWriter.addIntoProperties("bookId", String.valueOf(isbn));
		}

	}
}
