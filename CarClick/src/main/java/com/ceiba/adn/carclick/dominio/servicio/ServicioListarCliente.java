package com.ceiba.adn.carclick.dominio.servicio;

import java.util.Optional;

import com.ceiba.adn.carclick.dominio.modelo.Cliente;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCliente;

public class ServicioListarCliente {

	private RepositorioCliente repositorioCliente;
	
	public ServicioListarCliente(RepositorioCliente repositorioCliente) {
		this.repositorioCliente = repositorioCliente;
	}
	
	public Optional<Cliente> listar(long idCliente) {
		return repositorioCliente.buscarCliente(idCliente);
	}
}
