package com.ceiba.adn.carclick.dominio.servicio;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.adn.carclick.dominio.modelo.Cliente;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCliente;

public class ServicioCrearCliente {
	
	private RepositorioCliente repositorioCliente;
	private static final Logger LOG = LogManager.getLogger(ServicioCrearCliente.class);
	private static final String EL_CLIENTE_YA_SE_ENCUENTRA_REGISTRADO = "El cliente ya se encuentra registrado";
	
	public ServicioCrearCliente(RepositorioCliente repositorioCliente) {
		this.repositorioCliente = repositorioCliente;
	}
	
	public Cliente ejecutar(Cliente cliente) {
		validarRegistroPrevio(cliente);
		return this.repositorioCliente.crear(cliente);
	}

	private void validarRegistroPrevio(Cliente cliente) {
		boolean existe = this.repositorioCliente.existe(cliente);
		if(existe) {
			ExcepcionDuplicidad excepcion = new ExcepcionDuplicidad(
					EL_CLIENTE_YA_SE_ENCUENTRA_REGISTRADO);
			LOG.warn(excepcion);
			throw excepcion;
		}
	}

}
