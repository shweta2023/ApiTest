package com.Api_tests;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.hamcrest.Matchers;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Test.Helpers.ReusabaleApiMethods;
import com.Tests.Models.ConvertResponseToPojo;
import  com.utilities.Endpoints;

import com.utilities.CommonUtilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.utilities.*;
public class Api_TestCases extends ReusabaleApiMethods{
	private static Response response;
	private static ConvertResponseToPojo ob;

	
	@BeforeMethod
	public static void setUp() {
		RestAssured.baseURI= "https://dummy.restapiexample.com/api/v1/";

	}
	@Test(priority = 1)
	public static  void TC_01Get() {

		response = RestAssured.given()
 			   .when()
 			   .get("employees");
		response.then().statusCode(200);
        response.then().body("status",Matchers.equalTo("success"))
 	    .log().all();
	    System.out.println("num of data ="+response.jsonPath().get("data.size()"));
	    //getting response in pojo
	    //ob = response.getBody().as(ConvertResponseToPojo.class);
	    ConvertResponseToPojo[]	ob=response.as(ConvertResponseToPojo[].class);
	}
	@Test(priority = 2)
	public static  void TC_02post() {
		ConvertResponseToPojo ob = new ConvertResponseToPojo ();
		ob.setEmployeeName("test");
	    ob.setEmployeeAge(23);
	   ob.setEmployeeSalary(123);
	   
		response = RestAssured.given()
				
		        .body(ob)
				.when()
				.post("create");
			
		response.then().statusCode(200);
        response.then().body("status",Matchers.equalTo("success"))
 	    .log().all();
	    System.out.println("num of data ="+response.jsonPath().get("data.size()"));	
	    ob = response.getBody().as(ConvertResponseToPojo.class);
	   
	}
	
	@Test(priority = 3)
	public static  void TC_03delete() {
		String id = "2159";
		response = RestAssured.given()
 			   .when()
 			   .delete("delete/" + id);
		       
		response.then().statusCode(200);
        response.then().body("status",Matchers.equalTo("success"))
 	    .log().all();
        response.then().body("data",Matchers.equalTo(id));

	}
	@Test(priority = 4)
	public static  void TC_04delete() {
		String id = "0";
		response = RestAssured.given()
 			   .when()
 			   .delete("delete/" + id);
		       
		response.then().statusCode(400);
        response.then().body("status",Matchers.equalTo("error"))
 	    .log().all();
       

	}
	@Test(priority = 5)
	public static  void TC_005Get() {
		int id =2;
		response = RestAssured.given()
 			   .when()
 			   .get("/employees");
		response.then().statusCode(200);
		response.then().contentType(ContentType.JSON);
		String employeename =response.path("data.find{it.id=="+id+"}.employee_name");
		int employee_salary =response.path("data.find{it.id=="+id+"}.employee_salary");
		int employee_age =response.path("data.find{it.id=="+id+"}.employee_age");

		System.out.println("Employeename: "+employeename);
		System.out.println("employee_salary: "+employee_salary);
		System.out.println("employee_age: "+employee_age);

		response.then().body("data.find{it.id=="+id+"}.employee_name",equalTo("Garrett Winters"));
        response.then().body("status",Matchers.equalTo("success"))
 	    .log().all();
		response.then().body("data.find{it.id=="+id+"}.employee_salary",equalTo(170750));
		response.then().body("data.find{it.id=="+id+"}.employee_age",equalTo(63));


}
	/*
	@AfterMethod
	public static void tearDown() {
		report.logTestInfo("After method execution has started");
	}
	@AfterTest
	public static void tearDownAfterTest() {

			report.endReport();
*/
	}
