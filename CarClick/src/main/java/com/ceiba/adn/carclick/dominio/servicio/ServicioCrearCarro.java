package com.ceiba.adn.carclick.dominio.servicio;

import com.ceiba.adn.carclick.dominio.modelo.Carro;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCarro;

public class ServicioCrearCarro {
	
	private RepositorioCarro repositorioCarro;
	
	public ServicioCrearCarro(RepositorioCarro repositorioCarro) {
		this.repositorioCarro = repositorioCarro;
	}
	
	public void ejecutar(Carro carro) {
		ValidarCampos.esVacio(carro.getModelo());
		ValidarCampos.esVacio(carro.getNumPasajeros());
		ValidarCampos.esVacio(carro.getNumPuertas());
		ValidarCampos.esVacio(carro.getTipoCambios());
		ValidarCampos.esVacio(carro.getTipoCombustible());
		this.repositorioCarro.crear(carro);
	}
}
