package functional.controllers;

import java.io.IOException;

import javax.servlet.ServletRequest;

import org.junit.Before;
import org.junit.Test;

import controllers.Application;

import play.mvc.Http.Response;
import play.test.FunctionalTest;
import utils.PaymentGateway;

import static org.mockito.Mockito.*;

public class TestIPN extends FunctionalTest {
	
	@Test
	public void testGetPaypalIPNSuccess() throws IOException {
		PaymentGateway mockedVerifiredPayment = mock(PaymentGateway.class);
		when(mockedVerifiredPayment.handleIPN(any(String.class))).thenReturn("VERIFIED");
		Application.payment = mockedVerifiredPayment;
        Response response = GET("/ipn");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertContentMatch("Payment confirmed", response);
	}
	
	@Test
	public void testGetPaypalIPNFailure() throws IOException {
		PaymentGateway mockedInvalidPayment = mock(PaymentGateway.class);
		when(mockedInvalidPayment.handleIPN(any(String.class))).thenReturn("INVALID");
		Application.payment = mockedInvalidPayment;
        Response response = GET("/ipn");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertContentMatch("Payment invalid", response);
	}	
}
