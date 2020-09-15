package com.ceiba.adn.carclick.infraestructura.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.adn.carclick.aplicacion.dto.ReservaDTO;
import com.ceiba.adn.carclick.aplicacion.manejador.ManejadorCrearReserva;
import com.ceiba.adn.carclick.dominio.modelo.Reserva;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/reserva")
@Api(tags = "reserva")
public class ControladorReserva {
	
	private final ManejadorCrearReserva servicioReserva;
	
	public ControladorReserva(ManejadorCrearReserva servicioReserva) {
		this.servicioReserva = servicioReserva;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Reserva", notes = "Servicio para Crear una Reserva")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reserva Creada Exitosamente"),
			@ApiResponse(code = 400, message = "Solicitud invalida") })
	public ResponseEntity<Reserva> crearReserva(@RequestBody ReservaDTO reservaDTO) {
		return new ResponseEntity<>(this.servicioReserva.ejecutar(reservaDTO), HttpStatus.CREATED);
	}
}
