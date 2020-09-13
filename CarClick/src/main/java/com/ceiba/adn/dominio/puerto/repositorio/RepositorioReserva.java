package com.ceiba.adn.dominio.puerto.repositorio;

import java.util.Collection;
import java.util.Optional;

import com.ceiba.adn.dominio.modelo.Reserva;

public interface RepositorioReserva {
	
	/**
	 * Metodo encargado de la persistencia de una Reserva
	 * @param reserva
	 * @return
	 */
	public Reserva crear(Reserva reserva);

	/**
	 * Metodo encargado de la busqueda de una Reserva dado el ID proporcionado
	 * 
	 * @param id
	 * @return Optional<Reserva> Optional vacio si no encuentra un Cliente con el id proporcionado
	 *         
	 */
	public Optional<Reserva> buscarReserva(long idReserva);
	
	
	/**
	 * Permite listar las reservas por cliente
	 * @param idCliente
	 * @return
	 */
	Collection<Reserva> listar(long idReserva);
}
