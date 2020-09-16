package com.ceiba.adn.carclick.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.adn.carclick.aplicacion.manejador.ManejadorActualizarReserva;
import com.ceiba.adn.carclick.aplicacion.manejador.ManejadorCrearCarro;
import com.ceiba.adn.carclick.aplicacion.manejador.ManejadorCrearCliente;
import com.ceiba.adn.carclick.aplicacion.manejador.ManejadorCrearDetalleReserva;
import com.ceiba.adn.carclick.aplicacion.manejador.ManejadorCrearReserva;
import com.ceiba.adn.carclick.aplicacion.manejador.ManejadorListarCarro;
import com.ceiba.adn.carclick.aplicacion.manejador.ManejadorListarCliente;
import com.ceiba.adn.carclick.aplicacion.manejador.ManejadorListarReserva;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCarro;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCliente;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioDetalleReserva;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioReserva;
import com.ceiba.adn.carclick.dominio.servicio.ServicioActualizarReserva;
import com.ceiba.adn.carclick.dominio.servicio.ServicioCrearCarro;
import com.ceiba.adn.carclick.dominio.servicio.ServicioCrearCliente;
import com.ceiba.adn.carclick.dominio.servicio.ServicioCrearDetalleReserva;
import com.ceiba.adn.carclick.dominio.servicio.ServicioCrearReserva;
import com.ceiba.adn.carclick.dominio.servicio.ServicioListarCarros;
import com.ceiba.adn.carclick.dominio.servicio.ServicioListarCliente;
import com.ceiba.adn.carclick.dominio.servicio.ServicioListarReservas;

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
	public ManejadorListarCliente manejadorListarCliente(final ServicioListarCliente servicioListarCliente) {
		return new ManejadorListarCliente(servicioListarCliente);
	}
	
	@Bean
	public ServicioListarCliente servicioListarCliente(final RepositorioCliente repositorioCliente) {
		return new ServicioListarCliente(repositorioCliente);
	}
	
	@Bean
	public ManejadorCrearReserva manejadorCrearReserva(final ServicioCrearReserva servicioCrearReserva) {
		return new ManejadorCrearReserva(servicioCrearReserva);
	}
	
	@Bean
	public ServicioCrearReserva servicioCrearReserva(final RepositorioReserva repositorioReserva, final RepositorioCliente repositorioCliente,
			RepositorioCarro repositorioCarro) {
		return new ServicioCrearReserva(repositorioReserva, repositorioCliente, repositorioCarro);
	}
	
	@Bean
	public ManejadorListarReserva manejadorListarReserva(final ServicioListarReservas servicioListarReserva) {
		return new ManejadorListarReserva(servicioListarReserva);
	}
	
	@Bean
	public ServicioListarReservas servicioListarReserva(final RepositorioReserva repositorioReserva) {
		return new ServicioListarReservas(repositorioReserva);
	}
	
	@Bean
	public ManejadorActualizarReserva manejadorActualizarReserva(final ServicioActualizarReserva servicioActualizarReserva) {
		return new ManejadorActualizarReserva(servicioActualizarReserva);
	}
	
	@Bean
	public ServicioActualizarReserva servicioActualizarReserva(final RepositorioReserva repositorioReserva, final RepositorioCarro repositorioCarro,
			final RepositorioCliente repositorioCliente) {
		return new ServicioActualizarReserva(repositorioReserva, repositorioCarro, repositorioCliente);	
	}
	
	@Bean
	public ManejadorCrearDetalleReserva manejadorCrearDetalleReserva(final ServicioCrearDetalleReserva servicioCrearDetalleReserva) {
		return new ManejadorCrearDetalleReserva(servicioCrearDetalleReserva);
	}
	
	@Bean
	public ServicioCrearDetalleReserva servicioCrearDetalleReserva(final RepositorioDetalleReserva repositorioDetalleReserva, final RepositorioReserva repositorioReserva) {
		return new ServicioCrearDetalleReserva(repositorioDetalleReserva, repositorioReserva);
	}
	
	@Bean
	public ManejadorCrearCarro manejadorCrearCarro(final ServicioCrearCarro servicioCrearCarro) {
		return new ManejadorCrearCarro(servicioCrearCarro);
	}
	
	@Bean
	public ServicioCrearCarro servicioCrearCarro(final RepositorioCarro repositorioCarro) {
		return new ServicioCrearCarro(repositorioCarro);
	}
	
	@Bean
	public ManejadorListarCarro manejadorListarCarro(final ServicioListarCarros servicioListarCarro) {
		return new ManejadorListarCarro(servicioListarCarro);
	}
	
	@Bean
	public ServicioListarCarros servicioListarCarros(final RepositorioCarro repositorioCarro) {
		return new ServicioListarCarros(repositorioCarro);
	}
}
