package com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARRO")
public class CarroEntidad {
		
	public CarroEntidad() {}
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	
	@Column(name = "MODELO")
	private String modelo;
	
	@Column(name = "TIPO_CAMBIOS")
	private String tipoCambios;
	
	@Column(name = "NUM_PASAJEROS")
	private int numPasajeros;
	
	@Column(name = "NUM_PUERTAS")
	private int numPuertas;
	
	@Column(name = "TIPO_COMBUSTIBLE")
	private String tipoCombustible;
	
	public CarroEntidad(long id, String modelo, String tipoCambios, int numPasajeros, int numPuertas, String tipoCombustible) {
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