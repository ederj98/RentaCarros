package com.ceiba.adn.carclick.dominio.servicio;

import java.util.List;

import com.ceiba.adn.carclick.dominio.modelo.Reserva;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioReserva;

public class ServicioListarReservas {
	
	private RepositorioReserva repositorioReserva;
	
	public ServicioListarReservas(RepositorioReserva repositorioReserva) {
		this.repositorioReserva = repositorioReserva;
	}
	
	public List<Reserva> listar() {
		return repositorioReserva.listar();
	}
}
