package com.ceiba.adn.carclick.infraestructura.controlador.excepcion;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionClienteNoRegistrado;
import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionFechaFueraHorarioServicio;
import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionReservaNoRegistrada;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	private static final Logger LOG = LogManager.getLogger(ExceptionHandler.class);
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ExcepcionFechaFueraHorarioServicio.class)
	public void excepcionFechaFueraHorarioServicio(HttpServletResponse response) throws IOException {
		LOG.warn("-- ServicioCrearServicio.crearServicio - El Horario de servicio es de 8 A.M a 8 P.M --");
		response.sendError(HttpStatus.PRECONDITION_FAILED.value());
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ExcepcionClienteNoRegistrado.class)
	public void excepcionClienteNoRegistrado(HttpServletResponse response) throws IOException {
		LOG.warn("-- ServicioCrearReserva.crearReserva - El cliente ingresado no se encuentra registrado --");
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ExcepcionDuplicidad.class)
	public void excepcionClienteYaRegistrado(HttpServletResponse response) throws IOException {
		LOG.warn("-- ServicioCrearCliente.crearCliente - El id ingresado ya se encuentra registrado --");
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ExcepcionReservaNoRegistrada.class)
	public void excepcionReservaNoRegistrado(HttpServletResponse response) throws IOException {
		LOG.warn("-- ServicioCrearDetalleReserva.crearDetalleReserva - La Reserva ingresada no se encuentra registrada --");
		response.sendError(HttpStatus.PRECONDITION_FAILED.value());
	}
}
