package com.ceiba.adn.carclick.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionClienteNoRegistrado;
import com.ceiba.adn.carclick.dominio.modelo.Cliente;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCliente;
import com.ceiba.adn.carclick.testdatabuilder.ClienteTestDataBuilder;

public class ServicioListarClienteTest {
	
	private static final String EL_CLIENTE_INGRESADO_NO_SE_ENCUENTRA_REGISTRADO = "El cliente ingresado no se encuentra registrado";
	
	@Test
	public void cuandoClienteExisteListarClienteEntoncesDeberiaDevolverCliente() {
		//Arrange
		Cliente cliente = new ClienteTestDataBuilder().build();
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
		Mockito.when(repositorioCliente.buscarCliente(Mockito.anyLong())).thenReturn(Optional.of(cliente));
		
		//Act
		ServicioListarCliente servicioListarCliente = new ServicioListarCliente(repositorioCliente);
		
		//Assert
		assertEquals(servicioListarCliente.listar(cliente.getIdCliente()), 
				cliente);
	}
	
	@Test
	public void cuandoClienteNoExisteAlListarClienteEntoncesDeberiaLanzarExcepcion() {
		//Arrange
		Cliente cliente = new ClienteTestDataBuilder().build();
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
		Mockito.when(repositorioCliente.buscarCliente(Mockito.anyLong())).thenReturn(Optional.empty());
		
		//Act
		ServicioListarCliente servicioListarCliente = new ServicioListarCliente(repositorioCliente);
		
		//Assert
		assertThrows(ExcepcionClienteNoRegistrado.class, 
				() ->  servicioListarCliente.listar(cliente.getIdCliente()), 
				EL_CLIENTE_INGRESADO_NO_SE_ENCUENTRA_REGISTRADO);
	}
}
