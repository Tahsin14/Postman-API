package Pojo;
import  io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
// all those static package import
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SserializeTest {
	public static void main (String args[])
	{
		
		addPlace p = new addPlace();
		p.setAccuracy(50);
		p.setAddress("974, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://google.com");
		p.setName("Frontline house");
		List<String> mylist=new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shop");
		p.setTypes(mylist);
		location l= new location();
		l.setLng(-38.383494);
		l.setLat(33.427362);
		p.setLocation(l);
	    RequestSpecification req=	new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclck123")
		.setContentType(ContentType.JSON).build();
		//RestAssured.baseURI="https://rahulshettyacademy.com";
	    RequestSpecification res =  	given().spec(req)
		.body(p);
	   
	   
		Response response=res.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response();
	
	response.asString();
	String responseString=response.asString();
	System.out.println(responseString);
	}
	
	
	

}
