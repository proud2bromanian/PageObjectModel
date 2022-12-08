package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class SeleniumWrappers extends BaseTest {
	
	
	//WebElement element = driver.findElement(locator);
	//element.click();
	
	public WebElement getWebElement(By locator) {
		waitForELementToBeVisible(locator);
		return driver.findElement(locator);
	}
	
	public void dragAndDrop(By locator, int x, int y) {
		try {
		
		//WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		
		//action.dragAndDropBy(element, x, y).perform();
		
		action.clickAndHold(getWebElement(locator)).moveByOffset(x, y).release().perform(); //custom click
		
		}catch(NoSuchElementException e) {
			new TestException(e.getMessage());
		}
	}
	
	public void hoverElement(By locator) {
		try {		
		//WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(locator)).perform();
		}catch(NoSuchElementException e) {
			new TestException(e.getMessage());
		}
		
		
	}
	
	
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
			//WebElement element = driver.findElement(locator);
			waitForElementToBeClickable(locator);	
			WebElement element = driver.findElement(locator);
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
			//WebElement element = driver.findElement(locator);
			getWebElement(locator).clear();
			getWebElement(locator).sendKeys(textToBeSend);
		}catch(NoSuchElementException e) {
			throw new TestException(e.getMessage());
		}
		
	}
	
}
