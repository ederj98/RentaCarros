package com.ceiba.adn.carclick.aplicacion.manejador;

import com.ceiba.adn.carclick.aplicacion.dto.ReservaDTO;
import com.ceiba.adn.carclick.aplicacion.mapeador.MapeadorReserva;
import com.ceiba.adn.carclick.dominio.modelo.Reserva;
import com.ceiba.adn.carclick.dominio.servicio.ServicioActualizarReserva;

public class ManejadorActualizarReserva {

	private final ServicioActualizarReserva servicioActualizarReserva;
	
	public ManejadorActualizarReserva(ServicioActualizarReserva servicioActualizarReserva) {
		this.servicioActualizarReserva = servicioActualizarReserva;
	}
	
	public void ejecutar(ReservaDTO reservaDTO) {
		Reserva reserva = MapeadorReserva.mapearAModelo(reservaDTO);
		this.servicioActualizarReserva.actualizarReserva(reserva);
	}
}
