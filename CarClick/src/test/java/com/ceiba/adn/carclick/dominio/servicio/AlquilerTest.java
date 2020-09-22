package com.ceiba.adn.carclick.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.ceiba.adn.carclick.dominio.modelo.Reserva;
import com.ceiba.adn.carclick.testdatabuilder.ReservaTestDataBuilder;

public class AlquilerTest {

	@Test
	public void cuandoEntregaMismoDiaEntoncesDeberiaCalcularSinRecargos() {
		//Arrange
		Reserva reservaTestBuilder = new ReservaTestDataBuilder().build();
		LocalDateTime fechaEntrega = LocalDateTime.of(2020, 9, 10, 14, 0);
		
		//Act
		BigDecimal costoReserva = Alquiler.calcularCosto(reservaTestBuilder, fechaEntrega);
		
		//Assert
		assertEquals(costoReserva, new BigDecimal(75000));		
	}
	
	@Test
	public void cuandoEntregaMismoDiaFestivoEntoncesDeberiaCalcularRecargosFinSemana() {
		//Arrange
		LocalDateTime fechaRecogida = LocalDateTime.of(2020, 9, 13, 9, 0);
		Reserva reservaTestBuilder = new ReservaTestDataBuilder().conFechaRecogida(fechaRecogida)
				.build();
		LocalDateTime fechaEntrega = LocalDateTime.of(2020, 9, 13, 14, 0);
		
		//Act
		BigDecimal costoReserva = Alquiler.calcularCosto(reservaTestBuilder, fechaEntrega);

		//Assert
		assertEquals(costoReserva, BigDecimal.valueOf(82500.0));		
	}
	
	@Test
	public void cuandoEntregaSegundoDiaEntoncesDeberiaCalcularConRecargosNocturnos() {
		//Arrange
		Reserva reservaTestBuilder = new ReservaTestDataBuilder().build();
		LocalDateTime fechaEntrega = LocalDateTime.of(2020, 9, 11, 14, 0);
		
		//Act
		BigDecimal costoReserva = Alquiler.calcularCosto(reservaTestBuilder, fechaEntrega);
		
		//Assert
		assertEquals(costoReserva, BigDecimal.valueOf(443250.0));	
	}
	
	@Test
	public void cuandoEntregaSegundoDiaEntoncesDeberiaCalcularConContadorDias() {
		//Arrange
		Reserva reservaTestBuilder = new ReservaTestDataBuilder().conFechaRecogida(LocalDateTime.of(2020, 9, 10, 19, 0)).build();
		LocalDateTime fechaEntrega = LocalDateTime.of(2020, 9, 11, 9, 0);
		
		//Act
		BigDecimal costoReserva = Alquiler.calcularCosto(reservaTestBuilder, fechaEntrega);
		
		//Assert
		assertEquals(costoReserva, BigDecimal.valueOf(218250.0));	
	}
	
	@Test
	public void cuandoEntregaVariosDiasIncluyendoFinSemanaEntoncesDeberiaCalcularConRecargosNocturnosFestivos() {
		//Arrange
		Reserva reservaTestBuilder = new ReservaTestDataBuilder().build();
		LocalDateTime fechaEntrega = LocalDateTime.of(2020, 9, 15, 14, 0);
		
		//Act
		BigDecimal costoReserva = Alquiler.calcularCosto(reservaTestBuilder, fechaEntrega);
		
		//Assert
		assertEquals(costoReserva, BigDecimal.valueOf(1971750.0));	
	}
}
