@Staytest_3 
Feature: User Name information not displayed correctly 

@smoke 
Scenario: User's name information should be displayed correctly 
	Given the user is on the FourStay sign up dialog 
	And the user enters enter first name "John" and last name "Smith" 
	And the user enters any unregistered "email" and "password" 
	And click on the Sign up button 
	When the user goes the account details page 
	Then first name "John" and last name "Smith" should be displayed in the right fields