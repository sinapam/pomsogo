package functional.route;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.*;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.GET;
import static play.test.Helpers.fakeRequest;
import static play.test.Helpers.routeAndCall;
import static play.test.Helpers.status;

import org.junit.Test;

import play.mvc.Result;

public class RouteTest {

	@Test
	public void deal_details() {
		Result result = routeAndCall(fakeRequest(GET, "/deal/1"));
		assertThat(status(result)).isEqualTo(OK);
	}
	
}
