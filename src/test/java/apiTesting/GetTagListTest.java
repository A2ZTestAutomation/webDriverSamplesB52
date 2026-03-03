package apiTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetTagListTest {
  @Test
  public void listTag() {
      RestAssured.baseURI = 
	      "https://conduit-realworld-example-app.fly.dev";
      Response response = RestAssured.get("/api/tags");
      int statusCode = response.getStatusCode();
      Assert.assertEquals(statusCode, 200);
      System.out.println(response.statusLine());
      Assert.assertEquals(response.getContentType(),
              "application/json; charset=utf-8");
      // Retrieve the body of the Response
      ResponseBody body = response.getBody();
      String bodyAsString = body.asString();
      System.out.println(bodyAsString);
  }
  @Test
  public void getPetList() {
      RestAssured.baseURI ="https://petstore.swagger.io"; 
      
      Response response = RestAssured.given()
              .accept("application/json")
              .queryParam("api_key", "******")
              .queryParam("status", "available")
              .get("/pet/findByStatus");
	String jsonString = response.asString();
	System.out.println(response.getStatusCode()); 
	System.out.println(jsonString);
	
	}

  }
  



