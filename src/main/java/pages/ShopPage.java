package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShopPage {
	public WebDriver driver;
	public Select selectDropdown;
	
	public ShopPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By orderDropDown = By.name("orderby");
	
	public void filterByValue(String value) {
		WebElement element = driver.findElement(orderDropDown);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByValue(value);
	}
	public void filterByIndex(int index) {
		WebElement element = driver.findElement(orderDropDown);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByIndex(index);
	}
	public void filterByVisibleText(String text) {
		WebElement element = driver.findElement(orderDropDown);
		Select selectDropdown = new Select(element);
		selectDropdown.selectByVisibleText(text);
	}
	public String getCurrentSelectedOption() {
		WebElement element = driver.findElement(orderDropDown);
		Select selectedDropDown = new Select(element);
		return selectedDropDown.getFirstSelectedOption().getText();
		
		
	}
	
}