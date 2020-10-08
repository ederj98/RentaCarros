package com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Getter
@Table(name = "CLIENTE")
public class ClienteEntidad {

	@Id
	@Column(name = "ID")
	private long idCliente;
	
	@Column(name = "NOMBRE_COMPLETO")
	private String nombreCompleto;
	
	@Column(name = "TELEFONO")
	private String telefono;
	
	@Column(name = "DIRECCION")
	private String direccion;
	
	@Column(name = "EMAIL")
	private String email;
	
	public ClienteEntidad() {}
	
	public ClienteEntidad(long idCliente, String nombreCompleto, String telefono, String direccion, String email) {
		this.idCliente = idCliente;
		this.nombreCompleto = nombreCompleto;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
	}
	
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
}