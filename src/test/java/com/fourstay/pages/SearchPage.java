package com.fourstay.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class SearchPage {

	public SearchPage(){
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id= "iLocName")
	public WebElement schoolName;
	
	@FindBy(id= "rentoutfrom2")
	public WebElement fromDate;
	
	@FindBy(id= "rentoutto2")
	public WebElement toDate;
	
	@FindBy(id= "search")
	public WebElement searchBtn;
	
	@FindBy(xpath = "//div[@class='sk-double-bounce']")
	public WebElement loading;
	
	@FindBy(css= ".col-md-12>p")
	public List<WebElement> allStates;
	
	@FindBy(xpath="//iframe[@class='intercom-borderless-frame']")
	public WebElement chatFrame;
	
	@FindBy(xpath="//div[@class='intercom-borderless-dismiss-button']")
	public WebElement dismissBtn;
}
