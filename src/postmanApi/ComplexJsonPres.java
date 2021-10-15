package postmanApi;

import io.restassured.path.json.JsonPath;

public class ComplexJsonPres {
	
	
	public static void main(String []args) {
		

	JsonPath js= new JsonPath(paload.CoursePrize());
	
	int count =js.getInt("courses.size");
	System.out.println(count);
	int totalcount= js.getInt("dashboard.purchaseAmount");
	System.out.println(totalcount);
	//String course=js.getString("courses[0].title");
	//System.out.println(course);
	//String course=js.getString("courses[2].title");
	//System.out.println(course);
	for(int i =0; i<count;i++)
	{
		String couresTitles =js.get("courses["+i+"].title");
		System.out.println(js.get("courses["+i+"].price").toString());
		System.out.println(couresTitles);
	   // js.get("course["+i+"].price");
		//System.out.println(price);
	}
	System.out.println("No of copy sold by RPA");
	
	for(int i =0; i<count;i++) {
	
		String couresTitles =js.get("courses["+i+"].title");
		if (couresTitles.equals("RPA")) {
			int copies =js.get("courses["+i+"].copies");
			System.out.println(copies);
			break;
		}
		
		
		
		
	   // js.get("course["+i+"].price");
		//System.out.println(price);
	}
}
}