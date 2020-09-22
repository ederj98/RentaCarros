package com.ceiba.adn.carclick.aplicacion.manejador;

import com.ceiba.adn.carclick.aplicacion.dto.ClienteDTO;
import com.ceiba.adn.carclick.aplicacion.mapeador.MapeadorCliente;
import com.ceiba.adn.carclick.dominio.modelo.Cliente;
import com.ceiba.adn.carclick.dominio.servicio.ServicioActualizarCliente;

public class ManejadorActualizarCliente {

	private final ServicioActualizarCliente servicioActualizarCliente;
	
	public ManejadorActualizarCliente(ServicioActualizarCliente servicioActualizarCliente) {
		this.servicioActualizarCliente = servicioActualizarCliente;
	}
	
	public void ejecutar(ClienteDTO clienteDTO) {
		Cliente cliente = MapeadorCliente.mapearAModelo(clienteDTO);
		this.servicioActualizarCliente.actualizarCliente(cliente);
	}
}
