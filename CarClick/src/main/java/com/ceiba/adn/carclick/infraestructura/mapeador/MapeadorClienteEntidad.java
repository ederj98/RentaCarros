package com.ceiba.adn.carclick.infraestructura.mapeador;

import java.util.Objects;

import com.ceiba.adn.carclick.dominio.modelo.Cliente;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.ClienteEntidad;

public class MapeadorClienteEntidad {

	private MapeadorClienteEntidad() {}
	
	/**
	 * Metodo encargado de convertir un Cliente en un ClienteEntidad
	 * @param clienteEntidad
	 * @return
	 */
	public static Cliente mpearAModelo(ClienteEntidad clienteEntidad) {
		if (Objects.isNull(clienteEntidad)) {
			return null;
		}
		return new Cliente(clienteEntidad.getIdCliente(), clienteEntidad.getNombreCompleto(), 
				clienteEntidad.getTelefono(), clienteEntidad.getDireccion(), clienteEntidad.getEmail());
	}
	
	/**
	 * Metodo encargado de convertir un ClienteEntidad en un Cliente
	 * @param cliente
	 * @return
	 */
	public static ClienteEntidad mapearAEntidad(Cliente cliente) {
		if (Objects.isNull(cliente)) {
			return null;
		}
		return new ClienteEntidad(cliente.getIdCliente(), cliente.getNombreCompleto(), 
				cliente.getTelefono(), cliente.getDireccion(), cliente.getEmail());
	}
}
