package com.fourstay.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class HomePage {
	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "(//li[contains(@class,'not-login')])[1]") // css=".not-login"
	public WebElement loginLink;

	@FindBy(id = "email")
	public WebElement email;

	@FindBy(id = "key")
	public WebElement password;

	@FindBy(xpath = "//h3[contains(@class,'user-name')]") // css=".user-name"
	public WebElement accountHolder;

	@FindBy(id = "btn-login")
	public WebElement loginBtn;

	@FindBy(xpath = "//div[@class='sk-double-bounce']")
	public WebElement loading;
	
	@FindBy(xpath="//li[@data-target='#modal-signup']")
	public WebElement signUpLink;
}
