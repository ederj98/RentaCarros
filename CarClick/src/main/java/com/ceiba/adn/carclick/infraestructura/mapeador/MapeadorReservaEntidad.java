package com.ceiba.adn.carclick.infraestructura.mapeador;

import java.util.Objects;

import com.ceiba.adn.carclick.dominio.modelo.Reserva;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.CarroEntidad;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.ClienteEntidad;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.ReservaEntidad;

public final class MapeadorReservaEntidad {
	
	private MapeadorReservaEntidad() {}
	
	/**
	 * Metodo encargado de convertir un Reserva en un ReservaEntidad
	 * @param reservaEntidad
	 * @return
	 */
	public static Reserva mapearAModelo(ReservaEntidad reservaEntidad) {
		if (Objects.isNull(reservaEntidad)) {
			return null;
		}
		return new Reserva(reservaEntidad.getId(), reservaEntidad.getIdCliente().getIdCliente(), 
				reservaEntidad.getIdCarro().getId(), reservaEntidad.getFechaRecogida());
	}

	/**
	 * Metodo encargado de convertir un ReservaEntidad en un Reserva
	 * @param reserva
	 * @return
	 */
	public static ReservaEntidad mapearAEntidad(Reserva reserva) {
		if (Objects.isNull(reserva)) {
			return null;
		}
		ClienteEntidad clienteEntidad = new ClienteEntidad();
		clienteEntidad.setIdCliente(reserva.getIdCliente());
		CarroEntidad carroEntidad = new CarroEntidad();
		carroEntidad.setId(reserva.getIdCarro());
		
		return new ReservaEntidad(reserva.getId(), clienteEntidad, 
				carroEntidad, reserva.getFechaRecogida());
	}
}
