package com.ceiba.adn.carclick.dominio.servicio;

import com.ceiba.adn.carclick.dominio.modelo.Reserva;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioReserva;

public class ServicioActualizarReserva {

	private RepositorioReserva repositorioReserva;
	
	public ServicioActualizarReserva(RepositorioReserva repositorioReserva) {
		this.repositorioReserva = repositorioReserva;
	}
	
	public void actualizarReserva(Reserva reserva) {
		repositorioReserva.actualizar(reserva);
	}
}
