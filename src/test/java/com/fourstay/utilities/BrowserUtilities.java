package com.fourstay.utilities;

import java.util.Random;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.SearchPage;

public class BrowserUtilities {
	public static void switchTabs(String url){
		String defaultTab= Driver.getDriver().getWindowHandle();
		for(String windowHandle: Driver.getDriver().getWindowHandles()){
			Driver.getDriver().switchTo().window(windowHandle);
			if(Driver.getDriver().getCurrentUrl().contains(url)){
				return;
			}
		}
		Driver.getDriver().switchTo().window(defaultTab);
		
	}
	
	public static void waitForPageToLoad(){
		WebDriverWait wait= new WebDriverWait(Driver.getDriver(), 30);
		SearchPage searchPage= new SearchPage();
		try {
			wait.until(ExpectedConditions.invisibilityOf(searchPage.loading));
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void chatDisMiss(){
		WebDriverWait wait= new WebDriverWait(Driver.getDriver(),30);
		SearchPage searchPage= new SearchPage();
		wait.until(ExpectedConditions.visibilityOf(searchPage.chatFrame));
	    Driver.getDriver().switchTo().frame(searchPage.chatFrame);
	    searchPage.dismissBtn.click();
	    Driver.getDriver().switchTo().defaultContent();
	}
	
	public static String randomEmailGeneretar(){
		Random randomGen= new Random();
		int randomInt= randomGen.nextInt(1000);
		return "userName"+randomInt+"@test.com";
	}
}
