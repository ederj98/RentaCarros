package com.ceiba.adn.carclick.aplicacion.mapeador;

import java.util.Objects;

import com.ceiba.adn.carclick.aplicacion.dto.ReservaDTO;
import com.ceiba.adn.carclick.dominio.modelo.Reserva;

public class MapeadorReserva {

	/**
	 * Metodo encargado de convertir una Reserva en una ReservaDTO
	 * @param reserva
	 * @return ReservaDTO
	 */
	public static ReservaDTO mapearADTO(Reserva reserva) {
		if (Objects.isNull(reserva)) {
			return null;
		}
		return new ReservaDTO(reserva.getId(), reserva.getIdCliente(), reserva.getIdCarro(), 
				reserva.getFechaRecogida());
	}
	
	/**
	 * Metodo encargado de convertir una ReservaDTO en una Reserva
	 * @param reservaDTO
	 * @return Reserva
	 */
	public static Reserva mapearAModelo(ReservaDTO reservaDTO) {
		if (Objects.isNull(reservaDTO)) {
			return null;
		}
		return new Reserva(reservaDTO.getId(), reservaDTO.getIdCliente(), reservaDTO.getIdCarro(), 
				reservaDTO.getFechaRecogida());
	}
}
