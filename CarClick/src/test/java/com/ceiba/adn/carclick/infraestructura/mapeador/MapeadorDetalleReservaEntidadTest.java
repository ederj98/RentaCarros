package com.ceiba.adn.carclick.infraestructura.mapeador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.ceiba.adn.carclick.dominio.modelo.DetalleReserva;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.DetalleReservaEntidad;
import com.ceiba.adn.carclick.testdatabuilder.DetalleReservaEntidadTestDataBuilder;
import com.ceiba.adn.carclick.testdatabuilder.DetalleReservaTestDataBuilder;

public class MapeadorDetalleReservaEntidadTest {

	@Test
	public void detalleReservaEntidadNullRetornaNull() {
		// arrange
		DetalleReservaEntidad detalleReservaEntidad = null;

		// act
		DetalleReserva detalleReserva = MapeadorDetalleReservaEntidad.mapearAModelo(detalleReservaEntidad);

		// assert
		assertNull(detalleReserva);
	}

	@Test
	public void detalleReservaEntidadNoNullRetornaReserva() {
		// arrange
		DetalleReservaEntidad detalleReservaEntidad = new DetalleReservaEntidadTestDataBuilder().build();

		// act
		DetalleReserva detalleReserva = MapeadorDetalleReservaEntidad.mapearAModelo(detalleReservaEntidad);

		// assert
		assertNotNull(detalleReserva);
		assertEquals(detalleReserva.getId(), detalleReservaEntidad.getId());
		assertEquals(detalleReserva.getIdReserva(), detalleReservaEntidad.getReserva().getId());
		assertEquals(detalleReserva.getFechaEntrega(), detalleReservaEntidad.getFechaEntrega());
		assertEquals(detalleReserva.getCosto(), detalleReservaEntidad.getCosto());
	}

	@Test
	public void detalleReservaNullRetornaNull() {
		// arrange
		DetalleReserva detalleReserva = null;

		// act
		DetalleReservaEntidad detalleReservaEntidad = MapeadorDetalleReservaEntidad.mapearAEntidad(detalleReserva);

		// assert
		assertNull(detalleReservaEntidad);
	}

	@Test
	public void detalleReservaNoNullRetornaDetalleReservaDTO() {
		// arrange
		DetalleReserva detalleReserva = new DetalleReservaTestDataBuilder().build();

		// act
		DetalleReservaEntidad detalleReservaEntidad = MapeadorDetalleReservaEntidad.mapearAEntidad(detalleReserva);

		// assert
		assertNotNull(detalleReservaEntidad);
		assertEquals(detalleReservaEntidad.getId(), detalleReserva.getId());
		assertEquals(detalleReservaEntidad.getReserva().getId(), detalleReserva.getIdReserva());
		assertEquals(detalleReservaEntidad.getFechaEntrega(), detalleReserva.getFechaEntrega());
		assertEquals(detalleReservaEntidad.getCosto(), detalleReserva.getCosto());
	}
}
