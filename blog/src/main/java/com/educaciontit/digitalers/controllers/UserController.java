package com.educaciontit.digitalers.controllers;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educaciontit.digitalers.dtos.UserDTO;
import com.educaciontit.digitalers.dtos.repositories.UserDTOImpl;
import com.educaciontit.digitalers.enums.MessageType;
import com.educaciontit.digitalers.exceptions.ExceptionDTO;
import com.educaciontit.digitalers.services.LoginService;
import com.educaciontit.digitalers.services.ResponseMessageService;

@RestController
@RequestMapping(value = { "/users" }, produces = { MediaType.APPLICATION_JSON_VALUE })
public class UserController implements GenericRestController<UserDTO, Long> {
	private static Logger logger = LogManager.getLogger();

	@Autowired
	private UserDTOImpl userDTOImpl;

	@Autowired
	private ResponseMessageService responseMessageService;

	@Autowired
	private LoginService loginService;

	public ResponseEntity<?> findById(Long id) {
		logger.info("ID : " + id);
		try {
			UserDTO userDTO = userDTOImpl.findById(id).orElse(null);
			return ResponseEntity.ok(userDTO);
		} catch (ExceptionDTO e) {
			logger.error(e);
			return ResponseEntity.status(404).body(responseMessageService.getResponseMessage(MessageType.NO_ELEMENTS,
					"Usuario con ID " + id + " No encontrado"));
		}
	}

	public ResponseEntity<?> insert(String uuid, @Valid UserDTO userDTO, BindingResult bindingResult) {
		logger.info("credential :" + uuid);

		if (uuid == null) {
			return ResponseEntity.status(400).body(responseMessageService.getResponseMessage(MessageType.BAD_REQUEST,
					"credential [" + uuid + "] No encontrada"));
		}
		if (!loginService.validateLogin(uuid)) {
			return ResponseEntity.status(409).body(responseMessageService
					.getResponseMessage(MessageType.VALIDATION_ERROR, "credential [" + uuid + "] No encontrada"));
		}

		return save(userDTO, bindingResult);
	}

	public ResponseEntity<?> update(String uuid, @Valid UserDTO userDTO, BindingResult bindingResult) {
		logger.info("credential :" + uuid);

		if (uuid == null) {
			return ResponseEntity.status(400).body(responseMessageService.getResponseMessage(MessageType.BAD_REQUEST,
					"credential [" + uuid + "] No encontrada"));
		}

		if (!loginService.validateLogin(uuid)) {
			return ResponseEntity.status(409).body(responseMessageService
					.getResponseMessage(MessageType.VALIDATION_ERROR, "credential [" + uuid + "] No encontrada"));
		}
		return save(userDTO, bindingResult);
	}

	public ResponseEntity<?> delete(String uuid, @Valid UserDTO userDTO, BindingResult bindingResult) {
		logger.info("credential :" + uuid);

		if (uuid == null) {
			return ResponseEntity.status(400).body(responseMessageService.getResponseMessage(MessageType.BAD_REQUEST,
					"credential [" + uuid + "] No encontrada"));
		}
		if (!loginService.validateLogin(uuid)) {
			return ResponseEntity.status(409).body(responseMessageService
					.getResponseMessage(MessageType.VALIDATION_ERROR, "credential [" + uuid + "] No encontrada"));
		}
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(400)
					.body(responseMessageService.getResponseMessage(MessageType.VALIDATION_ERROR, bindingResult));
		}

		try {
			userDTOImpl.findByEmail(userDTO.getEmail());
		} catch (ExceptionDTO e) {
			logger.error(e);
			return ResponseEntity.status(404).body(
					responseMessageService.getResponseMessage(MessageType.NO_ELEMENTS, userDTO + " No encontrado"));
		}

		userDTOImpl.delete(userDTO);

		return ResponseEntity.ok(
				responseMessageService.getResponseMessage(MessageType.DELETE_ELEMENT, "Usuario " + userDTO.getEmail())
						+ " eliminado correctamente");
	}

	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(userDTOImpl.findAll());
	}

	private ResponseEntity<?> save(UserDTO userDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(400)
					.body(responseMessageService.getResponseMessage(MessageType.VALIDATION_ERROR, bindingResult));
		}
		logger.info(userDTO);
		userDTOImpl.save(userDTO);

		userDTO.setMessage("Usuario Guardado Exitosamente");
		return ResponseEntity.ok(userDTO);
	}

}
