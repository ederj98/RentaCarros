package com.ceiba.adn.carclick.dominio.servicio;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionReservaNoRegistrada;
import com.ceiba.adn.carclick.dominio.modelo.DetalleReserva;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioDetalleReserva;

public class ServicioListarDetalleReserva {

	private RepositorioDetalleReserva repositorioDetalleReserva;
	private static final String LA_RESERVA_NO_SE_ENCUENTRA_REGISTRADA = "la reserva no se encuentra registrada";
	
	public ServicioListarDetalleReserva(RepositorioDetalleReserva repositorioDetalleReserva) {
		this.repositorioDetalleReserva = repositorioDetalleReserva;
	}
	
	public DetalleReserva listar(long idReserva) {
		return repositorioDetalleReserva.buscarDetalleReserva(idReserva)
				.orElseThrow(
						() -> { 
							throw new ExcepcionReservaNoRegistrada(LA_RESERVA_NO_SE_ENCUENTRA_REGISTRADA);
						}
						);
	}
}
