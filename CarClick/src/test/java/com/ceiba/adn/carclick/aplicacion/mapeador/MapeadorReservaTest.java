package com.ceiba.adn.carclick.aplicacion.mapeador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.ceiba.adn.carclick.aplicacion.dto.ReservaDTO;
import com.ceiba.adn.carclick.dominio.modelo.Reserva;
import com.ceiba.adn.carclick.testdatabuilder.ReservaDTOTestDataBuilder;
import com.ceiba.adn.carclick.testdatabuilder.ReservaTestDataBuilder;

public class MapeadorReservaTest {

	@Test
	public void cuandoReservaDTONullEntoncesDeberiaRetornarNull() {
		// arrange
		ReservaDTO reservaDTO = null;

		// act
		Reserva reserva = MapeadorReserva.mapearAModelo(reservaDTO);

		// assert
		assertNull(reserva);
	}

	@Test
	public void cuandoReservaDTONoNullEntoncesDeberiaRetornarReserva() {
		// arrange
		ReservaDTO reservaDTO = new ReservaDTOTestDataBuilder().build();

		// act
		Reserva reserva = MapeadorReserva.mapearAModelo(reservaDTO);

		// assert
		assertNotNull(reserva);
		assertEquals(reserva.getId(), reservaDTO.getId());
		assertEquals(reserva.getIdCliente(), reservaDTO.getIdCliente());
		assertEquals(reserva.getIdCarro(), reservaDTO.getIdCarro());
		assertEquals(reserva.getFechaRecogida(), reservaDTO.getFechaRecogida());
	}

	@Test
	public void cuandoReservaNullEntoncesDeberiaRetornarNull() {
		// arrange
		Reserva reserva = null;

		// act
		ReservaDTO reservaDTO = MapeadorReserva.mapearADTO(reserva);

		// assert
		assertNull(reservaDTO);
	}

	@Test
	public void cuandoReservaNoNullEntoncesDeberiaRetornarReservaDTO() {
		// arrange
		Reserva reserva = new ReservaTestDataBuilder().build();

		// act
		ReservaDTO reservaDTO = MapeadorReserva.mapearADTO(reserva);

		// assert
		assertNotNull(reservaDTO);
		assertEquals(reservaDTO.getId(), reserva.getId());
		assertEquals(reservaDTO.getIdCliente(), reserva.getIdCliente());
		assertEquals(reservaDTO.getIdCarro(), reserva.getIdCarro());
		assertEquals(reservaDTO.getFechaRecogida(), reserva.getFechaRecogida());
	}
}
