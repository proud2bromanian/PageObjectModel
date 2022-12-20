package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class BlogClassicPage extends SeleniumWrappers {	
	
	public WebDriver driver;
	public BlogClassicPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public By searchFormField = By.xpath("//aside[@id='search-2']//input");
	public By searchSubmitButton = By.xpath("//aside[@id='search-2']//button");
	public By searchedBookLink = By.xpath("//h4[@class='post_title']/a");
	
	public void searchForm(String text) {		
		sendKeys(searchFormField, text);
		click(searchSubmitButton);
	}
	
	
}
