package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class PostFormatsPage extends SeleniumWrappers {

	public WebDriver driver;
	public void PostFormatPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public By searchField = By.cssSelector("input[title= 'Search for:']");
}
