package functional.controllers;

import java.io.IOException;

import javax.servlet.ServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import controllers.Application;

import play.mvc.Http.Response;
import play.test.FunctionalTest;
import utils.PaymentGateway;

import static org.mockito.Mockito.*;

public class TestIPN extends FunctionalTest {

	@Test
	public void testGetPaypalIPNSuccess() throws IOException {
		PaymentGateway mockedVerifiredPayment = mock(PaymentGateway.class);
		when(mockedVerifiredPayment.handleIPN(any(String.class))).thenReturn(
				"VERIFIED");
		Application.payment = mockedVerifiredPayment;
		Response response = GET("/ipn");
		assertIsOk(response);
		// TODO test with real order model
		assertContentMatch("Order created", response);
	}

	@Test
	public void testGetPaypalIPNFailure() throws IOException {
		PaymentGateway mockedInvalidPayment = mock(PaymentGateway.class);
		when(mockedInvalidPayment.handleIPN(any(String.class))).thenReturn(
				"INVALID");
		Application.payment = mockedInvalidPayment;
		Response response = GET("/ipn");
		assertIsOk(response);
		// TODO test with real order model
		assertContentMatch("Order not created", response);
	}
	
	@Test
	public void testGetPaypalIPNUnknownResponse() throws IOException {
		PaymentGateway mockedUnknownPayment = mock(PaymentGateway.class);
		when(mockedUnknownPayment.handleIPN(any(String.class))).thenReturn(
				"UNKNOWN");
		Application.payment = mockedUnknownPayment;
		Response response = GET("/ipn");
		assertIsOk(response);
		// TODO test with real order model
		assertContentMatch("Order not created", response);
	}
	
	@Test
	public void testDataSentToPaypal() {
		// Arrange
		PaymentGateway mockedPayment = mock(PaymentGateway.class);
		Application.payment = mockedPayment;
		/* 
		 * the test params referenced from :
		 * - https://cms.paypal.com/us/cgi-bin/?cmd=_render-content&content_ID=developer/e_howto_admin_IPNIntro#id091F0M006Y4
		 */
		String params = "mc_gross=19.95&protection_eligibility=Eligible&address_status=confirmed&payer_id=LPLWNMTBWMFAY&tax=0.00&address_street=1+Main+St&payment_date=20%3A12%3A59+Jan+13%2C+2009+PST&payment_status=Completed&charset=windows-1252&address_zip=95131&first_name=Test&mc_fee=0.88&address_country_code=US&address_name=Test+User&notify_version=2.6&custom=&payer_status=verified&address_country=United+States&address_city=San+Jose&quantity=1&verify_sign=AtkOfCXbDm2hu0ZELryHFjY-Vb7PAUvS6nMXgysbElEn9v-1XcmSoGtf&payer_email=gpmac_1231902590_per%40paypal.com&txn_id=61E67681CH3238416&payment_type=instant&last_name=User&address_state=CA&receiver_email=gpmac_1231902686_biz%40paypal.com&payment_fee=0.88&receiver_id=S8XGHLYDW9T3S&txn_type=express_checkout&item_name=&mc_currency=USD&item_number=&residence_country=US&test_ipn=1&handling_amount=0.00&transaction_subject=&payment_gross=19.95&shipping=0.00";
		// Act
		GET("/ipn?" + params);
		// Assert
		ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
		try {
			verify(Application.payment).handleIPN(arg.capture());
		} catch (IOException e) {
			fail(e.getMessage());
		}
		String expected = "cmd=_notify-validate&" + params;
		assertEquals(expected, arg.getValue());
	}
}
