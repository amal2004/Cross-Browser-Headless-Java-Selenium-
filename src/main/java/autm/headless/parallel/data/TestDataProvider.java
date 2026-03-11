package autm.headless.parallel.data;

import org.testng.annotations.DataProvider;

/**
 * TestDataProvider supplies test data for TestNG tests.
 * 
 * DataProvider enables data-driven testing where
 * the same test runs with multiple datasets.
 */
public class TestDataProvider {

	/**
	 * Provides multiple user registration datasets.
	 * 
	 * parallel = true allows tests to run simultaneously
	 * for faster execution.
	 */
    @DataProvider(name = "registerUsers", parallel = true)
    public static Object[][] registerUsers() {

        return new Object[][] {

        	// Male user test case
            {"male", "John","Doe","john"+System.currentTimeMillis()+"@mail.com", "ABC Company", true , "Password123!"},

            // Female user test case
            {"female", "Anna","Smith","anna"+System.currentTimeMillis()+"@mail.com", "VDC Company", true , "Password123!"},

            // Female user without newsletter
            {"female", "David","Lee","david"+System.currentTimeMillis()+"@mail.com", "SDE Company", false , "Password123!"},

            // Male user without newsletter
            {"male", "Tom","Johb","tom"+System.currentTimeMillis()+"@mail.com", "RET Company", false , "Password123!"}

        };
    }
}