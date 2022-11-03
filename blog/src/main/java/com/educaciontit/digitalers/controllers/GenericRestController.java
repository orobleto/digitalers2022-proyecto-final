package com.educaciontit.digitalers.controllers;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public interface GenericRestController<T, ID> {

	@GetMapping(value = { "/findByID/{id}" })
	ResponseEntity<?> findById(@PathVariable(name = "id", required = true) ID id);

	@PostMapping(value = { "/insert" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> insert(@RequestHeader(value = "credential", required = false) String uuid,
			@RequestBody @Valid T t, BindingResult bindingResult);

	@PutMapping(value = { "/update" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> update(@RequestHeader(value = "credential", required = false) String uuid,
			@RequestBody @Valid T t, BindingResult bindingResult);

	@DeleteMapping(value = { "/delete" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> delete(@RequestHeader(value = "credential", required = false) String uuid,
			@RequestBody @Valid T t, BindingResult bindingResult);

	@GetMapping(value = { "/findAll" })
	ResponseEntity<?> findAll();

}
