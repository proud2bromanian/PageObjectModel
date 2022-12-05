package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.DataProviderClass;

public class DataProviderBooksSearchTest extends BaseTest {

	
	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "booksNameDataProvider")
	public void searchBooksTest(String booksName, String bookPictureName) throws InterruptedException {
		menu.search(booksName);
		Thread.sleep(3000);
		
		WebElement element = driver.findElement(By.cssSelector("div[data-image*='"+bookPictureName+"']"));
	assertTrue(element.isDisplayed());	
	}
}
