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



import helpers.TestBase;


//JUnit will run this test using dynamic test data as parameters
@RunWith(value = Parameterized.class)
public class ResetPassword extends TestBase {
	String username;
	//String password;

	//Test data is passed to this method to be stored globally
	public ResetPassword(String username, String password) {
		this.username = username;
	}

	

	//This test method is repeated for each set of test data
	@Test
	public void ResetPasswordForAccount() {


		// Retrieving web page title
				String title2 = driver.getTitle();
				System.out.println("The page title is : " + title2);
				
		// click reset your password
		driver.findElement(By.xpath("//*[@id=\"content\"]/section/nav/ul/li[3]/a")).click();
		
		// type in email address of forgotten password
		driver.findElement(By.xpath("//*[@id=\"edit-name\"]")).sendKeys("gurdip.gill@edt.zone");
				
		// click submit
		driver.findElement(By.xpath("//*[@id=\"edit-submit\"]")).click();
		
		

		
		
		
		
		
	
	
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
			//file.close();
		}
		file.close();
		return records;
	}



}





