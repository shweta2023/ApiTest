package com.utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;


public class CommonUtilities {
	/*public static String readPropertiescontent(String key)throws IOException  {
		FileInputStream file = new FileInputStream(Constants.APPPLICATION_PROPERTIES_PATH);
		Properties ob = new Properties();
		ob.load(file);
		file.close();
	    String value = ob.getProperty(key);
		return value;
		
	}*/
public FileInputStream stream = null;
public Properties loadfile(String filename) {
Properties propertyFile = new Properties();
String propertyFilePath = null;
switch(filename) {
case "applicationProperties":
	propertyFilePath = Constants.APPPLICATION_PROPERTIES_PATH;
                       break;
case "studentProperties":
	propertyFilePath = Constants.STUDENT_PROPERTIES_PATH;
                         break;
                         
}
try {
	stream = new FileInputStream(propertyFilePath);
	propertyFile.load(stream);
}
catch (IOException e){
	e.printStackTrace();
}
return propertyFile;

}
public String getApplicationProperty(String Key,Properties propertyFile) {
	String value = propertyFile.getProperty(Key);
	System.out.println("Property we got from the file is ::"+ value);
	try {
		stream.close();;
	}
	catch (IOException e){
		e.printStackTrace();
	}
	return value;
	
}
public HashMap getAllpropertiesAsSet(Properties propertyFile) {
	return new HashMap(propertyFile);
}





}

