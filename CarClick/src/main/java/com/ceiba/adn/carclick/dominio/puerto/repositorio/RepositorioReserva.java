package com.ceiba.adn.carclick.dominio.puerto.repositorio;

import java.util.List;
import java.util.Optional;

import com.ceiba.adn.carclick.dominio.modelo.Reserva;

public interface RepositorioReserva {
	
	/**
	 * Metodo encargado de la persistencia de una Reserva
	 * @param reserva
	 * @return
	 */
	public Reserva crear(Reserva reserva);
	
	/**
	 * Metodo encargado de la actualizar una Reserva
	 * @param reserva
	 */
	public void actualizar(Reserva reserva);
	
	/**
	 * Metodo que permite determinar si previamente se registro una reserva
	 * @param idReserva
	 * @return
	 */
	public boolean existe(long idReserva);

	/**
	 * Metodo encargado de la busqueda de una Reserva dado el ID proporcionado
	 * 
	 * @param id
	 * @return Optional<Reserva> Optional vacio si no encuentra un Cliente con el id proporcionado
	 *         
	 */
	public Optional<Reserva> buscarReserva(long idReserva);
	
	
	/**
	 * Permite listar las reservas
	 * 
	 * @return
	 */
	public List<Reserva> listar();
}
