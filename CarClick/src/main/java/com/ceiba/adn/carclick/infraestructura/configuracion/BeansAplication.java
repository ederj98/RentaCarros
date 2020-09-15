package com.ceiba.adn.carclick.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.adn.carclick.aplicacion.manejador.ManejadorCrearCliente;
import com.ceiba.adn.carclick.aplicacion.manejador.ManejadorCrearDetalleReserva;
import com.ceiba.adn.carclick.aplicacion.manejador.ManejadorCrearReserva;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCliente;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioDetalleReserva;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioReserva;
import com.ceiba.adn.carclick.dominio.servicio.ServicioCrearCliente;
import com.ceiba.adn.carclick.dominio.servicio.ServicioCrearDetalleReserva;
import com.ceiba.adn.carclick.dominio.servicio.ServicioCrearReserva;

@Configuration
public class BeansAplication {

	@Bean
	public ManejadorCrearCliente manejadorCrearCliente(final ServicioCrearCliente servicioCrearCliente) {
		return new ManejadorCrearCliente(servicioCrearCliente);
	}
	
	@Bean
	public ServicioCrearCliente servicioCrearCliente(final RepositorioCliente repositorioCliente) {
		return new ServicioCrearCliente(repositorioCliente);
	}
	
	@Bean
	public ManejadorCrearReserva manejadorCrearReserva(final ServicioCrearReserva servicioCrearReserva) {
		return new ManejadorCrearReserva(servicioCrearReserva);
	}
	
	@Bean
	public ServicioCrearReserva servicioCrearReserva(final RepositorioReserva repositorioReserva, final RepositorioCliente repositorioCliente) {
		return new ServicioCrearReserva(repositorioReserva, repositorioCliente);
	}
	
	@Bean
	public ManejadorCrearDetalleReserva manejadorCrearDetalleReserva(final ServicioCrearDetalleReserva servicioCrearDetalleReserva) {
		return new ManejadorCrearDetalleReserva(servicioCrearDetalleReserva);
	}
	
	@Bean
	public ServicioCrearDetalleReserva servicioCrearDetalleReserva(final RepositorioDetalleReserva repositorioDetalleReserva, final RepositorioReserva repositorioReserva) {
		return new ServicioCrearDetalleReserva(repositorioDetalleReserva, repositorioReserva);
	}
}
