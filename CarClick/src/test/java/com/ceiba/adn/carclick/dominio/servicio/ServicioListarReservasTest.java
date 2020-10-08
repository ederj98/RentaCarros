package com.ceiba.adn.carclick.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionReservaNoRegistrada;
import com.ceiba.adn.carclick.dominio.modelo.Reserva;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioReserva;
import com.ceiba.adn.carclick.testdatabuilder.ReservaTestDataBuilder;

public class ServicioListarReservasTest {
	
	private static final String LA_RESERVA_NO_SE_ENCUENTRA_REGISTRADA = "la reserva no se encuentra registrada";
	
	@Test
	public void cuandoReservaExisteListarPorIdReservaEntoncesDeberiaDevolverReserva() {
		//Arrange
		Reserva reserva = new ReservaTestDataBuilder().build();
		RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
		Mockito.when(repositorioReserva.buscarReserva(Mockito.anyLong())).thenReturn(Optional.of(reserva));
		
		//Act
		ServicioListarReservas servicioListarReservas = new ServicioListarReservas(repositorioReserva);
		
		//Assert
		assertEquals(servicioListarReservas.listar(reserva.getId()), 
				reserva);
	}
	
	@Test
	public void cuandoReservaNoExisteAlListarPorIdReservaEntoncesDeberiaLanzarExcepcion() {
		//Arrange
		Reserva reserva = new ReservaTestDataBuilder().build();
		RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
		Mockito.when(repositorioReserva.buscarReserva(Mockito.anyLong())).thenReturn(Optional.empty());
		
		//Act
		ServicioListarReservas servicioListarReservas = new ServicioListarReservas(repositorioReserva);
				
		//Assert
		assertThrows(ExcepcionReservaNoRegistrada.class, 
				() ->  servicioListarReservas.listar(reserva.getIdCliente()), 
				LA_RESERVA_NO_SE_ENCUENTRA_REGISTRADA);
	}
	
	@Test
	public void cuandoReservaExisteListarReservaEntoncesDeberiaDevolverReserva() {
		//Arrange
		List<Reserva> reservas = new ArrayList<>();
		Reserva reserva = new ReservaTestDataBuilder().build();
		reservas.add(reserva);
		RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
		Mockito.when(repositorioReserva.listar()).thenReturn(reservas);
		
		//Act
		ServicioListarReservas servicioListarReservas = new ServicioListarReservas(repositorioReserva);
		
		//Assert
		assertEquals(servicioListarReservas.listar(), 
				reservas);
	}
}
