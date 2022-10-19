package com.octaviorobleto.commons.utilities.text;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * 
 * Proporciona una clase de utilidad para codificar cadenas.
 * 
 * @author <a href="https://octaviorobleto.com" target="_blank">Octavio
 *         Robleto</a>
 * @version 1.0
 * @date 2022-07-21
 * @class CodeUtils
 */
public class CodeUtils {
	public static final String ALGORITHM;
	private static String SALT;
	private static String UTF;

	static {
		// PBKDF2WithHmacSHA512 PBKDF2WithHmacSHA1
		ALGORITHM = "SHA-256";
		SALT = "friD_2e@pezufoP@*8DA60pr8swezl!9";
		UTF = "UTF-8";
	}

	/**
	 * No permitir crear una instancia de {@code CodeUtils}
	 */
	private CodeUtils() {
	}

	/**
	 * Retorna una cadena de caracteres codificada en base 64
	 *
	 * @param str {@link String} Puede proporcionar {@code null}
	 * @return
	 */
	public static String BASE64_Encode(final String str) {
		try {
			return StringUtils.isEmpty(str) ? str : Base64.getEncoder().encodeToString(str.getBytes(UTF));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * Retorna una cadena de caracteres decodificada de base 64
	 *
	 * @param str {@link String} Puede proporcionar {@code null}
	 * @return
	 */
	public static String BASE64_Decode(final String str) {
		return StringUtils.isEmpty(str) ? str : new String(Base64.getDecoder().decode(str));
	}

	/**
	 * Retorna una cadena de caracteres encriptada en AES y Base 64
	 * 
	 * @param str      {@link String} Puede proporcionar {@code null}
	 * @param password {@link String} Puede proporcionar {@code null}
	 * @return valor encriptado en AES
	 */

	public static String AES_Encrypt(final String str, final String password) {
		if (StringUtils.isEmpty(str) || StringUtils.isEmpty(password)) {
			return null;
		}

		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, getKey(password));
			return Base64.getEncoder().encodeToString(cipher.doFinal(str.getBytes(UTF)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Retorna una cadena de caracteres desencriptada
	 * 
	 * @param str      {@link String} Puede proporcionar {@code null}
	 * @param password {@link String} Puede proporcionar {@code null}
	 * @return
	 */
	public static String AES_Decrypt(String str, String password) {
		if (StringUtils.isEmpty(str) || StringUtils.isEmpty(password)) {
			return null;
		}
		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, getKey(password));

			return new String(cipher.doFinal(Base64.getDecoder().decode(str)));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * retorna clave secreta {@link SecretKeySpec}
	 * 
	 * @param password
	 * @return 
	 */
	private static SecretKeySpec getKey(final String password) {
		SecretKeySpec secretKeySpec = null;
		try {
			byte[] passwordArray = password.concat(SALT).getBytes(UTF);
			MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
			passwordArray = messageDigest.digest(passwordArray);
			secretKeySpec = new SecretKeySpec(passwordArray, "AES");
			return secretKeySpec;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return secretKeySpec;
	}
}
