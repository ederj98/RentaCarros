package com.ceiba.adn.carclick.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionClienteNoRegistrado;
import com.ceiba.adn.carclick.dominio.modelo.Cliente;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCliente;
import com.ceiba.adn.carclick.testdatabuilder.ClienteTestDataBuilder;

public class ServicioActualizarClienteTest {
	
	private static final String EL_CLIENTE_INGRESADO_NO_SE_ENCUENTRA_REGISTRADO = "El cliente ingresado no se encuentra registrado";
	
	@Test
	public void cuandoClienteNoExisteAlActualizarEntoncesDeberiaLanzarExcepcion() {
		//Arrange
		Cliente cliente = new ClienteTestDataBuilder().build();
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
		Mockito.when(repositorioCliente.existe(Mockito.anyLong())).thenReturn(false);
		
		//Act
		ServicioActualizarCliente servicioActualizarCliente = new ServicioActualizarCliente(repositorioCliente);
		
		//Assert
		assertThrows(ExcepcionClienteNoRegistrado.class, 
				() ->  servicioActualizarCliente.actualizarCliente(cliente), 
				EL_CLIENTE_INGRESADO_NO_SE_ENCUENTRA_REGISTRADO);
	}
}
