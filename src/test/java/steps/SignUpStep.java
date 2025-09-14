package steps;

import org.testng.Assert;

import coreUtilities.testbase.TestBase;
import io.cucumber.java.en.*;
import pages.SignupPage;

public class SignUpStep extends TestBase {

	SignupPage signup = new SignupPage(driver);

	@When("Hover on the profile icon")
	public void i_click_on_the_profile_icon() {
		signup.hoverOnProfileButton();
	}

	@When("Click on the Sign Up button")
	public void i_click_on_the_button() {
		signup.clickOnSignupButton();
	}

	@When("Complete the signup process with email and password {string}")
	public void complete_the_signup_process(String password) {
		try {
			signup.doSignup(password);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Verify My Account is visible")
	public void verify_my_account_is_visible() {
		Assert.assertTrue(signup.isuserLoggedIn());
	}

	@When("Click on logout button")
	public void click_on_logout_button() {
		signup.clickLogoutButton();
	}

	@Then("Verify Login button is visible")
	public void verify_login_button_is_visible() {
		Assert.assertTrue(signup.isUserLoggedOut());
	}

}
