package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.SeleniumWrappers;



public class BookPage extends SeleniumWrappers {
	public WebDriver driver;
	
	public BookPage(WebDriver driver){
		this.driver = driver;
	}
	
	
	public WebElement getCategoryLabels(int index) {
		
		List <WebElement> categoryList = driver.findElements(By.xpath("//div[@class='post_info']//span[contains(@class, 'post_info_tags')]/a"));
		return categoryList.get(index);
		
	}
	


}
