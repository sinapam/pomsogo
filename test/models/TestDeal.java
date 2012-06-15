package models;

import static org.junit.Assert.*;

import models.*;
import org.junit.*;
import play.test.*;

import static play.test.Helpers.*;

public class TestDeal extends UnitTest {
	String title = "Korean Tour";
	double price = 13500;

	@Test
	public void newDeal() {
		Deal deal = new Deal(title, price);
		assertEquals(title, deal.title);
		assertEquals(price, deal.price, 0);
	}
	
	@Test
	public void createAndRetrieveDeal() {
		Deal deal = new Deal(title, price);
		deal.save();
		
		deal = Deal.findById(deal.id);
		assertEquals(title, deal.title);
		assertEquals(price, deal.price, 0);	}
}
