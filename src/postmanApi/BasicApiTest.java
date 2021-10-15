package postmanApi;

import  io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
// all those static package import
import static org.hamcrest.Matchers.*;

public class BasicApiTest {
	public  static void main(String []args) {
		
		
		// Add place is working as excepted
		
		// given- all input details;
		// when-  Submit the API
		// Then - validate the responswe
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
	String response=	given().log().all().queryParam("key", "qaclick123").header("content-type","application/json").body(paload.Addplace() 
				).when().post(" /maps/api/place/add/json").then().log().all().assertThat().statusCode(200).body("scope", equalTo( "APP"))
		.header("server", "Apache/2.4.18 (Ubuntu")
		.extract().response().asString();
	//	System.out.println(response);
		
	JsonPath js= new JsonPath(response); //for passing json
	
		String placeid=js.get("place_id");
		System.out.println(placeid);
		
		//Update place
		given().log().all().queryParam("key", "qaclick123").header("content-type","application/json" ).body(
				"{\r\n" + 
				"\"place_id\":\""+placeid+"\",\r\n" + 
				"\"address\":\"71 winter walk, USA\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				 
	"}").when().post("/maps/api/place/update").then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address sucessfully updated"));
		
		
	//Get Place
		String ngetaddress="fdgfjjhg";
		given().queryParam("key", "qaclick123").queryParam("place_id", placeid).get("/maps/api/place/get/json").then().assertThat()
		.statusCode(200).log().all().extract().response().asString();
		JsonPath js1= new JsonPath(ngetaddress);
		
		//Assert.assertEquals("","");
	}
	}

	
