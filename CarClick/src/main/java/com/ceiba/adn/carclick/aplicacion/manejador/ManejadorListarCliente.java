package com.ceiba.adn.carclick.aplicacion.manejador;

import java.util.Optional;

import com.ceiba.adn.carclick.dominio.modelo.Cliente;
import com.ceiba.adn.carclick.dominio.servicio.ServicioListarCliente;

public class ManejadorListarCliente {

	private final ServicioListarCliente servicioListarCliente;
	
	public ManejadorListarCliente(ServicioListarCliente servicioListarCliente) {
		this.servicioListarCliente = servicioListarCliente;
	}
	
	public Optional<Cliente> ejecutar(long idCliente) {
		return servicioListarCliente.listar(idCliente);
	}
}
