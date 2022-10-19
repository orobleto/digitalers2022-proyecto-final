package com.octaviorobleto.commons.commons_utilities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.octaviorobleto.commons.utilities.text.CodeUtils;

public class CodeTest {

	@Test
	public void Base64Encode() {
		String str = "clase de cifrado";
		String actual = CodeUtils.BASE64_Encode(str);
		String expected = "Y2xhc2UgZGUgY2lmcmFkbw==";
		assertEquals(expected, actual);
	}

	@Test
	public void Base64EDecode() {
		String str = "Y2xhc2UgZGUgY2lmcmFkbw==";
		String actual = CodeUtils.BASE64_Decode(str);
		String expected = "clase de cifrado";
		assertEquals(expected, actual);
	}

	@Test
	public void AES_Encrypt() {
		String str = "clase de cifrado";
		String password = "MiClave";
		String actual = CodeUtils.AES_Encrypt(str, password);
		String expected = "uy5CuwpZIphdcPxVAHEKgsDKLF0uHl4KUkZY7mDFyyU=";
		assertEquals(expected, actual);
	}

	@Test
	public void AES_Decrypt() {
		String str = "uy5CuwpZIphdcPxVAHEKgsDKLF0uHl4KUkZY7mDFyyU=";
		String password = "MiClave";
		String actual = CodeUtils.AES_Decrypt(str, password);
		String expected = "clase de cifrado";
		assertEquals(expected, actual);
	}

}
