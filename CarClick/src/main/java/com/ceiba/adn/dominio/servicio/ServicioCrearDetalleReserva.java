package com.ceiba.adn.dominio.servicio;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ceiba.adn.dominio.excepcion.ExcepcionClienteNoRegistrado;
import com.ceiba.adn.dominio.modelo.DetalleReserva;
import com.ceiba.adn.dominio.modelo.Reserva;
import com.ceiba.adn.dominio.puerto.repositorio.RepositorioDetalleReserva;
import com.ceiba.adn.dominio.puerto.repositorio.RepositorioReserva;

public class ServicioCrearDetalleReserva {
	
	private static final Logger LOG = LogManager.getLogger(ServicioCrearDetalleReserva.class);
	private RepositorioDetalleReserva repositorioDetalleReserva;
	private RepositorioReserva repositorioReserva;
	private static final String LA_RESERVA_INGRESADA_NO_EXISTE = "La reserva ingresada no existe";

	public ServicioCrearDetalleReserva(RepositorioDetalleReserva repositorioDetalleReserva, RepositorioReserva repositorioReserva) {
		this.repositorioDetalleReserva = repositorioDetalleReserva;
		this.repositorioReserva = repositorioReserva;
	}
	
	public DetalleReserva ejecutar(DetalleReserva detalleReserva) {
		Reserva reserva = repositorioReserva.buscarReserva(detalleReserva.getIdReserva())
				.orElseThrow(() -> { 
					ExcepcionClienteNoRegistrado excepcion = new ExcepcionClienteNoRegistrado(
						LA_RESERVA_INGRESADA_NO_EXISTE);
					LOG.warn(excepcion);
					throw excepcion;
				});
		
		detalleReserva.setFechaEntrega(LocalDateTime.now());
		detalleReserva.setCosto(Alquiler.calcularCosto(reserva, detalleReserva.getFechaEntrega()));
		return repositorioDetalleReserva.crear(detalleReserva);
	}
}
