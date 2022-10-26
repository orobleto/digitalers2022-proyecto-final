package com.educacionit.digitalers.configuraciones;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebConfig implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext annotationConfigApplicationContext = new AnnotationConfigWebApplicationContext();
		annotationConfigApplicationContext.setConfigLocation("com.educacionit.digitalers.configuraciones.WebApp");

		ServletRegistration.Dynamic dynamic = servletContext.addServlet("appServlet",
				new DispatcherServlet(annotationConfigApplicationContext));
		dynamic.setLoadOnStartup(1);
		dynamic.addMapping("*.html");
	}

}
