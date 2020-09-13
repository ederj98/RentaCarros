package com.ceiba.adn.carclick.dominio.modelo;

public class Carro {
	
	private long id;
	private String modelo;
	private String tipoCambios;
	private int numPasajeros;
	private int numPuertas;
	private String tipoCombustible;
	
	public Carro(long id, String modelo, String tipoCambios, int numPasajeros, int numPuertas, String tipoCombustible) {
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

	public void setId(long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipoCambios() {
		return tipoCambios;
	}

	public void setTipoCambios(String tipoCambios) {
		this.tipoCambios = tipoCambios;
	}

	public int getNumPasajeros() {
		return numPasajeros;
	}

	public void setNumPasajeros(int numPasajeros) {
		this.numPasajeros = numPasajeros;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public String getTipoCombustible() {
		return tipoCombustible;
	}

	public void setTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}
}
