package com.ceiba.adn.carclick.testdatabuilder;

import com.ceiba.adn.carclick.dominio.modelo.Carro;

public class CarroTestDataBuilder {

	public long id;
	public String modelo;
	public String tipoCambios;
	public int numPasajeros;
	public int numPuertas;
	public String tipoCombustible;
	
	public CarroTestDataBuilder() {
		this.id = 1L;
		this.modelo = "2018";
		this.tipoCambios = "Manual";
		this.numPasajeros = 4;
		this.numPuertas = 4;
		this.tipoCombustible = "Gasolina";
	}
	
	public Carro build() {
		return new Carro(id, modelo, tipoCambios, numPasajeros, numPuertas, tipoCombustible);
	}
	
	public CarroTestDataBuilder conId(long id) {
		this.id = id;
		return this;
	}
	
	public CarroTestDataBuilder conModelo(String modelo) {
		this.modelo = modelo;
		return this;
	}
	
	public CarroTestDataBuilder conTipoCambios(String tipoCambios) {
		this.tipoCambios = tipoCambios;
		return this;
	}
	
	public CarroTestDataBuilder conNumPasajeros(int numPasajeros) {
		this.numPasajeros = numPasajeros;
		return this;
	}
	
	public CarroTestDataBuilder conNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
		return this;
	}
	
	public CarroTestDataBuilder conTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
		return this;
	}
}
