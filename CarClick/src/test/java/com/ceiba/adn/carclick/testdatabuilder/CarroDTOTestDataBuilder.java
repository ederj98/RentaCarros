package com.ceiba.adn.carclick.testdatabuilder;

import com.ceiba.adn.carclick.aplicacion.dto.CarroDTO;

public class CarroDTOTestDataBuilder {

	public long id;
	public String modelo;
	public String tipoCambios;
	public int numPasajeros;
	public int numPuertas;
	public String tipoCombustible;
	
	
	
	public CarroDTOTestDataBuilder(long id, String modelo, String tipoCambios, int numPasajeros, int numPuertas,
			String tipoCombustible) {
		this.id = id;
		this.modelo = modelo;
		this.tipoCambios = tipoCambios;
		this.numPasajeros = numPasajeros;
		this.numPuertas = numPuertas;
		this.tipoCombustible = tipoCombustible;
	}

	public CarroDTOTestDataBuilder() {
		this.id = 1L;
		this.modelo = "2018";
		this.tipoCambios = "Manual";
		this.numPasajeros = 4;
		this.numPuertas = 4;
		this.tipoCombustible = "Gasolina";
	}
	
	public CarroDTO build() {
		return new CarroDTO(id, modelo, tipoCambios, numPasajeros, numPuertas, tipoCombustible);
	}
	
	public CarroDTOTestDataBuilder conId(long id) {
		this.id = id;
		return this;
	}
	
	public CarroDTOTestDataBuilder conModelo(String modelo) {
		this.modelo = modelo;
		return this;
	}
	
	public CarroDTOTestDataBuilder conTipoCambios(String tipoCambios) {
		this.tipoCambios = tipoCambios;
		return this;
	}
	
	public CarroDTOTestDataBuilder conNumPasajeros(int numPasajeros) {
		this.numPasajeros = numPasajeros;
		return this;
	}
	
	public CarroDTOTestDataBuilder conNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
		return this;
	}
	
	public CarroDTOTestDataBuilder conTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
		return this;
	}
}
