package functional.controllers;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.*;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.*;

import models.Deal;

import org.junit.Test;

import controllers.Application;
import controllers.ref.ReverseApplication;
import dao.DealDAO;

import play.libs.F.*;
import play.mvc.Result;
import play.test.TestServer;

class MockDealDAO implements DealDAO {

	@Override
	public Deal createNewDeal(String title, Double price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Deal findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

public class TestDealDetails {

	@Test
	public void test() {
		running(testServer(3333), new Runnable() {
			
			@Override
			public void run() {
				ReverseApplication app = controllers.routes.ref.Application;
				Result result = callAction(app.dealDetails(1L));
				assertThat(status(result)).isEqualTo(OK);
			    assertThat(contentAsString(result)).contains("Korean Tour");
			    assertThat(contentAsString(result)).contains("13500");
				
			}
		});
	}

}
