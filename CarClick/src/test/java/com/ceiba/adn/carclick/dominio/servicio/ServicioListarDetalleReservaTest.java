package com.ceiba.adn.carclick.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionReservaNoRegistrada;
import com.ceiba.adn.carclick.dominio.modelo.DetalleReserva;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioDetalleReserva;
import com.ceiba.adn.carclick.testdatabuilder.DetalleReservaTestDataBuilder;

public class ServicioListarDetalleReservaTest {
	
	private static final String LA_RESERVA_NO_SE_ENCUENTRA_REGISTRADA = "la reserva no se encuentra registrada";
	
	@Test
	public void cuandoDetalleReservaExisteListarDetalleReservaEntoncesDeberiaDevolverDetalleReserva() {
		//Arrange
		DetalleReserva detalleReserva = new DetalleReservaTestDataBuilder().build();
		RepositorioDetalleReserva repositorioDetalleReserva = Mockito.mock(RepositorioDetalleReserva.class);
		Mockito.when(repositorioDetalleReserva.buscarDetalleReserva(Mockito.anyLong())).thenReturn(Optional.of(detalleReserva));
		
		//Act
		ServicioListarDetalleReserva servicioListarDetalleReserva = new ServicioListarDetalleReserva(repositorioDetalleReserva);
		
		//Assert
		assertEquals(servicioListarDetalleReserva.listar(detalleReserva.getIdReserva()), 
				detalleReserva);
	}
	
	@Test
	public void cuandoDetalleReservaNoExisteAlListarDetalleReservaEntoncesDeberiaLanzarExcepcion() {
		//Arrange
		DetalleReserva detalleReserva = new DetalleReservaTestDataBuilder().build();
		RepositorioDetalleReserva repositorioDetalleReserva = Mockito.mock(RepositorioDetalleReserva.class);
		Mockito.when(repositorioDetalleReserva.buscarDetalleReserva(Mockito.anyLong())).thenReturn(Optional.empty());
		
		//Act
		ServicioListarDetalleReserva servicioListarDetalleReserva = new ServicioListarDetalleReserva(repositorioDetalleReserva);
		
		//Assert
		assertThrows(ExcepcionReservaNoRegistrada.class, 
				() ->  servicioListarDetalleReserva.listar(detalleReserva.getIdReserva()), 
				LA_RESERVA_NO_SE_ENCUENTRA_REGISTRADA);
	}
}
