package com.ceiba.adn.carclick.aplicacion.manejador;

import java.util.List;

import com.ceiba.adn.carclick.dominio.modelo.Reserva;
import com.ceiba.adn.carclick.dominio.servicio.ServicioListarReservas;

public class ManejadorListarReserva {

	private final ServicioListarReservas servicioListarReservas;
	
	public ManejadorListarReserva(ServicioListarReservas servicioListarReserva) {
		this.servicioListarReservas = servicioListarReserva;
	}
	
	public Reserva ejecutar(long idReserva) {
		return servicioListarReservas.listar(idReserva);
	}
	
	public List<Reserva> ejecutar() {
		return servicioListarReservas.listar();
	}
}
