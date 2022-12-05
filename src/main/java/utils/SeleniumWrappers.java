package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class SeleniumWrappers extends BaseTest {
	
	
	//WebElement element = driver.findElement(locator);
	//element.click();
	
	/**	 
	 *	Custom click method that waits for an element to be clickable before triggering click
	 *	@param locator --> webelement locator
	 */
	
	public void click(By locator) {
		
		try {
			//Log.info(called click on element..)
			/*
			 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 * wait.until(ExpectedConditions.elementToBeClickable(locator));
			 */
			WebElement element = driver.findElement(locator);
			waitForElementToBeClickable(locator);			
			element.click();
		}catch(NoSuchElementException e){
			throw new TestException(e.getMessage());
		}
	}
	public void waitForElementToBeClickable(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}catch(NoSuchElementException e) {
			throw new TestException(e.getMessage());
		}
	}
	
	public void waitForELementToBeVisible(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}catch(NoSuchElementException e) {
			throw new TestException(e.getMessage());
		}
	}
	public boolean checkElementIsDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
		
	}
	public void sendKeys(By locator, String textToBeSend) {
		try {
			waitForELementToBeVisible(locator);
			WebElement element = driver.findElement(locator);
			element.clear();
			element.sendKeys(textToBeSend);
		}catch(NoSuchElementException e) {
			throw new TestException(e.getMessage());
		}
		
	}
	
}
