package com.ceiba.adn.carclick.infraestructura.adaptador.repositorio;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ceiba.adn.carclick.dominio.modelo.Cliente;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCliente;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.ClienteEntidad;
import com.ceiba.adn.carclick.infraestructura.mapeador.MapeadorClienteEntidad;

@Repository
public class RepositorioClienteMySql implements RepositorioCliente {
	
	private RepositorioClienteJPA clienteJPA;
	
	public RepositorioClienteMySql(RepositorioClienteJPA clienteJPA) {
		this.clienteJPA = clienteJPA;
	}

	@Override
	public Cliente crear(Cliente cliente) {
		ClienteEntidad entidad = MapeadorClienteEntidad.mapearAEntidad(cliente);
		return MapeadorClienteEntidad.mapearAModelo(clienteJPA.save(entidad));
	}

	@Override
	public boolean existe(long idCliente) {
		return clienteJPA.existsById(idCliente);
	}

	@Override
	public Optional<Cliente> buscarCliente(long idCliente) {
		return clienteJPA.findByIdCliente(idCliente);
	}
}
