package dao;

import static org.junit.Assert.*;
import static play.test.Helpers.*;

import models.Deal;

import org.junit.Before;
import org.junit.Test;

public class DealDAOImplTest {
	private DealDAO dao;

	@Before
	public void setUp() {
		dao = new DealDAOImpl();
	}

	@Test
	public void testCreateNewDeal() {
		running(fakeApplication(), new Runnable() {
			@Override
			public void run() {
				String title = "Korean Tour";
				double price = 13500;

				Deal deal = dao.createNewDeal(title, price);

				deal = Deal.find.byId(deal.id);
				assertEquals(title, deal.title);
				assertEquals(price, deal.price, 0);
			}
		});
	}

	@Test
	public void findById() {
		running(fakeApplication(), new Runnable() {
			@Override
			public void run() {
				String title = "Korean Tour";
				double price = 13500;
				Deal deal = new Deal(title, price);
				deal.save();
				
				deal = dao.findById(deal.id);

				assertEquals(title, deal.title);
				assertEquals(price, deal.price, 0);
			}
		});
	}
}
