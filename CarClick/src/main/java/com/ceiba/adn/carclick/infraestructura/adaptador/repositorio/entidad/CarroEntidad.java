package com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Getter
@Table(name = "CARRO")
public class CarroEntidad {
	
	public CarroEntidad(long id, int numPuertas, String modelo, int numPasajeros, String tipoCombustible, String tipoCambios) {
		this.id = id;
		this.numPuertas = numPuertas;
		this.modelo = modelo;
		this.numPasajeros = numPasajeros;
		this.tipoCombustible = tipoCombustible;
		this.tipoCambios = tipoCambios;
	}

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
	
	public void setId(long id) {
		this.id = id;
	}

	public CarroEntidad() {}
}