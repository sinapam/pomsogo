package functional.controllers;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.*;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.callAction;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.status;

import models.Deal;

import org.junit.Test;

import play.mvc.Result;

public class TestDealDetails {

	@Test
	public void test() {
		Result result = callAction(controllers.routes.ref.Application
				.dealDetails(1L));
		assertThat(status(result)).isEqualTo(OK);
	    assertThat(contentAsString(result)).contains("Korean Tour");
	    assertThat(contentAsString(result)).contains("13500");
	}

}
