package com.educaciontit.digitalers.controllers;

import java.util.List;

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
import com.educaciontit.digitalers.entities.User;
import com.educaciontit.digitalers.repositories.UserRepository;
import com.educaciontit.digitalers.services.UserDTOService;

@RestController
@RequestMapping(value = { "/users" }, produces = { MediaType.APPLICATION_JSON_VALUE })
public class UserController implements GenericRestController<UserDTO, Long> {
	private static Logger logger = LogManager.getLogger();

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserDTOService userDTOService;

	public ResponseEntity<?> findById(Long id) {
		logger.info("ID : " + id);
		User user = userRepository.findById(id).orElse(null);
		logger.info(user);
		UserDTO userDTO = userDTOService.getUserDTO(user, "Usuario encontrado correctamente");
		return ResponseEntity.ok(userDTO);
	}

	public ResponseEntity<?> insert(@Valid UserDTO userDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			logger.info("contengo errores");
		}

		logger.info(userDTO);
		User user = userDTOService.getUser(userDTO);
		logger.info(user);
		userDTO.setMessage("Usuario creado correctamente");
		return ResponseEntity.ok(userDTO);
	}

	public ResponseEntity<?> update(@Valid UserDTO user, BindingResult bindingResult) {

		return null;
	}

	public ResponseEntity<?> delete(@Valid UserDTO user, BindingResult bindingResult) {

		return null;
	}

	public ResponseEntity<?> findAll() {
		List<User> users = userRepository.findAll();
		logger.info(users);
		return ResponseEntity.ok(users);
	}

}
