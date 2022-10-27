package com.educaciontit.digitalers.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educaciontit.digitalers.dtos.UserDTO;
import com.educaciontit.digitalers.entities.User;
import com.educaciontit.digitalers.exceptions.ExceptionDTO;
import com.educaciontit.digitalers.repositories.UserRepository;
import com.octaviorobleto.commons.utilities.text.CodeUtils;

@Service
public class UserDTOService {
	private String KEY_AES = "Digitalers2022";
	@Autowired
	private UserRepository userRepository;

	public User getUser(UserDTO userDTO) {
		if (userDTO == null) {
			throw new ExceptionDTO("Objeto Nulo");
		}
		User user = userRepository.findByEmail(userDTO.getEmail()).orElse(null);
		if (user == null) {
			String key = CodeUtils.AES_Encrypt(userDTO.getKey(), KEY_AES);
			user = User.builder().email(userDTO.getEmail()).key(key).active(userDTO.getActive())
					.creationDate(LocalDateTime.now()).build();
			userRepository.save(user);
			userDTO.setKey(key);
		}
		
		
		return user;
	}

	public UserDTO getUserDTO(User user, String message) {
		UserDTO userDTO = UserDTO.builder().email(user.getEmail()).key(user.getKey()).active(user.getActive())
				.message(message).build();
		return userDTO;
	}
}
