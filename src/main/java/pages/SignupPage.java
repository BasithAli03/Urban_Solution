package pages;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SignupPage extends StartupPage {

	public SignupPage(WebDriver driver) {
		super(driver);
	}

	private By profileIcon = By.xpath("//span[contains(@class,\"user-profile-icon\")]");
	private By signUpicon = By.cssSelector("a#header-icon-signup");
	private By emailAddress = By.cssSelector("input[placeholder='Email Address*']");
	private By userPassword = By.xpath("(//div[@class='password']/input[@type=\"password\"])[1]");
	private By signUpButton = By.cssSelector("input[value='Sign Up']");
	private By headerProfileIcon = By.cssSelector("a#header-icon-profile");
	private By logoutButton = By.cssSelector("a#logout");

	public void hoverOnProfileButton() {
		// write your logic here
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(profileIcon)).perform();
	}

	public void clickOnSignupButton() {
		// write your logic here
		driver.findElement(signUpicon).click();

	}

	public void doSignup(String password) throws InterruptedException {
		// write your logic here
		String random = generateRandomUsername();
		driver.findElement(emailAddress).sendKeys(random);
		driver.findElement(userPassword).sendKeys(password);
		driver.findElement(signUpButton).click();
	}

	public static String generateRandomUsername() {
		// Generate a random unique ID
		String randomId = UUID.randomUUID().toString().substring(0, 8); // Take the first 8 characters
		return "user" + randomId + "@mailinator.com";
	}

	public boolean isuserLoggedIn() {
		boolean isMyAccountVisible = false;
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(profileIcon)).perform();
		isMyAccountVisible = driver.findElement(headerProfileIcon).isDisplayed();
		return isMyAccountVisible;
	}

	public void clickLogoutButton() {
		// write your logic here
		driver.findElement(logoutButton).click();
	}

	public boolean isUserLoggedOut() {
		// write your logic here
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(profileIcon)).perform();

		return driver.findElement(signUpicon).isDisplayed();
	}

}
