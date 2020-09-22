package com.ceiba.adn.carclick.aplicacion.manejador;

import com.ceiba.adn.carclick.dominio.modelo.Cliente;
import com.ceiba.adn.carclick.dominio.servicio.ServicioListarCliente;

public class ManejadorListarCliente {

	private final ServicioListarCliente servicioListarCliente;
	
	public ManejadorListarCliente(ServicioListarCliente servicioListarCliente) {
		this.servicioListarCliente = servicioListarCliente;
	}
	
	public Cliente ejecutar(long idCliente) {
		return servicioListarCliente.listar(idCliente);
	}
}
