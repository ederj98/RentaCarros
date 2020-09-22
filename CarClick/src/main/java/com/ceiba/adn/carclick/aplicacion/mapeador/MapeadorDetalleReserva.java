package com.ceiba.adn.carclick.aplicacion.mapeador;

import java.util.Objects;

import com.ceiba.adn.carclick.aplicacion.dto.DetalleReservaDTO;
import com.ceiba.adn.carclick.dominio.modelo.DetalleReserva;

public final class MapeadorDetalleReserva {

	private MapeadorDetalleReserva() {}
	
	/**
	 * Metodo encargado de convertir una DetalleReserva en una DetalleReservaDTO
	 * @param detalleReserva
	 * @return DetalleReservaDTO
	 */
	public static DetalleReservaDTO mapearADTO(DetalleReserva detalleReserva) {
		if (Objects.isNull(detalleReserva)) {
			return null;
		}
		return new DetalleReservaDTO(detalleReserva.getId(), detalleReserva.getIdReserva(), 
				detalleReserva.getFechaEntrega(), detalleReserva.getCosto());
	}
	
	/**
	 * Metodo encargado de convertir una DetalleReservaDTO en una DetalleReserva
	 * @param detalleReservaDTO
	 * @return DetalleReserva
	 */
	public static DetalleReserva mapearAModelo(DetalleReservaDTO detalleReservaDTO) {
		if (Objects.isNull(detalleReservaDTO)) {
			return null;
		}
		return new DetalleReserva(detalleReservaDTO.getId(), detalleReservaDTO.getIdReserva(), 
				detalleReservaDTO.getFechaEntrega(), detalleReservaDTO.getCosto());
	}
}
