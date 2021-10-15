package postmanApi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class SumValidation {
	
	@Test
	public void sumofCources()
	{
		int sum=0;
		JsonPath js= new JsonPath(paload.CoursePrize());
		int count=js.getInt("courses.size()");
		for(int i=0; i<count; i++)
		{
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			int amount = price*copies;
			System.out.println(amount);
			// add total ammount
			sum = sum + amount;
			
			
		}
		
		System.out.println("Total ammount is " +sum);
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount);
		
	}
}
