package com.ceiba.adn.carclick.dominio.puerto.repositorio;

import java.util.Optional;

import com.ceiba.adn.carclick.dominio.modelo.DetalleReserva;
import com.ceiba.adn.carclick.dominio.modelo.Reserva;

public interface RepositorioDetalleReserva {

	/**
	 * Metodo encargado de la persistencia del Detalle de una Reserva
	 * @param detalleReserva
	 */
	public DetalleReserva crear(DetalleReserva detalleReserva);
	
	/**
	 * Metodo encargado de la busqueda de una DetalleReserva dado el ID proporcionado
	 * 
	 * @param id
	 * @return Optional<DetalleReserva> Optional vacio si no encuentra un DetalleReserva con el id proporcionado
	 *         
	 */
	public Optional<DetalleReserva> buscarDetalleReserva(long idDetalleReserva);
}
