package autm.headless.parallel.tests;

import org.testng.annotations.Test;

import autm.headless.parallel.base.BaseTest;
import autm.headless.parallel.data.TestDataProvider;
import autm.headless.parallel.pages.RegisterPage;

/**
 * RegisterTest verifies that users can successfully register.
 * 
 * Test data is supplied via TestNG DataProvider
 * and runs in parallel for multiple users.
 */
public class RegisterTest extends BaseTest {
	
	/**
	 * Test method that registers a user using data from DataProvider
	 */
	@Test(dataProvider = "registerUsers", dataProviderClass = TestDataProvider.class)
    public void userCanRegister(
    		String gender,
    		String firstName,
    		String lastName,
    		String email,
    		String company,
    		boolean subscribeNewsletter,
    		String password) throws InterruptedException {

		// Create page object
		RegisterPage registerPage = new RegisterPage(driver);

		// Perform registration
		registerPage.registerUser(
				gender,
				firstName,
				lastName,
				email,
				company,
				subscribeNewsletter,
				password
		);

		// Example static test call (commented out)
        //registerPage.registerUser("male", "John","Doe","john"+System.currentTimeMillis()+"@mail.com", "ABC Company", true , "Password123!" );
  
    }

}