package steps;

import org.testng.Assert;

import coreUtilities.testbase.TestBase;
import io.cucumber.java.en.*;
import pages.FooterPage;

public class FooterStep extends TestBase{

	FooterPage fp = new FooterPage(driver);

	@When("Click on the Contact Us link in the footer")
	public void click_on_the_link_in_the_footer() {
		fp.clickOnContactUsLink();
	}

	@Then("The Contact Us page should open with relevant information")
	public void the_page_should_open_with_relevant_information() {
		Assert.assertTrue(fp.verifyContactUsHeading());
	}

}
