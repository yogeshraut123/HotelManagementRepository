package com.terrapay.main.encodedecode;

import java.util.Base64;

public class Converter {

	public static String encodepassword(String password) {
		String encodedString = Base64.getEncoder().encodeToString(password.getBytes());
		return encodedString;
	}

	public static String decodepassword(String password) {
		byte[] decodedBytes = Base64.getDecoder().decode(password);
		String decodedString = new String(decodedBytes);
		return decodedString;
	}

}
