package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadProperties {

	@Test
	public void readData() throws IOException
	{
		//Create an object for Properties
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(new File("./src/main/resources/config.properties"));
		prop.load(fis);
		
		//Retrieve the data from Property file
		
		System.out.println(prop.get("url"));
		System.out.println(prop.get("username"));
		System.out.println(prop.get("password"));
		
	}
}
