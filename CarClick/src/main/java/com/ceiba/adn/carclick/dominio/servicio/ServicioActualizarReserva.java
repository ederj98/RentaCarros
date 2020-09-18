package com.ceiba.adn.carclick.dominio.servicio;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionCarroNoRegistrado;
import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionClienteNoRegistrado;
import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionReservaNoRegistrada;
import com.ceiba.adn.carclick.dominio.modelo.Reserva;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCarro;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCliente;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioReserva;

public class ServicioActualizarReserva {

	private RepositorioReserva repositorioReserva;
	private RepositorioCarro repositorioCarro;
	private RepositorioCliente repositorioCliente;
	private static final String LA_RESERVA_INGRESADA_NO_SE_ENCUENTRA_REGISTRADA = "La reserva ingresada no se encuentra registrada";
	private static final String EL_CLIENTE_INGRESADO_NO_SE_ENCUENTRA_REGISTRADO = "El cliente ingresado no se encuentra registrado";
	private static final String EL_CARRO_INGRESADO_NO_SE_ENCUENTRA_REGISTRADO = "El carro ingresado no se encuentra registrado";
	
	public ServicioActualizarReserva(RepositorioReserva repositorioReserva, RepositorioCarro repositorioCarro, RepositorioCliente repositorioCliente) {
		this.repositorioReserva = repositorioReserva;
		this.repositorioCarro = repositorioCarro;
		this.repositorioCliente = repositorioCliente;
	}
	
	public void actualizarReserva(Reserva reserva) {
		validarRegistroPrevioReserva(reserva.getId());
		validarRegistroPrevioCarro(reserva.getIdCarro());
		validarRegistroPrevioCliente(reserva.getIdCliente());
		repositorioReserva.actualizar(reserva);
	}
	
	private void validarRegistroPrevioReserva(long idReserva) {
		boolean existe = this.repositorioReserva.existe(idReserva);
		if(!existe) {
			throw new ExcepcionReservaNoRegistrada(LA_RESERVA_INGRESADA_NO_SE_ENCUENTRA_REGISTRADA);
		}
	}
	
	private void validarRegistroPrevioCarro(long idCarro) {
		boolean existe = this.repositorioCarro.existe(idCarro);
		if(!existe) {
			throw new ExcepcionCarroNoRegistrado(EL_CARRO_INGRESADO_NO_SE_ENCUENTRA_REGISTRADO);
		}
	}
	
	private void validarRegistroPrevioCliente(long idCliente) {
		boolean existe = this.repositorioCliente.existe(idCliente);
		if(!existe) {
			throw new ExcepcionClienteNoRegistrado(EL_CLIENTE_INGRESADO_NO_SE_ENCUENTRA_REGISTRADO);
		}
	}
}
