import com.thoughtworks.selenium.SeleneseTestCase;

@SuppressWarnings("deprecation")
public class DemoTestLibrary extends SeleneseTestCase {

	public void setUp() throws Exception {
		setUp("http://localhost:9000/", "*firefox");
	}

	public void goToHomePage() throws Exception {
		selenium.open("/");
	}

	public void goToDealDetailsPage(int page) throws Exception {
		selenium.open("/deal/" + page);
	}
	
	public void clickOnPaypalBuyNowButton() throws Exception {
		selenium.click("paypal_buynow");
	}
	
	public void checkThatRedirectedToPaypal(String email, String password) throws Exception {
		selenium.waitForPageToLoad("10000");
		String location = selenium.getLocation();
		assertEquals("https://www.sandbox.paypal.com/cgi-bin/webscr", location);
	}
	
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
