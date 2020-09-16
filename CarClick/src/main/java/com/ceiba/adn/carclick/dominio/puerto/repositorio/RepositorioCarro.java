package com.ceiba.adn.carclick.dominio.puerto.repositorio;

import java.util.List;

import com.ceiba.adn.carclick.dominio.modelo.Carro;
import com.ceiba.adn.carclick.dominio.modelo.Cliente;

public interface RepositorioCarro {
	
	/**
	 * Metodo encargado de la persistencia de un Carro
	 * @param cliente
	 * @return
	 */
	public Carro crear(Carro carro);
	
	/**
	 * Metodo que permite listar los Carros registrados
	 * @return
	 */
	public List<Carro> listar();

}
