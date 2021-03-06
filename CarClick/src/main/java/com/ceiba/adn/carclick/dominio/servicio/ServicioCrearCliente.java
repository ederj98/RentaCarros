package com.ceiba.adn.carclick.dominio.servicio;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.adn.carclick.dominio.modelo.Cliente;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCliente;

public class ServicioCrearCliente {
	
	private RepositorioCliente repositorioCliente;
	private static final String EL_CLIENTE_YA_SE_ENCUENTRA_REGISTRADO = "El cliente ya se encuentra registrado";
	
	public ServicioCrearCliente(RepositorioCliente repositorioCliente) {
		this.repositorioCliente = repositorioCliente;
	}
	
	public void ejecutar(Cliente cliente) {
		validarRegistroPrevio(cliente.getIdCliente());
		ValidarCampos.esVacio(cliente.getIdCliente());
		ValidarCampos.esVacio(cliente.getNombreCompleto());
		ValidarCampos.esVacio(cliente.getEmail());
		this.repositorioCliente.crear(cliente);
	}

	private void validarRegistroPrevio(long idCliente) {
		boolean existe = this.repositorioCliente.existe(idCliente);
		if(existe) {
			throw new ExcepcionDuplicidad(EL_CLIENTE_YA_SE_ENCUENTRA_REGISTRADO);
		}
	}

}
