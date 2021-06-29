package testCases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;



import org.openqa.selenium.JavascriptExecutor;

import helpers.TestBase;


//JUnit will run this test using dynamic test data as parameters
@RunWith(value = Parameterized.class)
public class MyAccount extends TestBase {
	String username;
	String password;

	//Test data is passed to this method to be stored globally
	public MyAccount(String username, String password) {
		this.username = username;
		this.password = password;
	}

	

	//This test method is repeated for each set of test data
	@Test
	public void Homepage1() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		util.login(username, password);

		// Retrieving web page title
				String title2 = driver.getTitle();
				System.out.println("The page title is : " + title2);
				
		// register interest for virtual event
		driver.findElement(By.xpath("//*[@id=\"block-views-block-webinars-block-1\"]/div/div/div/div[2]/div[1]/div/div[5]/span/div/a")).click();
		// view webinar for virtual event
		driver.findElement(By.xpath("//*[@id=\"block-views-block-webinars-block-1\"]/div/div/div/div[2]/div[1]/div/div[6]/div/a")).click();
		// check register interest for virtual event on webinar page
		driver.findElement(By.xpath("//*[@id=\"block-system-main-block\"]/div/article/div/div/div")).click();
		
		// This  will scroll down the page by  1000 pixel vertical		
        js.executeScript("window.scrollBy(0,1000)");
		
		// check agenda virtual event on webinar page
		driver.findElement(By.xpath("//*[@id=\"quicktabs-apslive-event-content\"]/div[1]/ul/li[2]/a")).click();
		// check Faculty virtual event on webinar page
		driver.findElement(By.xpath("//*[@id=\"quicktabs-apslive-event-content\"]/div[1]/ul/li[3]/a")).click(); 
		
		
		
		
		
		
	
	
}
	

	
	@Parameters
	public static Collection<String[]> testData() throws IOException {
		return getTestData("src/loginTestData.csv");
	}

	
	public static Collection<String[]> getTestData(String fileName) throws IOException {
		List<String[]> records = new ArrayList<String[]>();
		String record;
		BufferedReader file = new BufferedReader(new FileReader(fileName));
		while ((record = file.readLine()) != null) {
			String fields[] = record.split(",");
			records.add(fields);
			
		}
		file.close();
		return records;
	}



}





