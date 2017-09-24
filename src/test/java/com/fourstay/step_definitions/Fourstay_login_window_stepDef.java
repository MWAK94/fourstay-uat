package com.fourstay.step_definitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Fourstay_login_window_stepDef {
	WebDriver driver;

	@Given("^the user is on fourstay home page$")
	public void the_user_is_on_fourstay_home_page() throws Throwable {
		driver = Driver.getDriver();
		driver.get(ConfigurationReader.getProperty("url"));
	}

	@When("^the user clicks on the login link$")
	public void the_user_clicks_on_the_login_link() throws Throwable {
		driver.findElement(By.xpath("(//li[contains(@class,'not-login')])[1]")).click();
	}

	@Then("^the email field should be displayed$")
	public void the_email_field_should_be_displayed() throws Throwable {
		Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());
		Driver.closeDriver();
	}
}
