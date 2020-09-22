package com.ceiba.adn.carclick.aplicacion.manejador;

import org.springframework.transaction.annotation.Transactional;

import com.ceiba.adn.carclick.aplicacion.dto.DetalleReservaDTO;
import com.ceiba.adn.carclick.aplicacion.mapeador.MapeadorDetalleReserva;
import com.ceiba.adn.carclick.dominio.modelo.DetalleReserva;
import com.ceiba.adn.carclick.dominio.servicio.ServicioCrearDetalleReserva;

public class ManejadorCrearDetalleReserva {

private final ServicioCrearDetalleReserva servicioCrearDetalleReserva;
	
	public ManejadorCrearDetalleReserva(ServicioCrearDetalleReserva servicioCrearDetalleReserva) {
		this.servicioCrearDetalleReserva = servicioCrearDetalleReserva;
	}
	
	/**
	 * Metodo encargado de la operacion de crear una DetalleReserva
	 * @param detalleReservaDTO
	 * @return
	 */
	@Transactional
	public DetalleReserva ejecutar(DetalleReservaDTO detalleReservaDTO) {
		DetalleReserva detalleReserva = MapeadorDetalleReserva.mapearAModelo(detalleReservaDTO);
		return this.servicioCrearDetalleReserva.ejecutar(detalleReserva);
	}
}
