package com.educacionit.digitalers.entidades;

import org.springframework.stereotype.Component;

@Component
public class Usuario {
	private String correo;
	private String clave;

	@Override
	public String toString() {
		return "Usuario [correo=" + correo + ", clave=" + clave + "]";
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}
