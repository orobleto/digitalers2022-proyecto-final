package com.educacionit.digitalers.entidades;

import java.time.LocalDateTime;

public class UsuarioBuilder {
	private Integer id;
	private String correo;
	private String clave;
	private Boolean activo;
	private LocalDateTime fechaCreacion;

	public UsuarioBuilder() {

	}

	public UsuarioBuilder id(Integer id) {
		this.id = id;
		return this;
	}

	public String toString() {
		return "UsuarioBuilder [correo=" + correo + ", clave=" + clave + ", activo=" + activo + ", fechaCreacion="
				+ fechaCreacion + "]";
	}

	public UsuarioBuilder correo(String correo) {
		this.correo = correo;
		return this;
	}

	public UsuarioBuilder clave(String clave) {
		this.clave = clave;
		return this;
	}

	public UsuarioBuilder activo(Boolean activo) {
		this.activo = activo;
		return this;
	}

	public UsuarioBuilder fechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
		return this;
	}

	public Usuario build() {
		return new Usuario(id, correo, clave, activo, fechaCreacion);
	}

}
