package com.educacionit.digitalers.interfaces;

import jakarta.ws.rs.core.Response;

public interface ServicioGenerico<V, K> {
	Response buscarPorID(K k);

	Response insertar(V v);

	Response modificar(V v);

	Response eliminar(V v);

	Response listar();
}
