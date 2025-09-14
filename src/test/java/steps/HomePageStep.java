package steps;

import org.testng.Assert;

import coreUtilities.testbase.TestBase;
import io.cucumber.java.en.*;
import pages.HomePage;

public class HomePageStep extends TestBase{

	HomePage hp = new HomePage(driver);

	@Given("I am on the homepage of Urban Ladder.")
	public void i_am_on_the_homepage_of_urban_ladder() {
		Assert.assertEquals(hp.verifyHomePageLogo(), true);
	}

	@Then("The page title should contain {string}.")
	public void the_page_title_should_contain(String expectedPageTitle) {
		Assert.assertEquals(hp.getTitleOfHomePage().contains(expectedPageTitle), true);
	}

}
