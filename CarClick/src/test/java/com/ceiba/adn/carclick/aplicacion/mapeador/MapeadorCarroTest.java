package com.ceiba.adn.carclick.aplicacion.mapeador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import com.ceiba.adn.carclick.aplicacion.dto.CarroDTO;
import com.ceiba.adn.carclick.dominio.modelo.Carro;
import com.ceiba.adn.carclick.testdatabuilder.CarroDTOTestDataBuilder;
import com.ceiba.adn.carclick.testdatabuilder.CarroTestDataBuilder;

public class MapeadorCarroTest {

	@Test
	public void cuandoCarroDTONullEntoncesDeberiaRetornarNull() {
		// arrange
		CarroDTO carroDTO = null;

		// act
		Carro carro = MapeadorCarro.mapearAModelo(carroDTO);

		// assert
		assertNull(carro);
	}

	@Test
	public void cuandoCarroDTONoNullEntoncesDeberiaRetornarCarro() {
		// arrange
		CarroDTO carroDTO = new CarroDTOTestDataBuilder().build();

		// act
		Carro carro = MapeadorCarro.mapearAModelo(carroDTO);

		// assert
		assertNotNull(carro);
		assertEquals(carro.getId(), carroDTO.getId());
		assertEquals(carro.getModelo(), carroDTO.getModelo());
		assertEquals(carro.getNumPasajeros(), carroDTO.getNumPasajeros());
		assertEquals(carro.getNumPuertas(), carroDTO.getNumPuertas());
		assertEquals(carro.getTipoCambios(), carroDTO.getTipoCambios());
		assertEquals(carro.getTipoCombustible(), carroDTO.getTipoCombustible());
	}

	@Test
	public void cuandoCarroNullEntoncesDeberiaRetornarNull() {
		// arrange
		Carro carro = null;

		// act
		CarroDTO carroDTO = MapeadorCarro.mapearADTO(carro);

		// assert
		assertNull(carroDTO);
	}

	@Test
	public void cuandoCarroNoNullEntoncesDeberiaRetornarCarroDTO() {
		// arrange
		Carro carro = new CarroTestDataBuilder().build();

		// act
		CarroDTO carroDTO = MapeadorCarro.mapearADTO(carro);

		// assert
		assertNotNull(carroDTO);
		assertEquals(carroDTO.getId(), carro.getId());
		assertEquals(carroDTO.getModelo(), carro.getModelo());
		assertEquals(carroDTO.getNumPasajeros(), carro.getNumPasajeros());
		assertEquals(carroDTO.getNumPuertas(), carro.getNumPuertas());
		assertEquals(carroDTO.getTipoCambios(), carro.getTipoCambios());
		assertEquals(carroDTO.getTipoCombustible(), carro.getTipoCombustible());
	}
}
