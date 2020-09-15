package com.ceiba.adn.carclick.infraestructura.mapeador;

import java.util.Objects;

import com.ceiba.adn.carclick.dominio.modelo.Reserva;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.ClienteEntidad;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.ReservaEntidad;

public class MapeadorReservaEntidad {
	
	private MapeadorReservaEntidad() {}
	
	/**
	 * Metodo encargado de convertir un Reserva en un ReservaEntidad
	 * @param reservaEntidad
	 * @return
	 */
	public static Reserva mapearAModelo(ReservaEntidad reservaEntidad) {
		System.out.println("AQUI fur!!! "+reservaEntidad.getIdCliente());
		if (Objects.isNull(reservaEntidad)) {
			System.out.println("AQUI 1!!! "+reservaEntidad.getIdCliente());
			return null;
		}
		System.out.println("AQUI no entro!!! "+reservaEntidad.getIdCliente());
		return new Reserva(reservaEntidad.getId(), reservaEntidad.getIdCliente().getIdCliente(), 
				reservaEntidad.getIdCarro(), reservaEntidad.getFechaRecogida());
	}

	/**
	 * Metodo encargado de convertir un ReservaEntidad en un Reserva
	 * @param reserva
	 * @return
	 */
	public static ReservaEntidad mapearAEntidad(Reserva reserva) {
		if (Objects.isNull(reserva)) {
			return null;
		}
		ClienteEntidad clienteEntidad = new ClienteEntidad();
		clienteEntidad.setIdCliente(reserva.getIdCliente());
		
		return new ReservaEntidad(reserva.getId(), clienteEntidad, 
				reserva.getIdCarro(), reserva.getFechaRecogida());
	}
}
