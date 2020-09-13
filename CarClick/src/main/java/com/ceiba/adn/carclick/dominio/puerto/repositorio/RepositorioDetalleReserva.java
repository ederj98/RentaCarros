package com.ceiba.adn.carclick.dominio.puerto.repositorio;

import com.ceiba.adn.carclick.dominio.modelo.DetalleReserva;

public interface RepositorioDetalleReserva {

	/**
	 * Metodo encargado de la persistencia del Detalle de una Reserva
	 * @param detalleReserva
	 */
	public DetalleReserva crear(DetalleReserva detalleReserva);
}
