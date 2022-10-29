package com.educaciontit.digitalers.entities;

import org.springframework.stereotype.Component;

import com.educaciontit.digitalers.enums.MessageType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class ResponseMessage {
	private MessageType messageType;
	private String description;
}
