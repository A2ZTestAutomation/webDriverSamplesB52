package apiTesting;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateUpdateBookingTest {
 
  
    @Test
    public void createNewBooking() {
        File jsonFile = new File("src//test//resources//testData//booking.json");
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
//        Response response = RestAssured.post("/booking");
        Response resp = RestAssured.given()
                .accept("application/json")
                .contentType("application/json")
                .body(jsonFile)
                .post("/booking");
        System.out.println(resp.getStatusCode());
        Assert.assertEquals(resp.getStatusCode(), 200);
        System.out.println(resp.getStatusLine());
        System.out.println(resp.getBody().prettyPrint());
        JsonPath jsonPathEvaluator = resp.jsonPath();
        String fname = jsonPathEvaluator.get("booking.firstname");
        Assert.assertEquals(fname, "Anandhi");
     
    }
    
    @Test
    public void updateBooking() {
	  String strToken ="";
	  File bookingFile = new File("src//test//resources//testData//booking.json");
	      RestAssured.baseURI = "https://restful-booker.herokuapp.com";
	      File jsonFile = new File("src//test//resources//testData//user.json");
	         Response resp = RestAssured.given()
	              .accept("application/json")
	              .contentType("application/json")
	             .body(jsonFile)
	              .post("/auth");
	      resp.getBody().jsonPath().prettyPrint();
	      strToken = resp.getBody().jsonPath().getString("token");
	      System.out.println("Token Value...."+strToken);
	           
//	      Response putResp = RestAssured.given()
//	              .accept("application/json")
//	              .contentType("application/json")
//	              .cookie("token", strToken)
//	              .body(bookingFile)
//	              .put("/booking/200");
//	      System.out.println(putResp.getStatusCode());
//	      Assert.assertEquals(putResp.getStatusCode(), 200);
//	      System.out.println(putResp.getBody().prettyPrint());
//	      JsonPath jsonPathEvaluator = putResp.jsonPath();
//	        String fname = jsonPathEvaluator.get("firstname");
//	        Assert.assertEquals(fname, "Anandhi");
	      
	      Response delResp = RestAssured.given()
	              .contentType("application/json")
	              .cookie("token", strToken)
	              .delete("/booking/700");
	      System.out.println(delResp.getStatusCode());
	      System.out.println(delResp.getStatusLine());
	      Assert.assertEquals(delResp.getStatusCode(), 201);
	        
	        
    }
}
