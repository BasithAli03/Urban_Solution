package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends StartupPage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	private By homePageLogo = By.className("header__topBar_logo");

	public boolean verifyHomePageLogo() {
		WebElement hm = driver.findElement(homePageLogo);
		return hm.isDisplayed();
	}

	public String getTitleOfHomePage() {
		String title = "";
		title = driver.getTitle();
		return title;
	}

}
