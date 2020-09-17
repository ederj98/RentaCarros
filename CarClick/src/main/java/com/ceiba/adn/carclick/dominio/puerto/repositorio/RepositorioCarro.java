package com.ceiba.adn.carclick.dominio.puerto.repositorio;

import java.util.List;

import com.ceiba.adn.carclick.dominio.modelo.Carro;

public interface RepositorioCarro {
	
	/**
	 * Metodo encargado de la persistencia de un Carro
	 * @param cliente
	 * @return
	 */
	public Carro crear(Carro carro);
	
	/**
	 * Metodo que permite determinar si previamente se registro el Carro
	 * @param carro
	 * @return
	 */
	public boolean existe(long idCarro);
	
	/**
	 * Metodo que permite listar los Carros registrados
	 * @return
	 */
	public List<Carro> listar();

}
