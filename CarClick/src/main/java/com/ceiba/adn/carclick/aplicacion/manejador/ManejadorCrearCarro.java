package com.ceiba.adn.carclick.aplicacion.manejador;

import org.springframework.transaction.annotation.Transactional;

import com.ceiba.adn.carclick.aplicacion.dto.CarroDTO;
import com.ceiba.adn.carclick.aplicacion.mapeador.MapeadorCarro;
import com.ceiba.adn.carclick.dominio.modelo.Carro;
import com.ceiba.adn.carclick.dominio.servicio.ServicioCrearCarro;

public class ManejadorCrearCarro {

	private final ServicioCrearCarro servicioCrearCarro;
	
	public ManejadorCrearCarro(ServicioCrearCarro servicioCrearCarro) {
		this.servicioCrearCarro = servicioCrearCarro;
	}
	
	/**
	 * Metodo encargado de la operacion de crear un Carro
	 * @param clienteDTO
	 * @return
	 */
	@Transactional
	public void ejecutar(CarroDTO carroDTO) {
		Carro carro = MapeadorCarro.mapearAModelo(carroDTO);
		this.servicioCrearCarro.ejecutar(carro);
	}
}
