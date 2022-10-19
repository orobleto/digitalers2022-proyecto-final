package com.octaviorobleto.commons.utilities.text;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * 
 * Proporciona una clase de utilidad para convertir objetos y cadenas en Json
 * con la libreria Gson de Google
 * 
 * @author <a href="https://octaviorobleto.com" target="_blank">Octavio
 *         Robleto</a>
 * @version 1.0
 * @date 2022-07-22
 * @class JsonUtils
 */

public final class JsonUtils {
	/**
	 * No permitir crear una instancia de {@code JsonUtils}
	 */
	private JsonUtils() {
	}

	/**
	 * Devuelve una cadena de caracteres en forma de Json, Los Objetos LocalDate y
	 * LocalDatetime los formatea con el patron ISO_LOCAL_DATE y ISO_LOCAL_DATETIME
	 * respectivamente
	 * 
	 * @param obj    {@link Object} Entidad a transformar
	 * @param pretty {@link Boolean} indica si lo quiere con los saltos de linea
	 *               propios de un json
	 * @return {@link String}
	 * 
	 * 
	 */
	public static String convertObjectToGson(final Object obj, final boolean pretty) {
		JsonSerializer<LocalDate> LocalDateAdapter = new JsonSerializer<LocalDate>() {
			public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
				return new JsonPrimitive(src.format(DateTimeFormatter.ISO_LOCAL_DATE));
			}
		};

		JsonSerializer<LocalDateTime> LocalDateTimeAdapter = new JsonSerializer<LocalDateTime>() {
			public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
				return new JsonPrimitive(src.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
			}
		};

		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(LocalDate.class, LocalDateAdapter);
		builder.registerTypeAdapter(LocalDateTime.class, LocalDateTimeAdapter);
		if (pretty) {
			builder.setPrettyPrinting();
		}
		return builder.create().toJson(obj);
	}

	/**
	 * Devuelve una cadena de caracteres en forma de Json
	 * 
	 * @param obj            {@link Object} Entidad a transformar
	 * @param pretty         {@link Boolean} indica si lo quiere con los saltos de
	 *                       linea propios de un json
	 * @param formatDate     {@link String} formatea un LocalDate utilizando el
	 *                       patron especificado
	 * @param formatDateTime {@link String} formatea un LocalDateTime utilizando el
	 *                       patron especificado
	 * @return {@link String}
	 * 
	 * 
	 */
	public static String convertObjectToGson(final Object obj, final boolean pretty, final String formatDate,
			final String formatDateTime) {
		JsonSerializer<LocalDate> LocalDateAdapter = new JsonSerializer<LocalDate>() {
			public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
				return new JsonPrimitive(src.format(DateTimeFormatter.ofPattern(formatDate)));
			}
		};

		JsonSerializer<LocalDateTime> LocalDateTimeAdapter = new JsonSerializer<LocalDateTime>() {
			public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
				return new JsonPrimitive(src.format(DateTimeFormatter.ofPattern(formatDateTime)));
			}
		};

		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(LocalDate.class, LocalDateAdapter);
		builder.registerTypeAdapter(LocalDateTime.class, LocalDateTimeAdapter);
		if (pretty) {
			builder.setPrettyPrinting();
		}
		return builder.create().toJson(obj);
	}

}
