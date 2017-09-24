package com.fourstay.step_definitions;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.HomePage;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Display_user_info_stepDef {
	@Given("^I am on the fourstay login dialog$")
	public void i_am_on_the_fourstay_login_dialog() throws Throwable {
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		HomePage homePage = new HomePage();
		homePage.loginLink.click();
	}

	@And("^I enter email \"([^\"]*)\"$")
	public void i_enter_email(String email) throws Throwable {
		HomePage homePage = new HomePage();
		Thread.sleep(2000);
		homePage.email.sendKeys(email);
	}

	@And("^I enter password \"([^\"]*)\"$")
	public void i_enter_password(String password) throws Throwable {
		HomePage homePage = new HomePage();
		Thread.sleep(2000);
		homePage.password.sendKeys(password);
	}

	@When("^I click on the login button$")
	public void i_click_on_the_login_button() throws Throwable {
		HomePage homePage = new HomePage();
		homePage.loginBtn.click();
	}

	@Then("^the user name should be \"([^\"]*)\"$")
	public void the_user_name_should_be(String name) throws Throwable {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 60);
		HomePage homePage = new HomePage();
		wait.until(ExpectedConditions.invisibilityOf(homePage.loading));
		Thread.sleep(1000);
		Assert.assertTrue(homePage.accountHolder.getText().equals(name));
	}
}
