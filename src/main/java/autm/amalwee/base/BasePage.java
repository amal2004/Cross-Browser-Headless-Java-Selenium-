package autm.amalwee.base;

import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * BasePage contains reusable methods for Page Object classes.
 * It wraps common Selenium WebDriver actions like click, type,
 * get text, wait for elements, and navigation.
 */

public class BasePage {

	// WebDriver instance used to interact with the browser
	protected WebDriver driver;

	// Explicit wait used to wait for elements before interacting with them
	protected WebDriverWait wait;

	/**
	 * Constructor initializes WebDriver and WebDriverWait
	 * 
	 *  @param driver Selenium WebDriver instance
	 */
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	/**
	 * Clicks on a web element once it becomes clickable
	 * 
	 * @param locator By locator used to find the element
	 */
	protected void click(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	/**
	 * Types text into an input field after clearing any existing text
	 * 
	 * @param locator By locator of the input field
	 * @param text Text to be entered
	 */
	protected void type(By locator, String text) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(text);
	}
	
	/**
	 * Retrieves visible text from a web element
	 * 
	 * @param locator By locator of the element
	 * @return text contained in the element
	 */
	protected String getText(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
	}
	
	/**
	 * Navigates the browser to a specific URL
	 * @param url URL to navigate to
	 */
	protected void navigateTo(String url) {
		driver.get(url);
	}

	/**
	 * Checks whether an element is visible on the page
	 * Returns false if the element does not appear within the wait time
	 * 
	 * @param locator By locator of the element
	 * @return true if displayed, false otherwise
	 */
	protected boolean isElementDisplayed(By locator) {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
		} catch (TimeoutException e) {
			return false;
		}
	}
	
	/**
	 * Waits explicitly until an element becomes visible on the page
	 * 
	 * @param locator By locator of the element
	 */
	protected void waitForanElement(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	/**
	 * Scrolls to an element and performs a JavaScript click.
	 * Useful when a normal Selenium click fails due to overlays
	 * or elements being outside the viewport.
	 * 
	 * @param locator By locator of the element
	 */
	protected void scrollToanElement(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

}