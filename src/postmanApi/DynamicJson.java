package postmanApi;


import  io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
// all those static package import
import static org.hamcrest.Matchers.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DynamicJson {

	@Test(dataProvider="BooksData")
	public void addbook(String isbn,String aisle) {
		
		RestAssured.baseURI="http://216.10.245.166";
	String responce =given().header("Content-Type","application/json")
		.body(paload.addbook(isbn,aisle))
		.when().log().all().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
	
		
	  JsonPath js= new JsonPath(responce); //for passing json
	  String ID=js.get("ID");
	  System.out.println(ID);
	  String message=js.get("Msg");
	  System.out.println(message);
	
	}
	
	
@DataProvider(name="BooksData")
public Object getData() {
	
	//Array is a collectin of data 
	return new Object[][] {{"657","56"},{"hg","78"},{"jk","08"}};
	
}
}
