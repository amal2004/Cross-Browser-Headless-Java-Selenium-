package autm.headless.parallel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import autm.headless.parallel.base.BasePage;

/**
 * RegisterPage represents the user registration page.
 * 
 * It contains element locators and reusable methods
 * for interacting with the registration form.
 */
public class RegisterPage extends BasePage {

	// Locators for gender radio buttons
    private By genderMale = By.id("gender-male");
    private By genderFemale = By.id("gender-female");

	// Locators for form input fields
	private By firstName = By.id("FirstName");
	private By lastName = By.id("LastName");
	private By email = By.id("Email");
	private By company = By.id("Company");

	// Locator for newsletter checkbox
	private By newsLetter = By.id("Newsletter");

	// Locators for password fields
    private By password = By.id("Password");
    private By confirmPassword = By.id("ConfirmPassword");

	// Locator for register button
    private By registerButton = By.xpath("//button[contains(text(),'Register')]");

	/**
	 * Constructor passes WebDriver to BasePage
	 * 
	 * @param driver WebDriver instance
	 */
	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Selects male gender radio button
	 */
	public void selectMaleGender() {
		click(genderMale);
	}

	/**
	 * Selects female gender radio button
	 */
	public void selectFemaleGender() {
		click(genderFemale);
	}

	/**
	 * Controls newsletter subscription checkbox
	 * 
	 * @param subscribe true = subscribe, false = unsubscribe
	 */
	public void setNewsLetterSub(boolean subscribe) {
		
		WebElement checkbox = driver.findElement(newsLetter);

		// Toggle checkbox only if current state differs
		if (checkbox.isSelected() != subscribe) {
			click(newsLetter);
		}
	}

	/**
	 * Fills and submits the registration form
	 * 
	 * @param gender user gender
	 * @param fName first name
	 * @param lName last name
	 * @param e_mail email address
	 * @param cmpany company name
	 * @param news_Letter newsletter subscription flag
	 * @param pword password
	 */
	public void registerUser(
			String gender,
			String fName,
			String lName,
			String e_mail,
			String cmpany,
			boolean news_Letter,
			String pword) throws InterruptedException {

		// Select gender
		if (gender.equalsIgnoreCase("male")) {
			selectMaleGender();
		} else if (gender.equalsIgnoreCase("female")) {
			selectFemaleGender();
		}

		// Fill form fields
		type(firstName, fName);
		type(lastName, lName);
		type(email, e_mail);
		type(company, cmpany);

		// Set newsletter preference
		setNewsLetterSub(news_Letter);

		// Enter password
		type(password, pword);
		type(confirmPassword, pword);

		// Submit form
		click(registerButton);
	}

}