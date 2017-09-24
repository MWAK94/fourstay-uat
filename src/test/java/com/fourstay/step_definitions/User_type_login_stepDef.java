package com.fourstay.step_definitions;


import com.fourstay.pages.HomePage;
import com.fourstay.utilities.BrowserUtilities;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class User_type_login_stepDef {
	@Given("^I am on the fourstay homepages$")
	public void i_am_on_the_fourstay_homepage() throws Throwable {
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		BrowserUtilities.chatDisMiss();
	}

	@When("^I login as a host$")
	public void i_login_as_a_host() throws Throwable {
		HomePage homePage = new HomePage();
		homePage.loginLink.click();
		Thread.sleep(3000);
		homePage.email.sendKeys(ConfigurationReader.getProperty("host.username"));
		Thread.sleep(3000);
		homePage.password.sendKeys(ConfigurationReader.getProperty("host.password"));
		Thread.sleep(1000);
		homePage.loginBtn.click();

	}

	@Then("^I should be able verify I am logged$")
	public void i_should_be_able_verify_I_am_logged() throws Throwable {
		BrowserUtilities.waitForPageToLoad();
	}

	@When("^I login as a guest$")
	public void i_login_as_a_guest() throws Throwable {
		HomePage homePage = new HomePage();
		homePage.loginLink.click();
		Thread.sleep(3000);
		homePage.email.sendKeys(ConfigurationReader.getProperty("guest.username"));
		Thread.sleep(3000);
		homePage.password.sendKeys(ConfigurationReader.getProperty("guest.password"));
		Thread.sleep(1000);
		homePage.loginBtn.click();
	}
}
