package com.ceiba.adn.carclick.infraestructura.mapeador;

import java.util.Objects;

import com.ceiba.adn.carclick.dominio.modelo.DetalleReserva;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.DetalleReservaEntidad;

public class MapeadorDetalleReservaEntidad {

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
		return new DetalleReserva(detalleReservaEntidad.getId(), detalleReservaEntidad.getIdReserva(), 
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
		return new DetalleReservaEntidad(detalleReserva.getId(), detalleReserva.getIdReserva(), 
				detalleReserva.getFechaEntrega(), detalleReserva.getCosto());
	}
}
