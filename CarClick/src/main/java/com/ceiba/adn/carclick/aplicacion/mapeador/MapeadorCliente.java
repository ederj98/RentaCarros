package com.ceiba.adn.carclick.aplicacion.mapeador;

import java.util.Objects;

import com.ceiba.adn.carclick.aplicacion.dto.ClienteDTO;
import com.ceiba.adn.carclick.dominio.modelo.Cliente;

public class MapeadorCliente {

	private MapeadorCliente() {}
	
	/**
	 * Metodo encargado de convertir un Cliente en un ClienteDTO
	 * @param cliente
	 * @return ClienteDTO
	 */
	public static ClienteDTO mapearADTO(Cliente cliente) {
		if (Objects.isNull(cliente)) {
			return null;
		}
		return new ClienteDTO(cliente.getIdCliente(), cliente.getNombreCompleto(), cliente.getTelefono(), 
				cliente.getDireccion(), cliente.getEmail());
	}
	
	/**
	 * Metodo encargado de convertir un ClienteDTO en un Cliente
	 * @param clienteDTO
	 * @return Cliente
	 */
	public static Cliente mapearAModelo(ClienteDTO clienteDTO) {
		if (Objects.isNull(clienteDTO)) {
			return null;
		}
		return new Cliente(clienteDTO.getIdCliente(), clienteDTO.getNombreCompleto(), clienteDTO.getTelefono(), 
				clienteDTO.getDireccion(), clienteDTO.getEmail());
	}
}
