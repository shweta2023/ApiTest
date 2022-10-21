package com.Test.Helpers;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.utilities.CommonUtilities;

import io.restassured.response.Response;

public class ReusabaleApiMethods {
	public static CommonUtilities CU = new CommonUtilities();
    public static  Properties applicationPropertiesFile = CU.loadfile("applicationProperties");
    
    public static String getBaseUri() {
    	String baseURI = CU.getApplicationProperty("Baseuri",applicationPropertiesFile);
    	return baseURI;
    }
	
	
}
