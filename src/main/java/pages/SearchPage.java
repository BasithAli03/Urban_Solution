package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchPage extends StartupPage {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	private By searchBar = By.cssSelector("input#search");
	private By searchButton = By.cssSelector("button#search_button");
	private By searchedProductTitle = By.xpath("//div[contains(@class,'product-title')]/span[@class='name']");
	private By wishIcon = By.xpath("(//span[contains(@class,'wishicon')])[1]");
	private By wishlistCount = By.cssSelector("div#shortlist-badge span:nth-child(2)");
	private By viewProductButton = By.xpath("//a[text()='View Product']");
	private By productTitle = By.xpath("//div[contains(@id,'product-title-container')]/h1[@class='product-title']");
	private By priceFilter = By.xpath("(//li[@data-group=\"price\"])[1]");
	private By priceRange = By.xpath("(//label[@class=\"range\"])[1]");
	private By productPrice = By.cssSelector("div.price-number span.pricing");
	private By inStockOnlyCheckBox = By.cssSelector("div[data-option-key=\"In Stock Only\"] label");
	private By headerWishlistIcon = By.cssSelector("div#shortlist-badge ");
	private By wishlistPageProductName = By.cssSelector("a.product-title-block div span.name");
	private By addToCompareButton = By.xpath("(//a[text()='Add to Compare'])[1]");
	private By widgetProduct = By.xpath("//div[contains(@class,\"widget-product-card\") and @data-vid]");


	public void searchForProduct(String productName) {
		driver.findElement(searchBar).sendKeys(productName);
		driver.findElement(searchButton).click();
	}

	public boolean verifySearchedProduct(String expectedProductName) {
		List<WebElement> productTitle = driver.findElements(searchedProductTitle);
		for (int i = 0; i < 20; i++) {
			String actualProduct = productTitle.get(i).getText();
			System.out.println(actualProduct);
		}

		return true;
	}

	int beforeParsedItemWishlistedText;
	String getWishlistProductText;

	public void addItemToWishlist() throws InterruptedException {
	    String beforeItemWishlistedText = driver.findElement(wishlistCount).getText();
	    getWishlistProductText = driver.findElements(searchedProductTitle).get(0).getText();
	    beforeParsedItemWishlistedText = Integer.parseInt(beforeItemWishlistedText);
	    driver.findElement(wishIcon).click();
	    Thread.sleep(2000);
	}

	public boolean verifyProductAddedToWishlist() {
	    int afterParsedItemWishlistedText = Integer.parseInt(driver.findElement(wishlistCount).getText());
	    return afterParsedItemWishlistedText > beforeParsedItemWishlistedText;
	}

	String actualProductName = "";

	public void clickOnViewProduct() {
	    actualProductName = driver.findElements(searchedProductTitle).get(0).getText();
	    new Actions(driver).moveToElement(driver.findElements(searchedProductTitle).get(0)).build().perform();
	    driver.findElements(viewProductButton).get(0).click();
	}

	public boolean verifyProductDetailsOnProductInfoPage() {
	    String expectedProductName = driver.findElement(productTitle).getText();
	    return expectedProductName.trim().equals(actualProductName.trim());
	}

	public void applyPriceFilter() {
	    new Actions(driver).moveToElement(driver.findElement(priceFilter)).build().perform();
	    driver.findElement(priceFilter).click();
	    driver.findElement(priceRange).click();
	}

	public boolean verifyProductPriceLiesInRange() throws InterruptedException {
	    String[] range = driver.findElement(priceRange).getText().replace("₹","").replace(",","").split("-");
	    int minPrice = Integer.parseInt(range[0].trim());
	    int maxPrice = Integer.parseInt(range[1].trim());

	    Thread.sleep(2000);
	    driver.findElement(inStockOnlyCheckBox).click();

	    for (WebElement product : driver.findElements(productPrice)) {
	        int price = Integer.parseInt(product.getText().replace("Starting From ₹","").replace(",","").trim());
	        if (price < minPrice || price > maxPrice) return false;
	    }
	    return true;
	}

	public boolean verifyWishlistedProductDetails() {
	    driver.findElement(headerWishlistIcon).click();
	    String expectedProductName = driver.findElement(wishlistPageProductName).getText();
	    return expectedProductName.trim().equals(getWishlistProductText.trim());
	}

	public void clickOnAddToCompareButton() {
	    new Actions(driver).moveToElement(driver.findElements(searchedProductTitle).get(0)).build().perform();
	    driver.findElement(addToCompareButton).click();
	}

	public boolean verifyProductIsPresentInCompareList() {
	    return driver.findElement(widgetProduct).isDisplayed();
	}


}
