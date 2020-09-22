package com.ceiba.adn.carclick.infraestructura.mapeador;

import java.util.Objects;

import com.ceiba.adn.carclick.dominio.modelo.DetalleReserva;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.DetalleReservaEntidad;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.ReservaEntidad;

public final class MapeadorDetalleReservaEntidad {

	private MapeadorDetalleReservaEntidad() {}
	
	/**
	 * Metodo encargado de convertir un DetalleReserva en un ReservaEntidad
	 * @param detalleReservaEntidad
	 * @return
	 */
	public static DetalleReserva mapearAModelo(DetalleReservaEntidad detalleReservaEntidad) {
		if (Objects.isNull(detalleReservaEntidad)) {
			return null;
		}
		return new DetalleReserva(detalleReservaEntidad.getId(), detalleReservaEntidad.getReserva().getId(), 
				detalleReservaEntidad.getFechaEntrega(), detalleReservaEntidad.getCosto());
	}
	
	/**
	 * Metodo encargado de convertir un DetalleReserva en un DetalleReservaEntidad
	 * @param detalleReserva
	 * @return
	 */
	public static DetalleReservaEntidad mapearAEntidad(DetalleReserva detalleReserva) {
		if (Objects.isNull(detalleReserva)) {
			return null;
		}
		ReservaEntidad reservaEntidad = new ReservaEntidad();
		reservaEntidad.setId(detalleReserva.getIdReserva());
		
		return new DetalleReservaEntidad(detalleReserva.getId(), reservaEntidad, 
				detalleReserva.getFechaEntrega(), detalleReserva.getCosto());
	}
}
