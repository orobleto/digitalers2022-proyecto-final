package com.educaciontit.digitalers.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class Login {
	private UUID uuid;
	private LocalDateTime creationDate;
	private Long expiresIn;
	private String type;
	private String credential;
	@JsonIgnore
	private String email;
}
