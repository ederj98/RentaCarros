package com.ceiba.adn.carclick.aplicacion.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CarroDTO {

	private long id;
	private String modelo;
	private String tipoCambios;
	private int numPasajeros;
	private int numPuertas;
	private String tipoCombustible;

	@JsonCreator
	public CarroDTO(@JsonProperty("id") long id, @JsonProperty("modelo") String modelo, 
			@JsonProperty("tipoCambios") String tipoCambios, @JsonProperty("numPasajeros") int numPasajeros, 
			@JsonProperty("numPuertas") int numPuertas, @JsonProperty("tipoCombustible") String tipoCombustible) {
		this.id = id;
		this.modelo = modelo;
		this.tipoCambios = tipoCambios;
		this.numPasajeros = numPasajeros;
		this.numPuertas = numPuertas;
		this.tipoCombustible = tipoCombustible;
	}
	
	public long getId() {
		return id;
	}

	public String getModelo() {
		return modelo;
	}

	public String getTipoCambios() {
		return tipoCambios;
	}

	public int getNumPasajeros() {
		return numPasajeros;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public String getTipoCombustible() {
		return tipoCombustible;
	}
}
