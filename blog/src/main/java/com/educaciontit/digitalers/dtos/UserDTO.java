package com.educaciontit.digitalers.dtos;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	private String email;
	@NotEmpty(message = "Debe enviar una clave[key]")
	private String key;
	private Boolean active;
	private String message;
}
