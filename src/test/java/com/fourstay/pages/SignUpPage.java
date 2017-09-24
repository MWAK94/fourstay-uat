package com.fourstay.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class SignUpPage {
	public SignUpPage(){
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id="FirstName")
	public WebElement firstName;
	
	@FindBy(id= "LastName")
	public WebElement lastName;
	
	@FindBy(xpath="(//input[@id='email'])[3]")
	public WebElement email;
	
	@FindBy(xpath= "(//input[@id='key'])[2]")
	public WebElement password;
	
	@FindBy(id="btn-signup")
	public WebElement signUpBtn;
}
