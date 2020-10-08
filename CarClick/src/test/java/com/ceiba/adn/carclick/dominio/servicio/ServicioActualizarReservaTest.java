package com.ceiba.adn.carclick.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionCarroNoRegistrado;
import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionClienteNoRegistrado;
import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionFechaRecogidaAnteriorAFechaActual;
import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionReservaNoRegistrada;
import com.ceiba.adn.carclick.dominio.modelo.Reserva;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCarro;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCliente;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioReserva;
import com.ceiba.adn.carclick.testdatabuilder.ReservaTestDataBuilder;

public class ServicioActualizarReservaTest {
	
	private static final String LA_FECHA_DE_RECOGIDA_DEL_VEHICULO_NO_PUEDE_SER_MENOR_A_LA_FECHA_ACTUAL = "La fecha de recogida del vehiculo no puede ser menor a la fecha actual";
	private static final String LA_RESERVA_INGRESADA_NO_SE_ENCUENTRA_REGISTRADA = "La reserva ingresada no se encuentra registrada";
	private static final String EL_CLIENTE_INGRESADO_NO_SE_ENCUENTRA_REGISTRADO = "El cliente ingresado no se encuentra registrado";
	private static final String EL_CARRO_INGRESADO_NO_SE_ENCUENTRA_REGISTRADO = "El carro ingresado no se encuentra registrado";
	
	@Test
	public void cuandoFechaRecogidaPosteriorAFechaActualAlActualizarEntoncesDeberiaLanzarExcepcion() {
		//Arrange
		Reserva reserva = new ReservaTestDataBuilder().build();
		RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
		RepositorioCarro repositorioCarro = Mockito.mock(RepositorioCarro.class);
		
		//Act
		ServicioActualizarReserva servicioActualizarReserva = new ServicioActualizarReserva(repositorioReserva, repositorioCarro, repositorioCliente);
		
		//Assert
		assertThrows(ExcepcionFechaRecogidaAnteriorAFechaActual.class, 
				() ->  servicioActualizarReserva.actualizarReserva(reserva), 
				LA_FECHA_DE_RECOGIDA_DEL_VEHICULO_NO_PUEDE_SER_MENOR_A_LA_FECHA_ACTUAL);
	}
	
	@Test
	public void cuandoReservaNoExisteAlActualizarReservaEntoncesDeberiaLanzarExcepcion() {
		//Arrange
		Reserva reserva = new ReservaTestDataBuilder().conFechaRecogida(LocalDate.now().plusDays(1).atTime(9, 0)).build();
		RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
		RepositorioCarro repositorioCarro = Mockito.mock(RepositorioCarro.class);
		Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(false);
		
		//Act
		ServicioActualizarReserva servicioActualizarReserva = new ServicioActualizarReserva(repositorioReserva, repositorioCarro, repositorioCliente);
		
		//Assert
		assertThrows(ExcepcionReservaNoRegistrada.class, 
				() ->  servicioActualizarReserva.actualizarReserva(reserva), 
				LA_RESERVA_INGRESADA_NO_SE_ENCUENTRA_REGISTRADA);
	}
	
	@Test
	public void cuandoClienteNoExisteAlActualizarReservaEntoncesDeberiaLanzarExcepcion() {
		//Arrange
		Reserva reserva = new ReservaTestDataBuilder().conFechaRecogida(LocalDate.now().plusDays(1).atTime(9, 0)).build();
		RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
		RepositorioCarro repositorioCarro = Mockito.mock(RepositorioCarro.class);
		Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(true);
		Mockito.when(repositorioCarro.existe(Mockito.anyLong())).thenReturn(true);
		Mockito.when(repositorioCliente.existe(Mockito.anyLong())).thenReturn(false);
		
		//Act
		ServicioActualizarReserva servicioActualizarReserva = new ServicioActualizarReserva(repositorioReserva, repositorioCarro, repositorioCliente);
		
		//Assert
		assertThrows(ExcepcionClienteNoRegistrado.class, 
				() ->  servicioActualizarReserva.actualizarReserva(reserva), 
				EL_CLIENTE_INGRESADO_NO_SE_ENCUENTRA_REGISTRADO);
	}
	
	@Test
	public void cuandoCarroNoExisteAlCrearReservaEntoncesDeberiaLanzarExcepcion() {
		//Arrange
		Reserva reserva = new ReservaTestDataBuilder().conFechaRecogida(LocalDate.now().plusDays(1).atTime(9, 0)).build();
		RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
		RepositorioCarro repositorioCarro = Mockito.mock(RepositorioCarro.class);
		Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(true);
		Mockito.when(repositorioCarro.existe(Mockito.anyLong())).thenReturn(false);
		
		//Act
		ServicioActualizarReserva servicioActualizarReserva = new ServicioActualizarReserva(repositorioReserva, repositorioCarro, repositorioCliente);
		
		//Assert
		assertThrows(ExcepcionCarroNoRegistrado.class, 
				() ->  servicioActualizarReserva.actualizarReserva(reserva), 
				EL_CARRO_INGRESADO_NO_SE_ENCUENTRA_REGISTRADO);
	}
}
