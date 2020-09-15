package com.ceiba.adn.carclick.aplicacion.manejador;

import org.springframework.transaction.annotation.Transactional;

import com.ceiba.adn.carclick.aplicacion.dto.ClienteDTO;
import com.ceiba.adn.carclick.aplicacion.mapeador.MapeadorCliente;
import com.ceiba.adn.carclick.dominio.modelo.Cliente;
import com.ceiba.adn.carclick.dominio.servicio.ServicioCrearCliente;

public class ManejadorCrearCliente {

	private final ServicioCrearCliente servicioCrearCliente;
	
	public ManejadorCrearCliente(ServicioCrearCliente servicioCrearCliente) {
		this.servicioCrearCliente = servicioCrearCliente;
	}
	
	/**
	 * Metodo encargado de la operacion de crear un Cliente
	 * @param clienteDTO
	 * @return
	 */
	@Transactional
	public Cliente ejecutar(ClienteDTO clienteDTO) {
		Cliente cliente = MapeadorCliente.mapearAModelo(clienteDTO);
		return this.servicioCrearCliente.ejecutar(cliente);
	}
}
