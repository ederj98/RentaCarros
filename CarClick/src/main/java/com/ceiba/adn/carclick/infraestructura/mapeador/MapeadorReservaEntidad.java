package com.ceiba.adn.carclick.infraestructura.mapeador;

import java.util.Objects;

import com.ceiba.adn.carclick.dominio.modelo.Reserva;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.ReservaEntidad;

public class MapeadorReservaEntidad {
	
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
		return new Reserva(reservaEntidad.getId(), reservaEntidad.getIdCliente(), 
				reservaEntidad.getIdCarro(), reservaEntidad.getFechaRecogida());
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
		return new ReservaEntidad(reserva.getId(), reserva.getIdCliente(), 
				reserva.getIdCarro(), reserva.getFechaRecogida());
	}
}
