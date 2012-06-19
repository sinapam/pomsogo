package utils;

import java.io.IOException;
import java.util.Map;

public interface PaymentGateway {
	public String handleIPN(String queryString) throws IOException;
}