package com.ceiba.adn.carclick.dominio.servicio;

import com.ceiba.adn.carclick.dominio.modelo.Cliente;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCliente;
import java.util.Optional;

public class ServicioConsultarClientePorId {

	private RepositorioCliente repositorioCliente;
	
	public ServicioConsultarClientePorId(RepositorioCliente repositorioCliente) {
		this.repositorioCliente = repositorioCliente;
	}
	
	public Optional<Cliente> consultar(long idCliente) {
		return repositorioCliente.buscarCliente(idCliente);
	}
}
