package com.ceiba.adn.carclick.dominio.servicio;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionClienteNoRegistrado;
import com.ceiba.adn.carclick.dominio.modelo.Cliente;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCliente;

public class ServicioListarCliente {

	private RepositorioCliente repositorioCliente;
	private static final String EL_CLIENTE_NO_SE_ENCUENTRA_REGISTRADO = "El cliente no se encuentra registrado";
	
	public ServicioListarCliente(RepositorioCliente repositorioCliente) {
		this.repositorioCliente = repositorioCliente;
	}
	
	public Cliente listar(long idCliente) {
		return repositorioCliente.buscarCliente(idCliente)
				.orElseThrow(() -> { 
					throw new ExcepcionClienteNoRegistrado(EL_CLIENTE_NO_SE_ENCUENTRA_REGISTRADO);
				});
	}
}
