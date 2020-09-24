package com.ceiba.adn.carclick.dominio.modelo;

import com.ceiba.adn.carclick.dominio.servicio.ValidarCampos;

public class Carro {

	private static final String EL_MODELO_DEL_VEHICULO_ES_REQUERIDO = "El modelo del vehiculo es requerido";
	private static final String EL_TIPO_DE_CAMBIOS_DEL_VEHICULO_ES_REQUERIDO = "El tipo de cambios del vehiculo es requerido";
	private static final String EL_NUMERO_DE_PASAJEROS_QUE_PERMITE_EL_VEHICULO_ES_REQUERIDO = "El numero de pasajeros que permite el vehiculo es requerido";
	private static final String EL_NUMERO_DE_PUERTAS_QUE_TIENE_EL_VEHICULO_ES_REQUERIDO = "El numero de puertas que tiene el vehiculo es requerido";
	private static final String EL_TIPO_DE_COMBUSTIBLE_QUE_USA_EL_VEHICULO_ES_REQUERIDO = "El tipo de combustible que usa el vehiculo es requerido";
	
	private long id;
	private String modelo;
	private String tipoCambios;
	private int numPasajeros;
	private int numPuertas;
	private String tipoCombustible;
	
	public Carro(long id, String modelo, String tipoCambios, int numPasajeros, int numPuertas, String tipoCombustible) {
		ValidarCampos.esVacio(modelo, EL_MODELO_DEL_VEHICULO_ES_REQUERIDO);
		ValidarCampos.esVacio(tipoCambios, EL_TIPO_DE_CAMBIOS_DEL_VEHICULO_ES_REQUERIDO);
		ValidarCampos.esVacio(numPasajeros, EL_NUMERO_DE_PASAJEROS_QUE_PERMITE_EL_VEHICULO_ES_REQUERIDO);
		ValidarCampos.esVacio(numPuertas, EL_NUMERO_DE_PUERTAS_QUE_TIENE_EL_VEHICULO_ES_REQUERIDO);
		ValidarCampos.esVacio(tipoCombustible, EL_TIPO_DE_COMBUSTIBLE_QUE_USA_EL_VEHICULO_ES_REQUERIDO);
		
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
