package com.ceiba.adn.carclick.dominio.servicio;

import java.time.LocalDateTime;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionReservaNoRegistrada;
import com.ceiba.adn.carclick.dominio.modelo.DetalleReserva;
import com.ceiba.adn.carclick.dominio.modelo.Reserva;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioDetalleReserva;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioReserva;

public class ServicioCrearDetalleReserva {
	
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
					throw new ExcepcionReservaNoRegistrada(LA_RESERVA_INGRESADA_NO_EXISTE);
				});
		
		detalleReserva.setFechaEntrega(LocalDateTime.now());
		ValidarFechas.validarFechaRecogidaAnteriorAFechaEntrega(reserva.getFechaRecogida(), detalleReserva.getFechaEntrega());
		ValidarFechas.validarFechaFueraHorarioServicio(detalleReserva.getFechaEntrega());
		ValidarCampos.esVacio(detalleReserva.getIdReserva());
		detalleReserva.setCosto(Alquiler.calcularCosto(reserva, detalleReserva.getFechaEntrega()));
		return repositorioDetalleReserva.crear(detalleReserva);
	}
}
