package com.fourstay.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class AccountPage {

	public AccountPage(){
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath="//img[@ng-if='userImage']")
	public WebElement dropDown;
	
	@FindBy(xpath="(//a[@ui-sref='profile.general'])[2]")
	public WebElement profileInfo;
	
	@FindBy(xpath= "//input[@ng-model='$parent.other.FirstName']")
	public WebElement firstName;
	
	@FindBy(xpath= "//input[@ng-model='$parent.other.LastName']")
	public WebElement lastName;
}
