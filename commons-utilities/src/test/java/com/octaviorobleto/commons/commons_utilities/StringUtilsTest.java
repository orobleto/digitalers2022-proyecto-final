package com.octaviorobleto.commons.commons_utilities;

import static com.octaviorobleto.commons.utilities.text.StringUtils.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringUtilsTest {
	@Test
	public void srtEmptyWhenNull() {
		boolean actual = isEmpty(null);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void srtEmptyWhenNotNull() {
		boolean actual = isEmpty("");
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void srtNotEmpty() {
		boolean actual = isEmpty("not empty");
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void srtNumberWithInteger() {
		boolean actual = isNumber("853");
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void srtNumberWithDecimals() {
		boolean actual = isNumber("853.36");
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void srtNumberWhenNull() {
		boolean actual = isNumber(null);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void srtNumberWhenNotNull() {
		boolean actual = isNumber("");
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void srtNumberWithWords() {
		boolean actual = isNumber("with words");
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void srtCapitalizeWithWords() {
		String actual = capitalize("withWords");
		String expected = "WithWords";
		assertEquals(expected, actual);
	}

	@Test
	public void srtCapitalizeWhenNull() {
		String actual = capitalize(null);
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void srtCapitalizeWhenNotNull() {
		String actual = capitalize("");
		String expected = "";
		assertEquals(expected, actual);
	}

	@Test
	public void srtIntegerWithDecimals() {
		boolean actual = isInteger("853.36");
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void srtIntegerWhenNull() {
		boolean actual = isInteger(null);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void srtIntegerWhenNotNull() {
		boolean actual = isInteger("");
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void srtIntegerWithWords() {
		boolean actual = isInteger("with words");
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void srtMailWhenNull() {
		boolean actual = isMail(null);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void srtMailWhenNotNull() {
		boolean actual = isMail("");
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void srtMailWithWords() {
		boolean actual = isMail("with words");
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void srtWithCorrectMail() {
		boolean actual = isMail("octavio.robleto@gmail.com");
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void srtWrongCorrectMail() {
		boolean actual = isMail("octavio.robleto@gmail");
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void srtRepeatWithWords() {
		String actual = repeat(".", 10);
		String expected = "..........";
		assertEquals(expected, actual);
	}

	@Test
	public void srtLeftPad() {
		String actual = leftPad("octavio", 50, "*-");
		String expected = "*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*octavio";
		assertEquals(expected, actual);
	}

	@Test
	public void srtRightPad() {
		String actual = rightPad("octavio", 50, "*-");
		String expected = "octavio*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*";
		assertEquals(expected, actual);
	}

}
