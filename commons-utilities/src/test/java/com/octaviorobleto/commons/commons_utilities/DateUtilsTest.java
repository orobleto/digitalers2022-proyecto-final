package com.octaviorobleto.commons.commons_utilities;

import static com.octaviorobleto.commons.utilities.time.DateUtils.*;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

public class DateUtilsTest {
	@Test
	public void localDateYYYYMMDD() {
		LocalDate actual = getLocalDate("1983-03-15", "yyyy-MM-dd");
		LocalDate expected = LocalDate.parse("1983-03-15");
		assertEquals(expected, actual);
	}

	@Test
	public void localDateWhenSrtNull() {
		LocalDate actual = getLocalDate(null, "dd-MM-yyyy");
		LocalDate expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void localDateWhenFormatNull() {
		LocalDate actual = getLocalDate("1983-03-15", null);
		LocalDate expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void localDateWhenBothNull() {
		LocalDate actual = getLocalDate(null, null);
		LocalDate expected = null;
		assertEquals(expected, actual);
	}

	public void localDateWhenSrtEmpty() {
		LocalDate actual = getLocalDate("", "dd-MM-yyyy");
		LocalDate expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void localDateWhenFormatEmpty() {
		LocalDate actual = getLocalDate("1983-03-15", "");
		LocalDate expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void localDateWhenBothEmpty() {
		LocalDate actual = getLocalDate("", "");
		LocalDate expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void localDateTimeYYYYMMDDHHMMSS() {
		LocalDateTime actual = getLocalDateTime("1983-03-15 18:03:03", "yyyy-MM-dd HH:mm:ss");
		LocalDateTime expected = LocalDateTime.parse("1983-03-15T18:03:03");
		assertEquals(expected, actual);
	}

	@Test
	public void localDateTimeWhenSrtNull() {
		LocalDateTime actual = getLocalDateTime(null, "yyyy-MM-dd HH:mm:ss");
		LocalDateTime expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void localDateTimeWhenFormatNull() {
		LocalDateTime actual = getLocalDateTime("1983-03-15 18:03:03", null);
		LocalDateTime expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void localDateTimeWhenBothNull() {
		LocalDateTime actual = getLocalDateTime(null, null);
		LocalDateTime expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void localDateTimeWhenSrtEmpty() {
		LocalDateTime actual = getLocalDateTime("", "yyyy-MM-dd HH:mm:ss");
		LocalDateTime expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void localDateTimeWhenFormatEmpty() {
		LocalDateTime actual = getLocalDateTime("1983-03-15 18:03:03", "");
		LocalDateTime expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void localDateTimeWhenBothEmpty() {
		LocalDateTime actual = getLocalDateTime("", "");
		LocalDateTime expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void srtLocalDateDDMMYYYY() {
		String actual = getString(LocalDate.parse("1983-03-15"), "dd-MM-YYYY");
		String expected = "15-03-1983";
		assertEquals(expected, actual);
	}

	@Test
	public void srtWhenLocalDateNull() {
		LocalDate localDate = null;
		String actual = getString(localDate, "dd-MM-YYYY");
		String expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void srtWhenFormatNull() {
		String actual = getString(LocalDate.parse("1983-03-15"), null);
		String expected = null;
		assertEquals(expected, actual);
	}
	
	
	

}
