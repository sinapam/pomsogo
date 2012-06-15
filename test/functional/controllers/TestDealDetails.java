package functional.controllers;

import org.junit.Test;

import play.mvc.Http.Response;
import play.test.FunctionalTest;

public class TestDealDetails extends FunctionalTest {

	@Test
	public void testGetDealDetailsForKoreanTour() {
        Response response = GET("/deal/1");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertContentMatch("Korean Tour", response);
        assertContentMatch("13500", response);
        assertContentMatch("paypal.com", response);
        assertContentMatch("psogo_1339764396_biz@gmail.com", response);

	}

	@Test
	public void testGetDealDetailsForAuroraSpa() {
        Response response = GET("/deal/2");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertContentMatch("Aurora Spa", response);
        assertContentMatch("2500", response);
        assertContentMatch("paypal.com", response);
        assertContentMatch("psogo_1339764396_biz@gmail.com", response);

	}
	
}
