@Staytest_125 
Feature: Search accross states 

Background: 
	Given I am on the fourstay homepage 
@Staytest_125_list 
Scenario: Verify results in DC metro area using list 
	And I enter school name "Georgetown university" 
	And I enter dates "08/29/2017" and "10/22/2017" 
	And I click the search button 
	Then the results should contain 
		|District of Columbia |
		|Maryland             |
		|Virginia             |
		
@Staytest_125_maps 
Scenario: Verify results in DC metro area using maps using maps 
	When I enter this search criteria 
		|  school              |   start    |  end      |
		|Georgetown university | 08/29/2017 | 10/22/2017|        
	Then the results should contain 
		|District of Columbia |
		|Maryland             |
		|Virginia             |