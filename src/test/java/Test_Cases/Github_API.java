package Test_Cases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Github_API {

	
	//@Test
	public void get_Request()
	{
		//Create a request
		//Send a request and get Response 
		//Validate the response
		
		
		RequestSpecification request=RestAssured.given().log().all();
		request.baseUri("https://api.github.com/repos");
		request.basePath("/Manzil-9129/PageObjectModel");
		Response response=request.get();
		ValidatableResponse validatableResponse=response.then();
		validatableResponse.statusCode(200);
		//System.out.println(response.getBody().asPrettyString());
		validatableResponse.extract().body().asPrettyString();
		
		
	 }
	
	@Test
	public void get_Request2(){
		
	String body=RestAssured.given().baseUri("https://api.github.com/repos")
	.basePath("{Owner}/{repo}").get("https://api.github.com/repos/{Owner}/{repo}","Manzil-9129","PageObjectModel")
	.then().statusCode(200)
	
	
	.extract().path("owner.login");
	
	Assert.assertEquals(body,"Manzil-9129");
	//System.out.println(body);
	}
	
	
	
	
	
	
	
	
	
}
