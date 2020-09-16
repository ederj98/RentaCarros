package com.ceiba.adn.carclick.aplicacion.manejador;

import java.util.List;

import com.ceiba.adn.carclick.dominio.modelo.Carro;
import com.ceiba.adn.carclick.dominio.servicio.ServicioListarCarros;

public class ManejadorListarCarro {

	private final ServicioListarCarros servicioListarCarros;
	
	public ManejadorListarCarro(ServicioListarCarros servicioListarCarros) {
		this.servicioListarCarros = servicioListarCarros;
	}
	
	public List<Carro> ejecutar() {
		return servicioListarCarros.listar();
	}
}
