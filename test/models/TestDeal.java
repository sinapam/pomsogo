package models;

import static org.junit.Assert.*;

import models.*;

import org.junit.*;
import play.test.*;

import static play.test.Helpers.*;

public class TestDeal {

	@Test
	public void test_create_new_deal() {
		running(fakeApplication(), new Runnable() {
			
			@Override
			public void run() {
				String title = "Korean Tour";
				double price = 13500;
				Deal deal = new Deal(title, price);
				deal.save();
				deal = Deal.find.byId(deal.id);
				assertEquals(title, deal.title);
				assertEquals(price, deal.price, 0);
			}
		});
	}

}
