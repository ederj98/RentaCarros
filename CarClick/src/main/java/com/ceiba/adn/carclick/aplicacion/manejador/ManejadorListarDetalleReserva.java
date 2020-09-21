package com.ceiba.adn.carclick.aplicacion.manejador;

import com.ceiba.adn.carclick.dominio.modelo.DetalleReserva;
import com.ceiba.adn.carclick.dominio.servicio.ServicioListarDetalleReserva;

public class ManejadorListarDetalleReserva {

	private final ServicioListarDetalleReserva servicioListarDetalleReserva;
	
	public ManejadorListarDetalleReserva(ServicioListarDetalleReserva servicioListarDetalleReserva) {
		this.servicioListarDetalleReserva = servicioListarDetalleReserva;
	}
	
	public DetalleReserva ejecutar(long idReserva) {
		return servicioListarDetalleReserva.listar(idReserva);
	}
}
