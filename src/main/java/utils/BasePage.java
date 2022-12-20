package utils;

import pages.MenuPage;
import pages.PostFormatsPage;
import pages.ShopPage;
import pages.BlogClassicPage;
import pages.BookPage;
import pages.ContactsPage;

public class BasePage extends BaseTest {

	public MenuPage menu = new MenuPage(driver);
	public ShopPage shop = new ShopPage(driver);
	public PostFormatsPage postFormat = new PostFormatsPage();
	public ContactsPage contact = new ContactsPage(driver);
	public BlogClassicPage blogClassic = new BlogClassicPage(driver);
	public BookPage bookPage = new BookPage(driver);
	
}
