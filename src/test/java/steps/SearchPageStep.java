package steps;

import org.testng.Assert;

import coreUtilities.testbase.TestBase;
import io.cucumber.java.en.*;
import pages.SearchPage;

public class SearchPageStep extends TestBase{

	SearchPage search = new SearchPage(driver);

	@When("I search for {string} from search bar")
	public void i_search_for_from_search_bar(String productName) {
		search.searchForProduct(productName);
	}

	@Then("The search results should display items related to {string}")
	public void the_search_results_should_display_items_related_to(String productName) {
		Assert.assertTrue(search.verifySearchedProduct(productName));
	}

	@When("Add the first product in the search results to the wishlist.")
	public void add_the_first_product_in_the_search_results_to_the_wishlist() throws InterruptedException {
		search.addItemToWishlist();
	}

	@Then("The product should be added to the wishlist successfully.")
	public void the_product_should_be_added_to_the_wishlist_successfully() {
		Assert.assertTrue(search.verifyProductAddedToWishlist());
	}

	@When("Click on view product button from the search results")
	public void click_on_view_product_button_from_the_search_results() {
		search.clickOnViewProduct();
	}

	@Then("The product details page should open with the correct product information")
	public void the_product_details_page_should_open_with_the_correct_product_information() {
		Assert.assertTrue(search.verifyProductDetailsOnProductInfoPage());
	}

	@When("Apply a price filter")
	public void apply_a_price_filter() {
		search.applyPriceFilter();
	}

	@Then("All displayed products should fall within the selected price range")
	public void all_displayed_products_should_fall_within_the_selected_price_range() throws InterruptedException {
		Assert.assertTrue(search.verifyProductPriceLiesInRange());
	}

	@Then("Verify the product details in wishlist Page")
	public void verify_the_product_details_in_wishlist_page() {
		Assert.assertTrue(search.verifyWishlistedProductDetails());
	}

	@When("Add the first product to compare section")
	public void add_the_first_product_to_compare_section() {
		search.clickOnAddToCompareButton();
	}

	@Then("Verify the product is added to product compare section")
	public void verify_the_product_is_added_to_product_compare_section() {
		Assert.assertTrue(search.verifyProductIsPresentInCompareList());
	}

}
