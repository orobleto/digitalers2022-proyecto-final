package com.octaviorobleto.commons.utilities.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.octaviorobleto.commons.utilities.text.StringUtils;

/**
 * 
 * Proporciona una clase de utilidad para fechas desde Java 8.
 * 
 * @author <a href="https://octaviorobleto.com" target="_blank">Octavio
 *         Robleto</a>
 * @version 1.0
 * @date 2022-07-13
 * @class DateUtils
 */
public final class DateUtils {
	/**
	 * @see Formatos Java <a href=
	 *      "https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#patterns"
	 *      target="_blank">DateTimeFormatter</a>
	 */

	public static final String FORMAT_YYYY_MM_DD;
	public static final String FORMAT_YYYY_MM_DD_HH_MM_SS_24H;
	public static final String FORMAT_YYYY_MM_DD_HH_MM_SS_12H;
	public static final String FORMAT_DATE_ISO_TOSTRING_FROM_JS;

	// se inicializan las constantes
	static {
		FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
		FORMAT_YYYY_MM_DD_HH_MM_SS_24H = "yyyy-MM-dd HH:mm:ss";
		FORMAT_YYYY_MM_DD_HH_MM_SS_12H = "yyyy-MM-dd KK:mm:ss a";
		FORMAT_DATE_ISO_TOSTRING_FROM_JS = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	}

	/**
	 * No permitir crear una instancia de {@code DateUtils}
	 */
	private DateUtils() {
	}

	/**
	 * Retorna una instancia {@link LocalDate} a partir de una cadena de texto con
	 * el formato indicado
	 * 
	 * @param srtDate {@link String} Puede proporcionar {@code null}
	 * @param format  {@link String} Puede proporcionar {@code null}
	 * @return {@code null} si srtDate o format es nulo
	 */
	public static LocalDate getLocalDate(final String srtDate, final String format) {
		if (StringUtils.isEmpty(srtDate) || StringUtils.isEmpty(format)) {
			return null;
		}
		return LocalDate.parse(srtDate, DateTimeFormatter.ofPattern(format));
	}

	/**
	 * Retorna una instancia {@link LocalDateTime} a partir de una cadena de texto
	 * con el formato indicado
	 * 
	 * @param srtDate {@link String} Puede proporcionar {@code null}
	 * @param format  {@link String} Puede proporcionar {@code null}
	 * @return {@code null} si srtDate o format es nulo
	 */
	public static LocalDateTime getLocalDateTime(final String srtDate, final String format) {
		if (StringUtils.isEmpty(srtDate) || StringUtils.isEmpty(format)) {
			return null;
		}
		return LocalDateTime.parse(srtDate, DateTimeFormatter.ofPattern(format));
	}

	/**
	 * Retorna una cadena de texto a partir de un LocalDate con el formato indicado
	 * 
	 * @param localDate {@link LocalDate} Puede proporcionar {@code null}
	 * @param format    {@link String} Puede proporcionar {@code null}
	 * @return {@code null} si localDate o format es nulo
	 */
	public static String getString(final LocalDate localDate, final String format) {
		if (localDate == null || StringUtils.isEmpty(format)) {
			return null;
		}
		return localDate.format(DateTimeFormatter.ofPattern(format));
	}

	/**
	 * Retorna una cadena de texto a partir de un LocalDateTime con el formato
	 * indicado
	 * 
	 * @param localDate {@link LocalDateTime} Puede proporcionar {@code null}
	 * @param format    {@link String} Puede proporcionar {@code null}
	 * @return {@code null} si localDate o format es nulo
	 */
	public static String getString(final LocalDateTime localDate, final String format) {
		if (localDate == null || StringUtils.isEmpty(format)) {
			return null;
		}
		return localDate.format(DateTimeFormatter.ofPattern(format));
	}

	/**
	 * Retorna una cadena de texto a partir de un Date con el formato indicado
	 * 
	 * @param Date   {@link Date} Puede proporcionar {@code null}
	 * @param format {@link String} Puede proporcionar {@code null}
	 * @return {@code null} si date o format es nulo
	 */

	public static String getString(final Date date, final String format) {
		if (date == null || StringUtils.isEmpty(format)) {
			return null;
		}
		return new SimpleDateFormat(format).format(date);
	}

	/**
	 * Retorna una instancia {@link Date} a partir de una cadena de texto con el
	 * formato indicado
	 * 
	 * @param srtDate {@link String} Puede proporcionar {@code null}
	 * @param format  {@link String} Puede proporcionar {@code null}
	 * @return {@code null} si srtDate o format es nulo
	 */
	public static Date getDate(final String srtDate, final String format) {
		if (StringUtils.isEmpty(srtDate) || StringUtils.isEmpty(format)) {
			return null;
		}
		try {
			return new SimpleDateFormat(format).parse(srtDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Retorna una instancia {@link Date} a partir de un LocalDate
	 * 
	 * @param localDate {@link LocalDate} Puede proporcionar {@code null}
	 * @return {@code null} si localDate es nulo
	 */

	public static Date getDate(final LocalDate localDate) {
		if (localDate == null) {
			return null;
		}
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Retorna una instancia {@link Date} a partir de un localDateTime
	 * 
	 * @param localDateTime {@link localDateTime} Puede proporcionar {@code null}
	 * @return {@code null} si localDateTime es nulo
	 */
	public static Date getDate(final LocalDateTime localDateTime) {
		if (localDateTime == null) {
			return null;
		}
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Retorna una instancia {@link LocalDate} a partir de un Date
	 * 
	 * @param date {@link Date} Puede proporcionar {@code null}
	 * @return {@code null} si date es nulo
	 */
	public static LocalDate getLocalDate(final Date date) {
		if (date == null) {
			return null;
		}
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	/**
	 * Retorna una instancia {@link LocalDateTime} a partir de un Date
	 * 
	 * @param date {@link Date} Puede proporcionar {@code null}
	 * @return {@code null} si date es nulo
	 */
	public static LocalDateTime getLocalDateTime(final Date date) {
		if (date == null) {
			return null;
		}
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	/**
	 * Retorna una instancia {@link LocalDateTime} a partir de un entero largo que
	 * representa la fecha y hora en milisegundos
	 * 
	 * @param date {@link Long} Puede proporcionar {@code null}
	 * @return {@code null} si date es nulo
	 */
	public static LocalDateTime getLocalDateTime(final Long date) {
		if (date == null) {
			return null;
		}
		return Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

}
