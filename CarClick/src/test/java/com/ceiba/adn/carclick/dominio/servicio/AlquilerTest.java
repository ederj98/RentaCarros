package com.ceiba.adn.carclick.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.ceiba.adn.carclick.dominio.modelo.Reserva;
import com.ceiba.adn.carclick.testdatabuilder.ReservaTestDataBuilder;

public class AlquilerTest {

	@Test
	public void calcularCostoEntregaMismoDiaSinRecargo() {
		//Arrange
		Reserva reservaTestBuilder = new ReservaTestDataBuilder().build();
		LocalDateTime fechaEntrega = LocalDateTime.of(2020, 9, 10, 14, 0);
		
		//Act
		BigDecimal costoReserva = Alquiler.calcularCosto(reservaTestBuilder, fechaEntrega);
		
		//Assert
		assertEquals(costoReserva, new BigDecimal(75000));		
	}
	
	@Test
	public void calcularCostoEntregaMismoDiaConRecargoNocturno() {
		//Arrange
		LocalDateTime fechaRecogida = LocalDateTime.of(2020, 9, 10, 14, 0);
		Reserva reservaTestBuilder = new ReservaTestDataBuilder().conFechaRecogida(fechaRecogida)
				.build();
		LocalDateTime fechaEntrega = LocalDateTime.of(2020, 9, 10, 22, 0);
		
		//Act
		BigDecimal costoReserva = Alquiler.calcularCosto(reservaTestBuilder, fechaEntrega);
		
		//Assert
		assertEquals(costoReserva, new BigDecimal(121500));		
	}
	
	@Test
	public void calcularCostoEntregaMismoDiaFestivo() {
		//Arrange
		LocalDateTime fechaRecogida = LocalDateTime.of(2020, 9, 13, 9, 0);
		Reserva reservaTestBuilder = new ReservaTestDataBuilder().conFechaRecogida(fechaRecogida)
				.build();
		LocalDateTime fechaEntrega = LocalDateTime.of(2020, 9, 13, 14, 0);
		
		//Act
		BigDecimal costoReserva = Alquiler.calcularCosto(reservaTestBuilder, fechaEntrega);
		
		//Assert
		assertEquals(costoReserva, new BigDecimal(82500));		
	}
	
	@Test
	public void calcularCostoVariosDias() {
		//Arrange
		Reserva reservaTestBuilder = new ReservaTestDataBuilder().build();
		LocalDateTime fechaEntrega = LocalDateTime.of(2020, 9, 15, 14, 0);
		
		//Act
		BigDecimal costoReserva = Alquiler.calcularCosto(reservaTestBuilder, fechaEntrega);
		
		//Assert
		assertEquals(costoReserva, new BigDecimal(75000));		
	}
}
