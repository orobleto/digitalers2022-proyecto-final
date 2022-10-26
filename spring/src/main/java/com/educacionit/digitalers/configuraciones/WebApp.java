package com.educacionit.digitalers.configuraciones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// Connection 
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.educacionit.digitalers.entidades.Usuario;

@Configuration
@ComponentScan(basePackages = { "com.educacionit.digitalers" })
public class WebApp {

	// Spring existen los bean
	// String hola = new WebApp().hola();

	@Bean
	public InternalResourceViewResolver getVistas() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/vistas/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	
	@Bean
	public Usuario usuario1() {
		Usuario usuario = new Usuario();
		usuario.setCorreo("oc@gamcil");
		usuario.setClave("1234");
		return usuario;
	}

}
