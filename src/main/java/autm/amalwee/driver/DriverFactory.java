package autm.amalwee.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * DriverFactory class is responsible for creating and managing
 * WebDriver instances for different browsers.
 * It supports parallel execution using ThreadLocal.
 */
public class DriverFactory {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	/**
	 * Initializes WebDriver based on browser type and headless option
	 * 
	 * @param browser  Browser name (chrome, firefox, edge)
	 * @param headless Run browser in headless mode if true
	 * @return WebDriver instance
	 */
	public static WebDriver initDriver(String browser, boolean headless) {

		WebDriver webdriver;

		switch (browser.toLowerCase()) {

		// Chrome browser setup
		case "chrome":
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			// Enable headless mode if specified
			if (headless) {
				chromeOptions.addArguments("--headless=new");
			}
			// Disable GPU and set window size
			chromeOptions.addArguments("--disable-gpu");
			chromeOptions.addArguments("--window-size=1920,1080");
			webdriver = new ChromeDriver(chromeOptions);
			break;

		// Firefox browser setup
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			
			// Enable Firefox headless mode
			if (headless) {
				firefoxOptions.addArguments("-headless");
			}
			webdriver = new FirefoxDriver(firefoxOptions);
			break;

		// Edge browser setup
		case "edge":
			
			//WebDriverManager.edgedriver().setup();
			
			// Using local Edge driver executable
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\msedgedriver.exe");
			EdgeOptions edgeOptions = new EdgeOptions();

			// Enable Edge headless mode
			if (headless) {
				edgeOptions.addArguments("--headless=new");
			}

			webdriver = new EdgeDriver(edgeOptions);
			break;

		default:
			// Throw error if browser is unsupported
			throw new RuntimeException("Browser not supported: " + browser);
		}

		// Store driver in ThreadLocal object for parallel execution
		driver.set(webdriver);

		// Return thread-safe driver instance
		return getDriver();
	}

	/**
	 * Returns the WebDriver instance associated with the current thread
	 * 
	 * @return WebDriver instance
	 */
	public static WebDriver getDriver() {
		return driver.get();
	}
	

	/**
	 * Quits the browser and removes WebDriver from ThreadLocal storage
	 * Prevents memory leaks in parallel test execution
	 */
	public static void quitDriver() {

		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}

}