package com.ceiba.adn.carclick.aplicacion.mapeador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.ceiba.adn.carclick.aplicacion.dto.DetalleReservaDTO;
import com.ceiba.adn.carclick.dominio.modelo.DetalleReserva;
import com.ceiba.adn.carclick.testdatabuilder.DetalleReservaDTOTestDataBuilder;
import com.ceiba.adn.carclick.testdatabuilder.DetalleReservaTestDataBuilder;

public class MapeadorDetalleReservaTest {

	@Test
	public void detalleReservaDTONullRetornaNull() {
		// arrange
		DetalleReservaDTO detalleReservaDTO = null;

		// act
		DetalleReserva detalleReserva = MapeadorDetalleReserva.mapearAModelo(detalleReservaDTO);

		// assert
		assertNull(detalleReserva);
	}

	@Test
	public void detalleReservaDTONoNullRetornaReserva() {
		// arrange
		DetalleReservaDTO detalleReservaDTO = new DetalleReservaDTOTestDataBuilder().build();

		// act
		DetalleReserva detalleReserva = MapeadorDetalleReserva.mapearAModelo(detalleReservaDTO);

		// assert
		assertNotNull(detalleReserva);
		assertEquals(detalleReserva.getId(), detalleReservaDTO.getId());
		assertEquals(detalleReserva.getIdReserva(), detalleReservaDTO.getIdReserva());
		assertEquals(detalleReserva.getFechaEntrega(), detalleReservaDTO.getFechaEntrega());
		assertEquals(detalleReserva.getCosto(), detalleReservaDTO.getCosto());
	}

	@Test
	public void detalleReservaNullRetornaNull() {
		// arrange
		DetalleReserva detalleReserva = null;

		// act
		DetalleReservaDTO detalleReservaDTO = MapeadorDetalleReserva.mapearADTO(detalleReserva);

		// assert
		assertNull(detalleReservaDTO);
	}

	@Test
	public void detalleReservaNoNullRetornaDetalleReservaDTO() {
		// arrange
		DetalleReserva detalleReserva = new DetalleReservaTestDataBuilder().build();

		// act
		DetalleReservaDTO detalleReservaDTO = MapeadorDetalleReserva.mapearADTO(detalleReserva);

		// assert
		assertNotNull(detalleReservaDTO);
		assertEquals(detalleReservaDTO.getId(), detalleReserva.getId());
		assertEquals(detalleReservaDTO.getIdReserva(), detalleReserva.getIdReserva());
		assertEquals(detalleReservaDTO.getFechaEntrega(), detalleReserva.getFechaEntrega());
		assertEquals(detalleReservaDTO.getCosto(), detalleReserva.getCosto());
	}
}
