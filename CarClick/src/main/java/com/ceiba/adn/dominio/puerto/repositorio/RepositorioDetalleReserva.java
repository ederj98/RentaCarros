package com.ceiba.adn.dominio.puerto.repositorio;

import com.ceiba.adn.dominio.modelo.DetalleReserva;

public interface RepositorioDetalleReserva {

	/**
	 * Metodo encargado de la persistencia del Detalle de una Reserva
	 * @param detalleReserva
	 */
	public DetalleReserva crear(DetalleReserva detalleReserva);
}
