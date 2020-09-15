package com.ceiba.adn.carclick.infraestructura.adaptador.repositorio;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ceiba.adn.carclick.dominio.modelo.Cliente;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCliente;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.ClienteEntidad;
import com.ceiba.adn.carclick.infraestructura.mapeador.MapeadorClienteEntidad;

@Repository
public class AdaptadorRepositorioCliente implements RepositorioCliente {
	
	private RepositorioClienteJPA clienteJPA;
	
	public AdaptadorRepositorioCliente(RepositorioClienteJPA clienteJPA) {
		this.clienteJPA = clienteJPA;
	}

	@Override
	public Cliente crear(Cliente cliente) {
		ClienteEntidad entidad = MapeadorClienteEntidad.mapearAEntidad(cliente);
		return MapeadorClienteEntidad.mpearAModelo(clienteJPA.save(entidad));
	}

	@Override
	public boolean existe(Cliente cliente) {
		return clienteJPA.existsById(cliente.getIdCliente());
	}

	@Override
	public Optional<Cliente> buscarCliente(long idCliente) {
		return clienteJPA.findByIdCliente(idCliente);
	}
}
