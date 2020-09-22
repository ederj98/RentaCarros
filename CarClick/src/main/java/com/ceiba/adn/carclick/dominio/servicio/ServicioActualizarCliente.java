package com.ceiba.adn.carclick.dominio.servicio;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionClienteNoRegistrado;
import com.ceiba.adn.carclick.dominio.modelo.Cliente;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCliente;

public class ServicioActualizarCliente {

	private RepositorioCliente repositorioCliente;
	private static final String EL_CLIENTE_INGRESADO_NO_SE_ENCUENTRA_REGISTRADO = "El cliente ingresado no se encuentra registrado";
	
	public ServicioActualizarCliente(RepositorioCliente repositorioCliente) {
		this.repositorioCliente = repositorioCliente;
	}
	
	public void actualizarCliente(Cliente cliente) {
		validarRegistroPrevioCliente(cliente.getIdCliente());
		repositorioCliente.crear(cliente);
	}
		
	private void validarRegistroPrevioCliente(long idCliente) {
		boolean existe = this.repositorioCliente.existe(idCliente);
		if(!existe) {
			throw new ExcepcionClienteNoRegistrado(EL_CLIENTE_INGRESADO_NO_SE_ENCUENTRA_REGISTRADO);
		}
	}
}
