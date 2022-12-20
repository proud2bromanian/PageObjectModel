package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Links;

import utils.BaseTest;

public class FindBrokenLinks extends BaseTest {
	
	static List   <String>  brokenLinks = new ArrayList<String>();
	
	@Test
	public void testBrokenLinks() throws IOException {
		List <WebElement> links = driver.findElements(By.cssSelector("a[href*='http']"));
		
		System.out.println("Total Links : " + links.size());
		
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('href','https://keybooks.ro/account/lost-pass/')", links.get(0));
		
		
		for(int i=0;i<links.size();i++) {
			WebElement element =links.get(i);
			String url = element.getAttribute("href");
			
			if(url==null) {
				continue;
			}
			checkLinks(url);
		}
		
		assertTrue(brokenLinks.size() == 0);
		
		
	}
	
	public static void checkLinks(String linkUrl) throws IOException {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpUrlsConnection = (HttpURLConnection) url.openConnection();
			httpUrlsConnection.setConnectTimeout(3000);
			httpUrlsConnection.connect();
			
			if(httpUrlsConnection.getResponseCode() ==200) {
				System.out.println(linkUrl + "=" + httpUrlsConnection.getResponseCode());
			}
			if(httpUrlsConnection.getResponseCode() == httpUrlsConnection.HTTP_NOT_FOUND) {
				System.out.println(linkUrl + "=" + httpUrlsConnection.getResponseCode());
				brokenLinks.add(linkUrl);
			}
			
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
}
