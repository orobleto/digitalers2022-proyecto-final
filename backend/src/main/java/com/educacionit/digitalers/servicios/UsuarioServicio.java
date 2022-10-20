package com.educacionit.digitalers.servicios;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.educacionit.digitalers.entidades.Usuario;
import com.educacionit.digitalers.interfaces.ServicioGenerico;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(value = "/usuarios")
//	@Produces(value = MediaType.APPLICATION_JSON)
public class UsuarioServicio implements ServicioGenerico<Usuario, Integer> {
	private static Logger logger = LogManager.getLogger();

	@GET
	@Path("/buscarPorID/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	// PathParam = buscarPorID/8 ,
	// @QueryParam = buscarPorID?id=8
	public Response buscarPorID(@PathParam(value = "id") Integer id) {
		Usuario usuario = Usuario.builder().id(id).correo(id + "@gmail").clave("1234").activo(true).build();
		logger.debug(usuario);
		return Response.ok(usuario).build();
	}

	@POST
	@Path(value = "/insertar")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response insertar(Usuario usuario) {

		logger.debug(usuario);
		return Response.accepted(usuario).build();
	}

	@POST
	@Path(value = "/insertarForm")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Usuario insertarForm(@HeaderParam(value = "USER-ID") String user_id, @FormParam(value = "id") Integer id,
			@FormParam(value = "correo") String correo) {
		Usuario usuario = Usuario.builder().id(id).correo(correo).build();
		logger.debug(usuario);
		logger.debug(user_id);
		return usuario;
	}

	@PUT
	@Path(value = "/modificar")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response modificar(Usuario usuario) {

		logger.debug(usuario);
		return Response.accepted(usuario).build();
	}

	@DELETE
	@Path(value = "/eliminar")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response eliminar(Usuario usuario) {
		logger.debug(usuario);
		return Response.accepted(usuario).build();
	}

	@GET
	@Path(value = "/listar")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response listar() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario(1, "user1@gmail.com", "1234", true, LocalDateTime.now()));
		usuarios.add(new Usuario(2, "user2@gmail.com", "1234", true, LocalDateTime.now()));
		usuarios.add(new Usuario(3, "user3@gmail.com", "1234", true, LocalDateTime.now()));
		usuarios.add(new Usuario(4, "user4@gmail.com", "1234", true, LocalDateTime.now()));

		logger.debug(usuarios);
		return Response.status(200).entity(usuarios).build();
	}

}
