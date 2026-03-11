package autm.amalwee.data;

import org.testng.annotations.DataProvider;

/**
 * TestDataProvider supplies test data for TestNG tests.
 * DataProvider enables data-driven testing using multiple data sets 
 */
public class TestDataProvider {

	/**
	 * Provides multiple user registration datasets.
	 */
    @DataProvider(name = "registerUsers", parallel = true)
    public static Object[][] registerUsers() {

        return new Object[][] {

        	// Test data
            {"male", "John","Doe","john"+System.currentTimeMillis()+"@mail.com", "ABC Company", true , "Password123!"},
            {"female", "Anna","Smith","anna"+System.currentTimeMillis()+"@mail.com", "VDC Company", true , "Password123!"},
            {"female", "David","Lee","david"+System.currentTimeMillis()+"@mail.com", "SDE Company", false , "Password123!"},
            {"male", "Tom","Johb","tom"+System.currentTimeMillis()+"@mail.com", "RET Company", false , "Password123!"}

        };
    }
}