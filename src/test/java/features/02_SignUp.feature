@Signup
Feature: User Signup
  As a user,
  I want to sign up on Urban Ladder
  So that I can create an account and access personalized features.

Scenario: Verify user can sign up successfully
 	Given I am on the homepage of Urban Ladder.
 	When Hover on the profile icon
 	And Click on the Sign Up button
 	And Complete the signup process with email and password "Testing1!"
 	Then Verify My Account is visible
 	
 Scenario: Verify user can LOG OUT successfully
 	Given I am on the homepage of Urban Ladder.
 	When Hover on the profile icon
 	And Click on the Sign Up button
 	And Complete the signup process with email and password "Testing1!"
 	Then Verify My Account is visible
 	And Click on logout button
 	Then Verify Login button is visible
 
  