package com.fourstay.step_definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.fourstay.utilities.Driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook{
	@Before
	public void setUp() {
		Driver.getDriver().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	}

	@After
	public void shutDown(Scenario scenario){
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		Driver.closeDriver();
	}
}
