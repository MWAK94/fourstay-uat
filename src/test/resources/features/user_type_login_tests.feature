@user_type
Feature: Login functionality for different user types 
	As a user, when I go to the FourStay home page,
  I should be able to login as host or guest

@smoke
@regression
Scenario: Login as a host 
	Given I am on the fourstay homepages 
	When I login as a host 
	Then I should be able verify I am logged 
	
Scenario: Login as a guest 
	Given I am on the fourstay homepages 
	When I login as a guest 
	Then I should be able verify I am logged 