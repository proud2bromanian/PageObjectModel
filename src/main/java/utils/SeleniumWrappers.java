package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class SeleniumWrappers extends BaseTest {
	
	
	//WebElement element = driver.findElement(locator);
	//element.click();
	public void customClick(By locator) {
		
		try {
			//Log.info(called click on element..)
			WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			WebElement element = driver.findElement(locator);
			element.click();
		}catch(NoSuchElementException e){
			//Log.error()
		}
	}
	
}
