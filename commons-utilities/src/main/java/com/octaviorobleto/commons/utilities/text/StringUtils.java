package com.octaviorobleto.commons.utilities.text;

import java.util.Arrays;

/**
 * 
 * Proporciona una clase de utilidad para cadenas de carateres.
 * 
 * @author <a href="https://octaviorobleto.com" target="_blank">Octavio
 *         Robleto</a>
 * @version 1.0
 * @date 2022-07-13
 * @class StringUtils
 */
public final class StringUtils {

	/**
	 * Cadena vacia {@code ""}.
	 */
	public static final String EMPTY = "";

	/**
	 * Cadena con espacios {@code " "}.
	 *
	 */
	public static final String SPACE = " ";

	/**
	 * No permitir crear una instancia de {@code StringUtils}
	 */
	private StringUtils() {
	}

	/**
	 * Devuelve si el String es nulo
	 * 
	 * @param str {@link CharSequence} Puede proporcionar {@code null}
	 * @return {@link Boolean} si la secuencia de caracteres proporcionada es nula o
	 *         vacía / en blanco
	 * 
	 */
	public static boolean isEmpty(final CharSequence str) {
		return str == null || str.length() == 0;
	}

	/**
	 * Devuelve si String es numerico o no.
	 * 
	 * @param str {@link String}
	 * @return {@link Boolean} si el str proporcionado es numérico o no.
	 * 
	 */
	public static boolean isNumber(final String str) {
		return !isEmpty(str) && str.matches("\\d+(\\.\\d+)?");
	}

	/**
	 * Devuelve si el str es un numero entero o no
	 * 
	 * @param str {@link String}
	 * @return {@link Boolean} si el str proporcionado es entero o no.
	 * 
	 */
	public static boolean isInteger(final String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * Pone en mayuscula el primer caracter del str proporcionado sin alterar los
	 * demas caracteres
	 *
	 * @param str {@link String} Puede proporcionar {@code null}
	 * @return el primer caracter del str proporcionado en mayuscula, {@code null}
	 *         si la entrada del str es nula
	 */
	public static String capitalize(final String str) {
		return !isEmpty(str) ? str.substring(0, 1).toUpperCase().concat(str.substring(1)) : str;
	}

	/**
	 * Devuelve si el String es correo electronico
	 * 
	 * @param str {@link String} Puede proporcionar {@code null}
	 * @return {@link Boolean} si el str proporcionado es de tipo correo electronico
	 * 
	 */
	public static boolean isMail(final String str) {
		return !isEmpty(str) && str.matches("([a-zA-Z0-9]+(\\.?[a-zA-Z0-9])*)+@(([a-zA-Z]+)\\.([a-zA-Z]+))");
	}

	/**
	 * Devuelve un String con el caracter repetido n cantidad de veces
	 *
	 * @param str    {@link String} Puede proporcionar {@code null}
	 * @param repeat numero de veces para repetir cadena, negativo tratado como cero
	 * @return Cadena con caracter repetido
	 */
	public static String repeat(final String str, final int repeat) {
		if (isEmpty(str)) {
			return str;
		}
		if (repeat <= 0) {
			return EMPTY;
		}
		final String[] buf = new String[repeat];
		Arrays.fill(buf, str);
		return String.join("", buf);
	}

	/**
	 * Devuelve un String con el caracter repetido n cantidad de veces
	 *
	 * @param ch     {@link Character} cadena a repetir
	 * @param repeat numero de veces para repetir cadena, negativo tratado como cero
	 * @return Cadena con caracter repetido
	 */
	public static String repeat(final char ch, final int repeat) {
		if (repeat <= 0) {
			return EMPTY;
		}
		final char[] buf = new char[repeat];
		Arrays.fill(buf, ch);
		return new String(buf);
	}

	/**
	 * Rellenar a la derecha una cadena con una cadena especificada
	 *
	 * @param str    {@link String} Puede proporcionar {@code null}
	 * @param size   tamaño para rellenar
	 * @param padStr la cadena con la que rellenar, {@link String} Puede
	 *               proporcionar {@code null}
	 * @return {@code null} si str es nulo
	 */
	public static String rightPad(final String str, final int size, String padStr) {
		if (isEmpty(str)) {
			return str;
		}

		if (isEmpty(padStr)) {
			padStr = SPACE;
		}

		final int strLen = str.length();
		final int padLen = padStr.length();
		final int pads = size - strLen;

		if (pads <= 0) {
			return str;
		}

		if (padLen >= pads) {
			return str.concat(padStr.substring(0, pads));
		}

		final int repeat = (pads / padLen) + 1;
		final String strRepeat = repeat(padStr, repeat);

		return str.concat(strRepeat.substring(0, pads));
	}

	/**
	 * Rellenar a la izquierda una cadena con una cadena especificada
	 *
	 * @param str    {@link String} Puede proporcionar {@code null}
	 * @param size   tamaño para rellenar
	 * @param padStr la cadena con la que rellenar, {@link String} Puede
	 *               proporcionar {@code null}
	 * @return {@code null} si str es nulo
	 */
	public static String leftPad(final String str, final int size, String padStr) {
		if (isEmpty(str)) {
			return str;
		}

		if (isEmpty(padStr)) {
			padStr = SPACE;
		}

		final int strLen = str.length();
		final int padLen = padStr.length();
		final int pads = size - strLen;

		if (pads <= 0) {
			return str;
		}

		if (padLen >= pads) {
			return padStr.substring(0, pads).concat(str);
		}

		final int repeat = (pads / padLen) + 1;
		final String strRepeat = repeat(padStr, repeat);

		return strRepeat.substring(0, pads).concat(str);
	}

}
