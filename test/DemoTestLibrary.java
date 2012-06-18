import com.thoughtworks.selenium.SeleneseTestCase;

@SuppressWarnings("deprecation")
public class DemoTestLibrary extends SeleneseTestCase {

	public void setUp() throws Exception {
		setUp("http://localhost:9000/", "*firefox");
	}

	public void goToHomePage() throws Exception {
		selenium.open("/");
	}

	public void goToDealDetailsPage() throws Exception {
		selenium.open("/deal/1");
	}
	
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
