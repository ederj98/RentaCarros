package com.ceiba.adn.carclick.infraestructura.controlador;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.adn.carclick.aplicacion.dto.ReservaDTO;
import com.ceiba.adn.carclick.aplicacion.manejador.ManejadorActualizarReserva;
import com.ceiba.adn.carclick.aplicacion.manejador.ManejadorCrearReserva;
import com.ceiba.adn.carclick.aplicacion.manejador.ManejadorListarReserva;
import com.ceiba.adn.carclick.dominio.modelo.Reserva;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api/reserva")
@Api(tags = "reserva")
public class ControladorReserva {
	
	private final ManejadorCrearReserva manejadorCrearReserva;
	private final ManejadorListarReserva manejadorListarReserva;
	private final ManejadorActualizarReserva manejadorActualizarReserva;
	
	public ControladorReserva(ManejadorCrearReserva manejadorCrearReserva, ManejadorListarReserva manejadorListarReserva,
			ManejadorActualizarReserva manejadorActualizarReserva) {
		this.manejadorCrearReserva = manejadorCrearReserva;
		this.manejadorListarReserva = manejadorListarReserva;
		this.manejadorActualizarReserva = manejadorActualizarReserva;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Reserva", notes = "Servicio para Crear una Reserva")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reserva Creada Exitosamente"),
			@ApiResponse(code = 400, message = "Solicitud invalida") })
	public ResponseEntity<HttpStatus> crearReserva(@RequestBody ReservaDTO reservaDTO) {
		this.manejadorCrearReserva.ejecutar(reservaDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Reserva> consultarReserva(@PathVariable("id") long idReserva) {
	    return new ResponseEntity<>(this.manejadorListarReserva.ejecutar(idReserva), HttpStatus.OK);	    
	 }
	
	@GetMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Reserva>> consultarReservas() {
		return new ResponseEntity<>(this.manejadorListarReserva.ejecutar(), HttpStatus.OK);
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar Reserva", notes = "Servicio para Actualizar una Reserva")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reserva Actualizada Exitosamente"),
			@ApiResponse(code = 400, message = "Solicitud invalida") })
	public ResponseEntity<HttpStatus> actualizarReserva(@RequestBody ReservaDTO reservaDTO) {
		this.manejadorActualizarReserva.ejecutar(reservaDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
