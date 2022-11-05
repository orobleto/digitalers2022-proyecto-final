package com.educaciontit.digitalers.settings;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.educaciontit.digitalers.entities.Publication;
import com.educaciontit.digitalers.entities.User;
import com.educaciontit.digitalers.repositories.PublicationRepository;
import com.educaciontit.digitalers.repositories.UserRepository;
import com.octaviorobleto.commons.utilities.text.CodeUtils;

@Component
public class DataInitialize implements CommandLineRunner {
	private static Logger logger = LogManager.getLogger();
	@Value("${database.key}")
	private String KEY_AES;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PublicationRepository publicationRepository;

	public void run(String... args) throws Exception {
		users();
		publications();
		
	}

	private void users() {
		logger.info("users...");
		logger.info(KEY_AES);

		userRepository.save(User.builder().email("user1@gmail.com")
				.key(CodeUtils.AES_Encrypt("1234", "user1@gmail.com".concat(KEY_AES))).active(true)
				.creationDate(LocalDateTime.now()).build());
		userRepository.save(User.builder().email("user2@gmail.com")
				.key(CodeUtils.AES_Encrypt("1234", "user2@gmail.com".concat(KEY_AES))).active(false)
				.creationDate(LocalDateTime.now()).build());

		logger.info(userRepository.findById(1L));
		logger.info(userRepository.findByEmail("user2@gmail.com"));

	}

	private void publications() {
		publicationRepository.save(Publication.builder().title("Publicacion 1")
				.body("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...")
				.user(User.builder().id(1L).build()).build());
		publicationRepository.save(Publication.builder().title("Publicacion 2").body(
				"qui dolorem ipsum, quia dolor sit amet consectetur adipisci velit, sed quia non numquam eius modi tempora incidunt, ut labore et dolore magnam aliquam quaerat voluptatem")
				.user(User.builder().id(1L).build()).build());

		publicationRepository.save(Publication.builder().title("Publicacion 1").body(
				"Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but occasionally circumstances occur in which toil and pain can procure him some great pleasure")
				.user(User.builder().id(2L).build()).build());

	}

}
