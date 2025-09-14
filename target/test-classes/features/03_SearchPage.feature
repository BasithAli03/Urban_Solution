Feature: Search Functionality
  As a user,
  I want to verify Search Functionality
  
Background: User Signup
  When Hover on the profile icon
 	And Click on the Sign Up button
 	And Complete the signup process with email and password "Testing1!"

Scenario: Verify the search functionality with a valid product
 	Given I am on the homepage of Urban Ladder.
	When I search for "Sofa" from search bar
	Then The search results should display items related to "Sofa"
	
Scenario: Verify that a product can be added to the wishlist.
	Given I search for "Table" from search bar
	When Add the first product in the search results to the wishlist.
	Then The product should be added to the wishlist successfully.
	
Scenario: Verify that the product details page opens.
	Given I am on the homepage of Urban Ladder.
	When I search for "Chairs" from search bar
	When Click on view product button from the search results
	Then The product details page should open with the correct product information
	
Scenario: Verify that price filters work correctly.
	Given I am on the homepage of Urban Ladder.
	When I search for "Sofa" from search bar
	When Apply a price filter
	Then All displayed products should fall within the selected price range
	
Scenario: Verify product details in the wishlist.
	Given I search for "Table" from search bar
	When Add the first product in the search results to the wishlist.
	Then Verify the product details in wishlist Page
	
Scenario: Verify product can be added to compare section.
	Given I search for "Dining" from search bar
	When Add the first product to compare section
	Then Verify the product is added to product compare section

	