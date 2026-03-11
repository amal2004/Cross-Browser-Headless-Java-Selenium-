package autm.headless.parallel.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import autm.headless.parallel.driver.DriverFactory;

/**
 * BaseTest class provides common setup and teardown functionality
 * for all TestNG test classes.
 * 
 * It initializes the WebDriver before each test method and
 * closes the driver after test execution.
 */
public class BaseTest {

	// WebDriver instance used by test classes
	protected WebDriver driver;
	
	/**
	 * Setup method executed before every test method.
	 * Initializes browser and navigates to the application URL.
	 * 
	 * @param browser Browser type (chrome, firefox, etc.)
	 * @param headless Whether to run browser in headless mode
	 */
	@Parameters({"browser", "headless"})
	@BeforeMethod
	public void setUp(@Optional("chrome") String browser,
					  @Optional("false") String headless) {
		
		// Initialize driver using DriverFactory
		driver = DriverFactory.initDriver(browser, Boolean.parseBoolean(headless));
		
		// Maximize browser window
		driver.manage().window().maximize();
		
		// Navigate to the application register page
		//driver.get("http://localhost:5000/register");
		driver.get("https://demo.eshiply.me/register");
		
	}
	
	
	/**
	 * TearDown method executed after each test method.
	 * Ensures that the browser session is closed properly.
	 */
	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
	

}