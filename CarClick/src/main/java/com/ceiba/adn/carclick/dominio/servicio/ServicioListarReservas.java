package com.ceiba.adn.carclick.dominio.servicio;

import java.util.List;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionReservaNoRegistrada;
import com.ceiba.adn.carclick.dominio.modelo.Reserva;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioReserva;

public class ServicioListarReservas {
	
	private RepositorioReserva repositorioReserva;
	private static final String LA_RESERVA_NO_SE_ENCUENTRA_REGISTRADA = "la reserva no se encuentra registrada";
		
	public ServicioListarReservas(RepositorioReserva repositorioReserva) {
		this.repositorioReserva = repositorioReserva;
	}
	
	public Reserva listar(long idReserva) {
		return repositorioReserva.buscarReserva(idReserva)
				.orElseThrow(() -> { 
					throw new ExcepcionReservaNoRegistrada(LA_RESERVA_NO_SE_ENCUENTRA_REGISTRADA);
				});
	}
	
	public List<Reserva> listar() {
		return repositorioReserva.listar();
	}
}
