package com.ceiba.adn.carclick.dominio.servicio;

import com.ceiba.adn.carclick.dominio.modelo.Carro;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCarro;

public class ServicioCrearCarro {
	
	private RepositorioCarro repositorioCarro;
	
	public ServicioCrearCarro(RepositorioCarro repositorioCarro) {
		this.repositorioCarro = repositorioCarro;
	}
	
	public void ejecutar(Carro carro) {
		this.repositorioCarro.crear(carro);
	}
}
