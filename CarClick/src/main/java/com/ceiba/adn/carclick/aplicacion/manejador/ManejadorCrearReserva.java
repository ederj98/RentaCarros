package com.ceiba.adn.carclick.aplicacion.manejador;

import org.springframework.transaction.annotation.Transactional;

import com.ceiba.adn.carclick.aplicacion.dto.ReservaDTO;
import com.ceiba.adn.carclick.aplicacion.mapeador.MapeadorReserva;
import com.ceiba.adn.carclick.dominio.modelo.Reserva;
import com.ceiba.adn.carclick.dominio.servicio.ServicioCrearReserva;

public class ManejadorCrearReserva {

	private final ServicioCrearReserva servicioCrearReserva;
	
	public ManejadorCrearReserva(ServicioCrearReserva servicioCrearReserva) {
		this.servicioCrearReserva = servicioCrearReserva;
	}
	
	/**
	 * Metodo encargado de la operacion de crear una Reserva
	 * @param reservaDTO
	 * @return
	 */
	@Transactional
	public void ejecutar(ReservaDTO reservaDTO) {
		Reserva reserva = MapeadorReserva.mapearAModelo(reservaDTO);
		this.servicioCrearReserva.ejecutar(reserva);
	}
}
