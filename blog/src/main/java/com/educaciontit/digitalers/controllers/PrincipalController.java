package com.educaciontit.digitalers.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PrincipalController {

	@GetMapping(value = { "/", "/ping" })
	@ResponseBody
	public ResponseEntity<String> ping() {
		return ResponseEntity.ok("pong");
	}
}
