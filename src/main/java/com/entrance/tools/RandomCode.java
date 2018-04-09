package com.entrance.tools;

import java.util.Random;

public class RandomCode {
	public static final String VERIFY_CODES = "0123456789ABCDEFGHJKLMNPQRSTUVWXYZqwertyuiopasdfghjklzxcvbnm";

	public static String generateVerifyCode(int verifySize) {
		return generateVerifyCode(verifySize, VERIFY_CODES);
	}

	public static String generateVerifyCode(int verifySize, String sources) {
		if (sources == null || sources.length() == 0) {
			sources = VERIFY_CODES;
		}
		int codesLen = sources.length();
		Random rand = new Random(System.currentTimeMillis());
		StringBuilder verifyCode = new StringBuilder(verifySize);
		for (int i = 0; i < verifySize; i++) {
			verifyCode.append(sources.charAt(rand.nextInt(codesLen - 1)));
		}
		return verifyCode.toString();
	}

	public String getCode() {
		return generateVerifyCode(8);
	}
}
