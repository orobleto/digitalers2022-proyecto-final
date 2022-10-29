package com.educaciontit.digitalers.services;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.educaciontit.digitalers.entities.ResponseMessage;
import com.educaciontit.digitalers.enums.MessageType;

@Service
public class ResponseMessageService {
	public ResponseMessage getResponseMessage(MessageType messageType, Object object) {
		String description = null;

		if (object instanceof String) {
			description = (String) object;
		} else if (object instanceof BindingResult) {
			BindingResult bindingResult = (BindingResult) object;

			description = bindingResult.getAllErrors().stream().map(error -> error.getDefaultMessage())
					.collect(Collectors.joining(", "));
		}

		return ResponseMessage.builder().messageType(messageType).description(description).build();
	}
}
