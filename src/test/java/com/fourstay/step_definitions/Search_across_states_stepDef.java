package com.fourstay.step_definitions;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.fourstay.pages.SearchPage;
import com.fourstay.utilities.BrowserUtilities;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Search_across_states_stepDef {
	SearchPage searchPage = new SearchPage();

	@Given("^I am on the fourstay homepage$")
	public void i_am_on_the_fourstay_homepage() throws Throwable {
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));

		BrowserUtilities.chatDisMiss();
	}

	@Given("^I enter school name \"([^\"]*)\"$")
	public void i_enter_school_name(String schoolName) throws Throwable {
		searchPage.schoolName.sendKeys(schoolName);
	}

	@Given("^I enter dates \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_dates_and(String from, String to) throws Throwable {
		searchPage.fromDate.sendKeys(from);
		searchPage.toDate.sendKeys(to);
	}

	@Given("^I click the search button$")
	public void i_click_the_search_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		searchPage.searchBtn.click();
	}

	@Then("^the results should contain$")
	public void the_results_should_contain(List<String> states) throws Throwable {
		  BrowserUtilities.switchTabs("search");
		  BrowserUtilities.waitForPageToLoad();
		    
		    Set<String> actualStates= new HashSet<>();
		    for(WebElement element: searchPage.allStates){
		    	actualStates.add(element.getText());
		    }
		    Assert.assertTrue(actualStates.containsAll(states));
	}

	@When("^I enter this search criteria$")
	public void i_enter_this_search_criteria(List<Map<String, String>> searchCriteria) throws Throwable {
		Map<String, String> input = searchCriteria.get(0);
		searchPage.schoolName.sendKeys(input.get("school"));
		searchPage.fromDate.sendKeys(input.get("start"));
		searchPage.toDate.sendKeys(input.get("end"));
		searchPage.searchBtn.click();
	}
}
