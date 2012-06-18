package functional.controllers;

import org.junit.Test;

import play.mvc.Http.Response;
import play.test.FunctionalTest;

public class TestDealDetails extends FunctionalTest {

	@Test
	public void testGetKoreanTourDealDetails() {
        Response response = GET("/deal/1");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertContentMatch("ทัวร์เกาหลี", response);
        assertContentMatch("13500", response);
        assertContentMatch("พร้อมหลงใหลไปกับเสน่ห์แห่งสีสันของแดนโสม", response);
	}

	@Test
	public void testGetAuroraSpaDealDetails() {
        Response response = GET("/deal/2");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertContentMatch("ออโรร่าสปา", response);
        assertContentMatch("2500", response);
        assertContentMatch("ให้คุณสามารถสัมผัสประสบการณ์ความผ่อนคลาย", response);
	}

}
