package com.educacionit.digitalers.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.educacionit.digitalers.entidades.Usuario;

import jakarta.ws.rs.core.MediaType;

@Controller // @RestController
public class PrimerControlador {
	@Autowired
	Usuario usuario1;// usuarioImplentacion ,  EntidadGenerica @

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home(Model model) {

		System.out.println(usuario1);
		model.addAttribute("saludo", "Octavio Robleto");
		return "home";
	}

	@RequestMapping(value = "/hola.html", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public String hola() {

		return new String("hola");
	}

}
