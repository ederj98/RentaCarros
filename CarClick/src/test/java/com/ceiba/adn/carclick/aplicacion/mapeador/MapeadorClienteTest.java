package com.ceiba.adn.carclick.aplicacion.mapeador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.ceiba.adn.carclick.aplicacion.dto.ClienteDTO;
import com.ceiba.adn.carclick.dominio.modelo.Cliente;
import com.ceiba.adn.carclick.testdatabuilder.ClienteDTOTestDataBuilder;
import com.ceiba.adn.carclick.testdatabuilder.ClienteTestDataBuilder;

public class MapeadorClienteTest {

	@Test
	public void clienteDTONullRetornaNull() {
		// arrange
		ClienteDTO clienteDTO = null;

		// act
		Cliente cliente = MapeadorCliente.mapearAModelo(clienteDTO);

		// assert
		assertNull(cliente);
	}

	@Test
	public void clienteDTONoNullRetornaCliente() {
		// arrange
		ClienteDTO clienteDTO = new ClienteDTOTestDataBuilder().build();

		// act
		Cliente cliente = MapeadorCliente.mapearAModelo(clienteDTO);

		// assert
		assertNotNull(cliente);
		assertEquals(cliente.getIdCliente(), clienteDTO.getIdCliente());
		assertEquals(cliente.getNombreCompleto(), clienteDTO.getNombreCompleto());
		assertEquals(cliente.getDireccion(), clienteDTO.getDireccion());
		assertEquals(cliente.getTelefono(), clienteDTO.getTelefono());
		assertEquals(cliente.getEmail(), clienteDTO.getEmail());
	}

	@Test
	public void clienteNullRetornaNull() {
		// arrange
		Cliente cliente = null;

		// act
		ClienteDTO clienteDTO = MapeadorCliente.mapearADTO(cliente);

		// assert
		assertNull(clienteDTO);
	}

	@Test
	public void clienteNoNullRetornaClienteDTO() {
		// arrange
		Cliente cliente = new ClienteTestDataBuilder().build();

		// act
		ClienteDTO clienteDTO = MapeadorCliente.mapearADTO(cliente);

		// assert
		assertNotNull(clienteDTO);
		assertEquals(clienteDTO.getIdCliente(), cliente.getIdCliente());
		assertEquals(clienteDTO.getNombreCompleto(), cliente.getNombreCompleto());
		assertEquals(clienteDTO.getDireccion(), cliente.getDireccion());
		assertEquals(clienteDTO.getTelefono(), cliente.getTelefono());
		assertEquals(clienteDTO.getEmail(), cliente.getEmail());
	}
}
