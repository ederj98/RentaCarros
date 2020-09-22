package com.ceiba.adn.carclick.infraestructura.mapeador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.ceiba.adn.carclick.dominio.modelo.Carro;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.CarroEntidad;
import com.ceiba.adn.carclick.testdatabuilder.CarroEntidadTestDataBuilder;
import com.ceiba.adn.carclick.testdatabuilder.CarroTestDataBuilder;

public class MapeadorCarroEntidadTest {

	@Test
	public void cuandoCarroEntidadNullEntoncesDeberiaRetornarNull() {
		// arrange
		CarroEntidad carroEntidad = null;

		// act
		Carro carro = MapeadorCarroEntidad.mapearAModelo(carroEntidad);

		// assert
		assertNull(carro);
	}

	@Test
	public void cuandoCarroEntidadNoNullEntoncesDeberiaRetornarCarro() {
		// arrange
		CarroEntidad carroEntidad = new CarroEntidadTestDataBuilder().build();

		// act
		Carro carro = MapeadorCarroEntidad.mapearAModelo(carroEntidad);

		// assert
		assertNotNull(carro);
		assertEquals(carro.getId(), carroEntidad.getId());
		assertEquals(carro.getModelo(), carroEntidad.getModelo());
		assertEquals(carro.getNumPasajeros(), carroEntidad.getNumPasajeros());
		assertEquals(carro.getNumPuertas(), carroEntidad.getNumPuertas());
		assertEquals(carro.getTipoCambios(), carroEntidad.getTipoCambios());
		assertEquals(carro.getTipoCombustible(), carroEntidad.getTipoCombustible());
	}

	@Test
	public void cuandoCarroNullEntoncesDeberiaRetornarNull() {
		// arrange
		Carro carro = null;

		// act
		CarroEntidad carroEntidad = MapeadorCarroEntidad.mapearAEntidad(carro);

		// assert
		assertNull(carroEntidad);
	}

	@Test
	public void cuandoCarroNoNullEntoncesDeberiaRetornarCarroEntidad() {
		// arrange
		Carro carro = new CarroTestDataBuilder().build();

		// act
		CarroEntidad carroEntidad = MapeadorCarroEntidad.mapearAEntidad(carro);

		// assert
		assertNotNull(carroEntidad);
		assertEquals(carroEntidad.getId(), carro.getId());
		assertEquals(carroEntidad.getModelo(), carro.getModelo());
		assertEquals(carroEntidad.getNumPasajeros(), carro.getNumPasajeros());
		assertEquals(carroEntidad.getNumPuertas(), carro.getNumPuertas());
		assertEquals(carroEntidad.getTipoCambios(), carro.getTipoCambios());
		assertEquals(carroEntidad.getTipoCombustible(), carro.getTipoCombustible());
	}
}
