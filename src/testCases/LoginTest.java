package testCases;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;

import helpers.TestBase;


//JUnit will run this test using dynamic test data as parameters
@RunWith(value = Parameterized.class)
public class LoginTest extends TestBase {

	String username;
	String password;


	//This is the method where the test data is loaded
	@Parameters
	public static Collection<String[]> testData() {
		return Arrays.asList(new String[][] {
				{ "gurdip.gill@edt.co.uk", "gurdip.gill@edt.co.uk" },

		});
	}
	
	
	
	//Test data is passed to this method to be stored globally
	public LoginTest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	
	
	//This test method is repeated for each set of test data
	@Test
	public void loginTest1() {
		util.login(username, password);

		boolean isSignOffVisible = driver.findElement(By.linkText("LOG OUT")).isDisplayed();
		assertTrue(isSignOffVisible);
	}

}
