package com.ceiba.adn.carclick.dominio.puerto.repositorio;

import java.util.Optional;

import com.ceiba.adn.carclick.dominio.modelo.Cliente;

public interface RepositorioCliente {
	
	/**
	 * Metodo encargado de la persistencia de un Cliente
	 * @param cliente
	 * @return
	 */
	public Cliente crear(Cliente cliente);
	
	/**
	 * Metodo que permite determinar si previamente se registro el Cliente
	 * @param cliente
	 * @return
	 */
	public boolean existe(Cliente cliente);
	
	/**
	 * Metodo encargado de la busqueda de una Cliente dado el ID proporcionado
	 * 
	 * @param id
	 * @return Optional<Cliente> Optional vacio si no encuentra un Cliente con el id proporcionado
	 *         
	 */
	public Optional<Cliente> buscarCliente(long idCliente);

}
