package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletRequest;

public class PayPalHandler implements PaymentGateway {

	public String handleIPN(String str) throws IOException {

		// post back to PayPal system to validate
		// NOTE: change http: to https: in the following URL to verify using SSL
		// (for increased security).
		// using HTTPS requires either Java 1.4 or greater, or Java Secure
		// Socket Extension (JSSE)
		// and configured for older versions.
		URL u = new URL("https://www.sandbox.paypal.com/cgi-bin/webscr");
		URLConnection uc = u.openConnection();
		uc.setDoOutput(true);
		uc.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		PrintWriter pw = new PrintWriter(uc.getOutputStream());
		pw.println(str);
		pw.close();

		BufferedReader in = new BufferedReader(new InputStreamReader(
				uc.getInputStream()));
		String res = in.readLine();
		in.close();


		return res;
		
//		// assign posted variables to local variables
//		String itemName = request.getParameter("item_name");
//		String itemNumber = request.getParameter("item_number");
//		String paymentStatus = request.getParameter("payment_status");
//		String paymentAmount = request.getParameter("mc_gross");
//		String paymentCurrency = request.getParameter("mc_currency");
//		String txnId = request.getParameter("txn_id");
//		String receiverEmail = request.getParameter("receiver_email");
//		String payerEmail = request.getParameter("payer_email");

		// // check notification validation
		// if(res.equals("VERIFIED")) {
		// // check that paymentStatus=Completed
		// // check that txnId has not been previously processed
		// // check that receiverEmail is your Primary PayPal email
		// // check that paymentAmount/paymentCurrency are correct
		// // process payment
		// }
		// else if(res.equals("INVALID")) {
		// // log for investigation
		// }
		// else {
		// // error
		// }
	}
}
