package com.educaciontit.digitalers.services;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.educaciontit.digitalers.entities.Login;

@Service
public class LoginService {
	private static Logger logger = LogManager.getLogger();
	private static Map<String, Login> loggedUsers = new ConcurrentHashMap<>();

	@Value("${login.expiresIn}")
	private Long expiresIn;
	@Value("${login.type}")
	private String type;
	@Value("${login.credential}")
	private String credential;

	public Login getLogin(String mail) {
		Login login = Login.builder().uuid(UUID.randomUUID()).creationDate(LocalDateTime.now()).expiresIn(expiresIn)
				.type(type).credential(credential).build();
		loggedUsers.put(mail, login);
		logger.info(loggedUsers);
		return login;
	}
	
	
	
	
	
	

}
