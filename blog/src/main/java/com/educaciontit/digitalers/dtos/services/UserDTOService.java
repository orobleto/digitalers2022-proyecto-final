package com.educaciontit.digitalers.dtos.services;

import org.springframework.stereotype.Service;

import com.educaciontit.digitalers.dtos.UserDTO;
import com.educaciontit.digitalers.entities.User;
import com.educaciontit.digitalers.exceptions.ExceptionDTO;

@Service
public class UserDTOService {


	public User getUser(UserDTO userDTO) {
		if (userDTO == null) {
			throw new ExceptionDTO("UserDTO Nulo");
		}
		return User.builder().email(userDTO.getEmail()).key(userDTO.getKey()).active(userDTO.getActive()).build();
	}

	public UserDTO getUserDTO(User user, String message) {
		if (user == null) {
			throw new ExceptionDTO("User Nulo");
		}
		UserDTO userDTO = UserDTO.builder().email(user.getEmail()).key(user.getKey()).active(user.getActive())
				.message(message == null ? "" : message).build();
		return userDTO;
	}
}
