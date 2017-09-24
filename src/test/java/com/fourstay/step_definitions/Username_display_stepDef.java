package com.fourstay.step_definitions;

import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import com.fourstay.pages.AccountPage;
import com.fourstay.pages.HomePage;
import com.fourstay.pages.SignUpPage;
import com.fourstay.utilities.BrowserUtilities;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Username_display_stepDef {
	AccountPage accountPage= new AccountPage();
	SignUpPage signUp= new SignUpPage();
	
	@Given("^the user is on the FourStay sign up dialog$")
	public void the_user_is_on_the_FourStay_sign_up_dialog() throws Throwable {
	    Driver.getDriver().get("https://fourstay.herokuapp.com/");
	    Driver.getDriver().manage().window().maximize();
	    BrowserUtilities.chatDisMiss();
	    HomePage homePage= new HomePage();
	    homePage.signUpLink.click();
	}

	@Given("^the user enters enter first name \"([^\"]*)\" and last name \"([^\"]*)\"$")
	public void the_user_enters_enter_first_name_and_last_name(String firstName, String lastName) throws Throwable {
	    signUp.firstName.sendKeys(firstName);
	    Thread.sleep(2000);
	    signUp.lastName.sendKeys(lastName);
	}

	@Given("^the user enters any unregistered \"([^\"]*)\" and \"([^\"]*)\"$")
	public void the_user_enters_any_unregistered_and(String email, String password) throws Throwable {
		Thread.sleep(2000);
		email=BrowserUtilities.randomEmailGeneretar();
	    signUp.email.sendKeys(email);
	    Thread.sleep(2000);
	    signUp.password.sendKeys(password);
	}

	@Given("^click on the Sign up button$")
	public void click_on_the_Sign_up_button() throws Throwable {
	    signUp.signUpBtn.click();
	}

	@When("^the user goes the account details page$")
	public void the_user_goes_the_account_details_page() throws Throwable {
	    BrowserUtilities.waitForPageToLoad();
	    BrowserUtilities.chatDisMiss();
	    Actions actions= new Actions(Driver.getDriver());
	    actions.moveToElement(accountPage.dropDown).perform();
	    accountPage.profileInfo.click();
	}

	@Then("^first name \"([^\"]*)\" and last name \"([^\"]*)\" should be displayed in the right fields$")
	public void first_name_and_last_name_should_be_displayed_in_the_right_fields(String firstName, String lastName) throws Throwable {
		Thread.sleep(2000);
	    Assert.assertEquals(firstName, accountPage.firstName.getText());
	    Thread.sleep(2000);
	    Assert.assertEquals(lastName, accountPage.lastName.getText());
	}
}
