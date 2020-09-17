package com.ceiba.adn.carclick.infraestructura.mapeador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.ceiba.adn.carclick.dominio.modelo.Reserva;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.ReservaEntidad;
import com.ceiba.adn.carclick.testdatabuilder.ReservaEntidadTestDataBuilder;
import com.ceiba.adn.carclick.testdatabuilder.ReservaTestDataBuilder;

public class MapeadorReservaEntidadTest {

	@Test
	public void reservaEntidadNullRetornaNull() {
		// arrange
		ReservaEntidad reservaEntidad = null;

		// act
		Reserva reserva = MapeadorReservaEntidad.mapearAModelo(reservaEntidad);

		// assert
		assertNull(reserva);
	}

	@Test
	public void reservaEntidadNoNullRetornaReserva() {
		// arrange
		ReservaEntidad reservaEntidad = new ReservaEntidadTestDataBuilder().build();

		// act
		Reserva reserva = MapeadorReservaEntidad.mapearAModelo(reservaEntidad);

		// assert
		assertNotNull(reserva);
		assertEquals(reserva.getId(), reservaEntidad.getId());
		assertEquals(reserva.getIdCliente(), reservaEntidad.getIdCliente().getIdCliente());
		assertEquals(reserva.getIdCarro(), reservaEntidad.getIdCarro().getId());
		assertEquals(reserva.getFechaRecogida(), reservaEntidad.getFechaRecogida());
	}

	@Test
	public void reservaNullRetornaNull() {
		// arrange
		Reserva reserva = null;

		// act
		ReservaEntidad reservaEntidad = MapeadorReservaEntidad.mapearAEntidad(reserva);

		// assert
		assertNull(reservaEntidad);
	}

	@Test
	public void reservaNoNullRetornaReservaEntidad() {
		// arrange
		Reserva reserva = new ReservaTestDataBuilder().build();

		// act
		ReservaEntidad reservaEntidad = MapeadorReservaEntidad.mapearAEntidad(reserva);

		// assert
		assertNotNull(reservaEntidad);
		assertEquals(reservaEntidad.getId(), reserva.getId());
		assertEquals(reservaEntidad.getIdCliente().getIdCliente(), reserva.getIdCliente());
		assertEquals(reservaEntidad.getIdCarro().getId(), reserva.getIdCarro());
		assertEquals(reservaEntidad.getFechaRecogida(), reserva.getFechaRecogida());
	}
}
