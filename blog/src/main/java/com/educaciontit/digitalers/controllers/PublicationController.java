package com.educaciontit.digitalers.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educaciontit.digitalers.entities.Publication;
import com.educaciontit.digitalers.enums.MessageType;
import com.educaciontit.digitalers.repositories.PublicationRepository;
import com.educaciontit.digitalers.services.ResponseMessageService;

@RestController
@RequestMapping(value = { "/publications" }, produces = { MediaType.APPLICATION_JSON_VALUE })
public class PublicationController implements GenericRestController<Publication, Long> {
	private static Logger logger = LogManager.getLogger();
	@Autowired
	private PublicationRepository publicationRepository;
	@Autowired
	private ResponseMessageService responseMessageService;

	public ResponseEntity<?> findById(Long id) {

		logger.info("ID : " + id);
		Publication publication = publicationRepository.findById(id).orElse(null);
		if (publication == null) {
			return ResponseEntity.status(404).body(responseMessageService.getResponseMessage(MessageType.NO_ELEMENTS,
					"Publicacion con ID " + id + " No encontrada"));
		}

		return ResponseEntity.ok(publication);
	}

	public ResponseEntity<?> insert(String uuid, @Valid Publication publication, BindingResult bindingResult) {

		return null;
	}

	public ResponseEntity<?> update(String uuid, @Valid Publication publication, BindingResult bindingResult) {

		return null;
	}

	public ResponseEntity<?> delete(String uuid, @Valid Publication publication, BindingResult bindingResult) {

		return null;
	}

	public ResponseEntity<?> findAll() {
		List<Publication> publications = publicationRepository.findAll();
		logger.info(publications);
		return ResponseEntity.ok(publications);
	}

	@GetMapping(value = { "/findByUserId/{id_user}" })
	public ResponseEntity<?> findAll(@PathVariable(name = "id_user", required = true) Long id_user) {
		// 
		
		List<Publication> publications = publicationRepository.findByUserId(id_user);
		logger.info(publications);
		return ResponseEntity.ok(publications);
	}

}
