package com.ceiba.adn.carclick.dominio.servicio;

import java.util.List;

import com.ceiba.adn.carclick.dominio.modelo.Carro;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCarro;

public class ServicioListarCarros {
	
	private RepositorioCarro repositorioCarro;
	
	public ServicioListarCarros(RepositorioCarro repositorioCarro) {
		this.repositorioCarro = repositorioCarro;
	}
	
	public List<Carro> listar() {
		return repositorioCarro.listar();
	}
}
