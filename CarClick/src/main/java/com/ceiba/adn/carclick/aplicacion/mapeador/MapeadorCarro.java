package com.ceiba.adn.carclick.aplicacion.mapeador;

import java.util.Objects;

import com.ceiba.adn.carclick.aplicacion.dto.CarroDTO;
import com.ceiba.adn.carclick.dominio.modelo.Carro;

public final class MapeadorCarro {

	private MapeadorCarro() {}
	
	/**
	 * Metodo encargado de convertir un Carro en un CarroDTO
	 * @param carro
	 * @return CarroDTO
	 */
	public static CarroDTO mapearADTO(Carro carro) {
		if (Objects.isNull(carro)) {
			return null;
		}
		return new CarroDTO(carro.getId(), carro.getModelo(), carro.getTipoCambios(), carro.getNumPasajeros(), 
				carro.getNumPuertas(), carro.getTipoCombustible());
	}
	
	/**
	 * Metodo encargado de convertir un CarroDTO en un Carro
	 * @param carroDTO
	 * @return Carro
	 */
	public static Carro mapearAModelo(CarroDTO carroDTO) {
		if (Objects.isNull(carroDTO)) {
			return null;
		}
		return new Carro(carroDTO.getId(), carroDTO.getModelo(), carroDTO.getTipoCambios(), carroDTO.getNumPasajeros(), 
				carroDTO.getNumPuertas(), carroDTO.getTipoCombustible());
	}
}
