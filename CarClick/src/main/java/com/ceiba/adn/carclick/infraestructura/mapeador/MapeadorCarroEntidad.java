package com.ceiba.adn.carclick.infraestructura.mapeador;

import java.util.Objects;

import com.ceiba.adn.carclick.dominio.modelo.Carro;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.CarroEntidad;

public final class MapeadorCarroEntidad {

	private MapeadorCarroEntidad() {}
	
	/**
	 * Metodo encargado de convertir un Carro en un CarroEntidad
	 * @param carroEntidad
	 * @return
	 */
	public static Carro mapearAModelo(CarroEntidad carroEntidad) {
		if (Objects.isNull(carroEntidad)) {
			return null;
		}
		return new Carro(carroEntidad.getId(), carroEntidad.getModelo(), carroEntidad.getTipoCambios(), 
				carroEntidad.getNumPasajeros(), carroEntidad.getNumPuertas(), carroEntidad.getTipoCombustible());
	}
	
	/**
	 * Metodo encargado de convertir un CarrroEntidad en un Carro
	 * @param carro
	 * @return
	 */
	public static CarroEntidad mapearAEntidad(Carro carro) {
		if (Objects.isNull(carro)) {
			return null;
		}
		return new CarroEntidad(carro.getId(), carro.getModelo(), carro.getTipoCambios(), carro.getNumPasajeros(), 
				carro.getNumPuertas(), carro.getTipoCombustible());
	}
}
