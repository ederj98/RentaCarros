package com.ceiba.adn.carclick.dominio.servicio;

import java.time.LocalDateTime;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionCarroNoRegistrado;
import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionClienteNoRegistrado;
import com.ceiba.adn.carclick.dominio.modelo.Reserva;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCarro;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCliente;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioReserva;

public class ServicioCrearReserva {

	private RepositorioReserva repositorioReserva;
	private RepositorioCliente repositorioCliente;
	private RepositorioCarro repositorioCarro;
	private static final String EL_CLIENTE_INGRESADO_NO_SE_ENCUENTRA_REGISTRADO = "El cliente ingresado no se encuentra registrado";
	private static final String EL_CARRO_INGRESADO_NO_SE_ENCUENTRA_REGISTRADO = "El carro ingresado no se encuentra registrado";
	
	public ServicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioCliente repositorioCliente, RepositorioCarro repositorioCarro) {
		this.repositorioReserva = repositorioReserva;
		this.repositorioCliente = repositorioCliente;
		this.repositorioCarro = repositorioCarro;
	}

	public Reserva ejecutar(Reserva reserva) {
		validarRegistroPrevioCliente(reserva.getIdCliente());
		validarRegistroPrevioCarro(reserva.getIdCarro());
		
		ValidarCampos.esVacio(reserva.getFechaRecogida());
		ValidarFechas.validarFechaRecogidaPosteriorAFechaActual(reserva.getFechaRecogida(), LocalDateTime.now());
		ValidarFechas.validarFechaFueraHorarioServicio(reserva.getFechaRecogida());
		ValidarCampos.esVacio(reserva.getIdCliente());
		ValidarCampos.esVacio(reserva.getIdCarro());
		return repositorioReserva.crear(reserva);
	}
	
	private void validarRegistroPrevioCliente(long idCliente) {
		boolean existe = this.repositorioCliente.existe(idCliente);
		if(!existe) {
			throw new ExcepcionClienteNoRegistrado(EL_CLIENTE_INGRESADO_NO_SE_ENCUENTRA_REGISTRADO);
		}
	}
	
	private void validarRegistroPrevioCarro(long idCarro) {
		boolean existe = this.repositorioCarro.existe(idCarro);
		if(!existe) {
			throw new ExcepcionCarroNoRegistrado(EL_CARRO_INGRESADO_NO_SE_ENCUENTRA_REGISTRADO);
		}
	}
}
