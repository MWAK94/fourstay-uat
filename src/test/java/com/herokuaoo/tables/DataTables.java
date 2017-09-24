package com.herokuaoo.tables;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

public class DataTables {

	static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		driver = Driver.getDriver();
		driver.get(ConfigurationReader.getProperty("herokuurl"));
	}

	// @Test
	public void test() {
		WebElement webtable1 = driver.findElement(By.id("table1"));
		List<WebElement> rows = webtable1.findElements(By.tagName("tr"));
		System.out.println("rows count is: " + rows.size());

		WebElement webtable2 = driver.findElement(By.id("table2"));
		List<WebElement> rows2 = webtable2.findElements(By.tagName("tr"));
		System.out.println("rows2 count is: " + rows2.size());

		List<WebElement> cells = rows.get(4).findElements(By.tagName("td"));
		System.out.println(cells.get(4).getText());
		WebElement firstCell = driver.findElement(By.xpath("//table[@id='table1']//tr[1]/th[1]"));
		System.out.println(firstCell.getText());
	}

	// @Test
	public void loopWebTables() {
		WebElement table1 = driver.findElement(By.id("table1"));
		List<WebElement> rows = table1.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		for (WebElement row : rows) {
			// System.out.println(row.getText());
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				System.out.print(cell.getText() + "|");
			}
			System.out.println();
		}
	}

	// @Test
	public void loopTablesXpath() {
		// List<WebElement> rows =
		// driver.findElements(By.xpath("//table[@id='table2']/tbody/tr"));
		// System.out.println(rows.size());

		for (int rowNum = 1; rowNum <= 4; rowNum++) {
			for (int cellNum = 1; cellNum <= 6; cellNum++) {
				String cellVal = driver
						.findElement(By.xpath("//table[@id='table2']/tbody/tr[" + rowNum + "]/td[" + cellNum + "]"))
						.getText();
				System.out.print(cellVal + "|");
			}
			System.out.println();
		}
	}

	@Test
	public void greyHoundCalender() throws InterruptedException {
		driver.get("https://www.greyhound.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("datepicker-from")).click();
		Thread.sleep(1234);
		WebElement augustFirst = driver.findElement(
				By.xpath("//div[@id='datefrom-datepicker']//table//td[@data-speak-value='Tuesday August 1 2017']"));
		augustFirst.click();
	}
}
