package com.educaciontit.digitalers.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
}
