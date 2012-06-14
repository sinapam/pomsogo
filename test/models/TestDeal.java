package models;

import static org.junit.Assert.*;

import models.*;
import org.junit.*;
import play.test.*;

import static play.test.Helpers.*;

public class TestDeal {

	@Test
	public void newDeal() {

		String title = "Korean Tour";
		double price = 13500;
		Deal deal = new Deal(title, price);
		assertEquals(title, deal.title);
		assertEquals(price, deal.price, 0);

	}
}
