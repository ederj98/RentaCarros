package com.ceiba.adn.carclick.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.CarroEntidad;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.ClienteEntidad;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.ReservaEntidad;

public class ReservaEntidadTestDataBuilder {

	public long id;
	public ClienteEntidad idCliente;
	private CarroEntidad idCarro;
	public LocalDateTime fechaRecogida;

	public ReservaEntidadTestDataBuilder(long id, ClienteEntidad idCliente, CarroEntidad idCarro,
			LocalDateTime fechaRecogida) {
		this.id = id;
		this.idCliente = idCliente;
		this.idCarro = idCarro;
		this.fechaRecogida = fechaRecogida;
	}

	public ReservaEntidadTestDataBuilder() {
		this.id = 1L;
		this.idCliente = new ClienteEntidadTestDataBuilder().build();
		this.idCarro = new CarroEntidadTestDataBuilder().build();
		this.fechaRecogida = LocalDateTime.of(2020, 9, 10, 9, 0);
	}
	
	public ReservaEntidadTestDataBuilder conId(long id) {
		this.id = id;
		return this;
	}
	
	public ReservaEntidadTestDataBuilder conIdCliente(long idCliente) {
		ClienteEntidad cliente = new ClienteEntidadTestDataBuilder().conIdCliente(idCliente).build();
		this.idCliente = cliente;
		return this;
	}
	
	public ReservaEntidadTestDataBuilder conIdCarro(long idCarro) {
		CarroEntidad carro = new CarroEntidadTestDataBuilder().conId(idCarro).build();
		this.idCarro = carro;
		return this;
	}
	
	public ReservaEntidadTestDataBuilder conFechaRecogida(LocalDateTime fechaRecogida) {
		this.fechaRecogida = fechaRecogida;
		return this;
	}
	
	public ReservaEntidad build() {
		return new ReservaEntidad(id, idCliente, idCarro, fechaRecogida);
	}
}
