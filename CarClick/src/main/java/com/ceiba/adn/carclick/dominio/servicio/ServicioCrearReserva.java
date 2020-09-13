package com.ceiba.adn.carclick.dominio.servicio;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionClienteNoRegistrado;
import com.ceiba.adn.carclick.dominio.modelo.Reserva;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCliente;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioReserva;

public class ServicioCrearReserva {

	private static final Logger LOG = LogManager.getLogger(ServicioCrearReserva.class);
	private RepositorioReserva repositorioReserva;
	private RepositorioCliente repositorioCliente;
	private static final String EL_CLIENTE_NO_SE_ENCUENTRA_REGISTRADO = "El cliente no se encuentra registrado";

	public ServicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioCliente repositorioCliente) {
		this.repositorioReserva = repositorioReserva;
		this.repositorioCliente = repositorioCliente;
	}

	public Reserva ejecutar(Reserva reserva) {
		repositorioCliente.buscarCliente(reserva.getIdCliente())
				.orElseThrow(() -> { 
					ExcepcionClienteNoRegistrado excepcion = new ExcepcionClienteNoRegistrado(
						EL_CLIENTE_NO_SE_ENCUENTRA_REGISTRADO);
					LOG.warn(excepcion);
					throw excepcion;
				});
		
		return repositorioReserva.crear(reserva);
	}
}
