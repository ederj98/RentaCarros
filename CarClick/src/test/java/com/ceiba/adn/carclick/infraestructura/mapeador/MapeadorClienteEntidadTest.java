package com.ceiba.adn.carclick.infraestructura.mapeador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.ceiba.adn.carclick.dominio.modelo.Cliente;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.ClienteEntidad;
import com.ceiba.adn.carclick.testdatabuilder.ClienteEntidadTestDataBuilder;
import com.ceiba.adn.carclick.testdatabuilder.ClienteTestDataBuilder;

public class MapeadorClienteEntidadTest {

	@Test
	public void clienteEntidadNullRetornaNull() {
		// arrange
		ClienteEntidad clienteEntidad = null;

		// act
		Cliente cliente = MapeadorClienteEntidad.mapearAModelo(clienteEntidad);

		// assert
		assertNull(cliente);
	}

	@Test
	public void clienteEntidadNoNullRetornaCliente() {
		// arrange
		ClienteEntidad clienteEntidad = new ClienteEntidadTestDataBuilder().build();

		// act
		Cliente cliente = MapeadorClienteEntidad.mapearAModelo(clienteEntidad);

		// assert
		assertNotNull(cliente);
		assertEquals(cliente.getIdCliente(), clienteEntidad.getIdCliente());
		assertEquals(cliente.getNombreCompleto(), clienteEntidad.getNombreCompleto());
		assertEquals(cliente.getDireccion(), clienteEntidad.getDireccion());
		assertEquals(cliente.getTelefono(), clienteEntidad.getTelefono());
		assertEquals(cliente.getEmail(), clienteEntidad.getEmail());
	}

	@Test
	public void clienteNullRetornaNull() {
		// arrange
		Cliente cliente = null;

		// act
		ClienteEntidad clienteEntidad = MapeadorClienteEntidad.mapearAEntidad(cliente);

		// assert
		assertNull(clienteEntidad);
	}

	@Test
	public void clienteNoNullRetornaClienteEntidad() {
		// arrange
		Cliente cliente = new ClienteTestDataBuilder().build();

		// act
		ClienteEntidad clienteEntidad = MapeadorClienteEntidad.mapearAEntidad(cliente);

		// assert
		assertNotNull(clienteEntidad);
		assertEquals(clienteEntidad.getIdCliente(), cliente.getIdCliente());
		assertEquals(clienteEntidad.getNombreCompleto(), cliente.getNombreCompleto());
		assertEquals(clienteEntidad.getDireccion(), cliente.getDireccion());
		assertEquals(clienteEntidad.getTelefono(), cliente.getTelefono());
		assertEquals(clienteEntidad.getEmail(), cliente.getEmail());
	}
}
