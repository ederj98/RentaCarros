package com.ceiba.adn.carclick.testdatabuilder;

import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.CarroEntidad;

public class CarroEntidadTestDataBuilder {

	public long id;
	public String modelo;
	public String tipoCambios;
	public int numPasajeros;
	public int numPuertas;
	public String tipoCombustible;
	
	public CarroEntidadTestDataBuilder(long id, String modelo, String tipoCambios, int numPasajeros, int numPuertas,
			String tipoCombustible) {
		this.id = id;
		this.modelo = modelo;
		this.tipoCambios = tipoCambios;
		this.numPasajeros = numPasajeros;
		this.numPuertas = numPuertas;
		this.tipoCombustible = tipoCombustible;
	}

	public CarroEntidadTestDataBuilder() {
		this.id = 1L;
		this.modelo = "2018";
		this.tipoCambios = "Manual";
		this.numPasajeros = 4;
		this.numPuertas = 4;
		this.tipoCombustible = "Gasolina";
	}
	
	public CarroEntidad build() {
		return new CarroEntidad(id, numPuertas, modelo, numPasajeros, tipoCombustible, tipoCambios);
	}
	
	public CarroEntidadTestDataBuilder conId(long id) {
		this.id = id;
		return this;
	}
	
	public CarroEntidadTestDataBuilder conModelo(String modelo) {
		this.modelo = modelo;
		return this;
	}
	
	public CarroEntidadTestDataBuilder conTipoCambios(String tipoCambios) {
		this.tipoCambios = tipoCambios;
		return this;
	}
	
	public CarroEntidadTestDataBuilder conNumPasajeros(int numPasajeros) {
		this.numPasajeros = numPasajeros;
		return this;
	}
	
	public CarroEntidadTestDataBuilder conNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
		return this;
	}
	
	public CarroEntidadTestDataBuilder conTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
		return this;
	}
}
