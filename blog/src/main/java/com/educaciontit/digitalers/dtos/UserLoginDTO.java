package com.educaciontit.digitalers.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDTO {
	@Email(message = "Email Debe ser un tipo Correo Electronico")
	@NotEmpty(message = "Debe enviar correo[email]")
	private String email;
	@NotEmpty(message = "Debe enviar clave[key]")
	private String key;
}
