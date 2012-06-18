

import org.junit.After;
import org.junit.Before;
import com.thoughtworks.selenium.SeleneseTestCase;

public class DemoTestLibrary extends SeleneseTestCase {

	@Before
	public void setUp() throws Exception {
		setUp("http://localhost:9000/", "*chrome");
	}

	public void goToEstimationPage() throws Exception {
		selenium.open("/");
		selenium.type("sb_form_q", "selenium tutorial");
		selenium.click("sb_form_go");
		selenium.waitForPageToLoad("80000");
		selenium.click("link=www.jroller.com");
		selenium.waitForPageToLoad("80000");
	}

	public void selectStoryPointToCompare() throws Exception {
		selenium.open("/");
		selenium.type("sb_form_q", "selenium tutorial");
		selenium.click("sb_form_go");
		selenium.waitForPageToLoad("80000");
		selenium.click("link=www.jroller.com");
		selenium.waitForPageToLoad("80000");
	}


	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
