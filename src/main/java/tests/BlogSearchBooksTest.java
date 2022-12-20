package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.BlogClassicPage;
import utils.BaseTest;
import utils.SeleniumWrappers;

public class BlogSearchBooksTest extends SeleniumWrappers {
	
	@Test
	public void searchBookTest() {	
		String bookName = "stop buying books";

		app.menu.navigateTo(app.menu.blogLink);
		app.menu.navigateTo(app.menu.blogClassicLink);
		app.blogClassic.searchForm(bookName);		
		app.blogClassic.click(app.blogClassic.searchedBookLink);
				
		assertEquals(app.bookPage.getCategoryLabels(0).getText(), "Classic");
		assertEquals(app.bookPage.getCategoryLabels(1).getText(), "News");
		assertEquals(app.bookPage.getCategoryLabels(2).getText(), "Recommend");
		
		
	}
	
}
