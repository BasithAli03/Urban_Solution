package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterPage extends StartupPage {

	public FooterPage(WebDriver driver) {
		super(driver);
	}

	private By contactUsButton = By.xpath("//*[@id=\"footer-links\"]/div[1]/div[2]/ul[2]/li[1]/a");
	private By contactUsHeading = By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div[1]/span");

	public void clickOnContactUsLink() {
		driver.findElement(contactUsButton).click();
	}

	public boolean verifyContactUsHeading() {
		// write your logic here

		return driver.findElement(contactUsHeading).isDisplayed();
	}

}
