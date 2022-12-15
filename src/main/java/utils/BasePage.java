package utils;

import pages.MenuPage;
import pages.PostFormatsPage;
import pages.ShopPage;
import pages.ContactsPage;
import pages.EventsPage;
import pages.GenericEventPage;

public class BasePage extends BaseTest {

	public MenuPage menu = new MenuPage(driver);
	public ShopPage shop = new ShopPage(driver);
	public PostFormatsPage postFormat = new PostFormatsPage();
	public ContactsPage contact = new ContactsPage(driver);
	public EventsPage events = new EventsPage(driver);
	public GenericEventPage genericEvent = new GenericEventPage(driver);
}
