package com.herokuaoo.tables;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.utilities.Driver;
import com.fourstay.utilities.TablesConfig;

public class EmplyeesTable {
	static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		driver = Driver.getDriver();
		driver.get(TablesConfig.getProperty("url"));
	}

	@Test
	public void test() throws InterruptedException {

		WebElement webtable = driver.findElement(By.id("example"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(webtable));
		List<WebElement> headers = webtable.findElements(By.xpath("//thead/tr/th"));
		Assert.assertEquals(6, headers.size());

		Assert.assertTrue(headers.get(0).getText().equals("Name"));
		Assert.assertTrue(headers.get(1).getText().equals("Position"));
		Assert.assertTrue(headers.get(2).getText().equals("Office"));
		Assert.assertTrue(headers.get(3).getText().equals("Extn."));
		Assert.assertTrue(headers.get(4).getText().equals("Start date"));
		Assert.assertTrue(headers.get(5).getText().equals("Salary"));

		List<WebElement> rows = webtable.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				System.out.print(cell.getText() + "|");
			}
			System.out.println();
		}

		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(TablesConfig.getProperty("Name"));
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//td[.='" + TablesConfig.getProperty("Name") + "']")).getText()
				.equals("Bruno Nash"));
		Assert.assertTrue(driver.findElement(By.xpath("//td[.='" + TablesConfig.getProperty("Position") + "']")).getText()
				.equals("Software Engineer"));
		Assert.assertTrue(driver.findElement(By.xpath("//td[.='" + TablesConfig.getProperty("Office") + "']")).getText()
				.equals("London"));

		driver.findElement(By.xpath("//input[@type='search']")).clear();

		driver.findElement(By.linkText("New")).click();
		driver.findElement(By.id("DTE_Field_first_name")).sendKeys(TablesConfig.getProperty("New.firstName"));
		driver.findElement(By.id("DTE_Field_last_name")).sendKeys(TablesConfig.getProperty("New.lastName"));
		driver.findElement(By.id("DTE_Field_position")).sendKeys(TablesConfig.getProperty("New.Position"));
		driver.findElement(By.id("DTE_Field_office")).sendKeys(TablesConfig.getProperty("New.Office"));
		driver.findElement(By.id("DTE_Field_extn")).sendKeys(TablesConfig.getProperty("New.EXTN"));
		driver.findElement(By.id("DTE_Field_start_date")).click();
		driver.findElement(By.xpath("//button[@data-day='22']")).click();
		driver.findElement(By.id("DTE_Field_salary")).sendKeys("100000");
		driver.findElement(By.xpath("//button[.='Create']")).click();

		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(TablesConfig.getProperty("New.Name"));
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//td[.='" + TablesConfig.getProperty("New.Name") + "']")).getText()
				.equals("John Smith"));
		Assert.assertTrue(driver.findElement(By.xpath("//td[.='" + TablesConfig.getProperty("New.Position") + "']"))
				.getText().equals("Automation Engineer"));
		Assert.assertTrue(driver.findElement(By.xpath("//td[.='" + TablesConfig.getProperty("New.Office") + "']")).getText()
				.equals("DC"));
		Assert.assertTrue(driver.findElement(By.xpath("//td[.='" + TablesConfig.getProperty("New.EXTN") + "']")).getText()
				.equals("1994"));
		Assert.assertTrue(driver.findElement(By.xpath("//td[.='" + TablesConfig.getProperty("New.startDate") + "']"))
				.getText().equals("2017-08-22"));
		Assert.assertTrue(driver.findElement(By.xpath("//td[.='" + TablesConfig.getProperty("New.Salary") + "']")).getText()
				.equals("$100,000"));
	}

	@AfterClass
	public static void shutDown() {
		Driver.closeDriver();
	}
}
