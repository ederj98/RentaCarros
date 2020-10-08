package com.ceiba.adn.carclick.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.adn.carclick.dominio.modelo.Cliente;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCliente;
import com.ceiba.adn.carclick.testdatabuilder.ClienteTestDataBuilder;

public class ServicioCrearClienteTest {
	
	private static final String EL_CLIENTE_YA_SE_ENCUENTRA_REGISTRADO = "El cliente ya se encuentra registrado";

	@Test
	public void cuandoClienteExisteEntoncesDeberiaLanzarExcepcion() {
		//Arrange
		Cliente cliente = new ClienteTestDataBuilder().build();
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
		Mockito.when(repositorioCliente.existe(Mockito.anyLong())).thenReturn(true);
		
		//Act
		ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);
		
		//Assert
		assertThrows(ExcepcionDuplicidad.class, 
				() ->  servicioCrearCliente.ejecutar(cliente), 
				EL_CLIENTE_YA_SE_ENCUENTRA_REGISTRADO);
	}
}
