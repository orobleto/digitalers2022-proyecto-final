package com.educacionit.digitalers.configuraciones;

import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath(value = "/blog")
public class ConfiguracionRest extends ResourceConfig{
	public ConfiguracionRest() {
		packages("com.educacionit.digitalers");
	}
}
