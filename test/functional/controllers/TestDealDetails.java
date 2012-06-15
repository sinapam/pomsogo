package functional.controllers;

import org.junit.Test;

import play.mvc.Http.Response;
import play.test.FunctionalTest;

public class TestDealDetails extends FunctionalTest {

	@Test
	public void testGetDealDetails() {
        Response response = GET("/application/deal_details?id=1");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertContentMatch("Korean Tour", response);
        assertContentMatch("13500", response);

	}

}
