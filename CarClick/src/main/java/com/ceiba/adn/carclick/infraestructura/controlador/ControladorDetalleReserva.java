package com.ceiba.adn.carclick.infraestructura.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.adn.carclick.aplicacion.dto.DetalleReservaDTO;
import com.ceiba.adn.carclick.aplicacion.manejador.ManejadorCrearDetalleReserva;
import com.ceiba.adn.carclick.dominio.modelo.DetalleReserva;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/detalleReserva")
@Api(tags = "detalleReserva")
public class ControladorDetalleReserva {

	private final ManejadorCrearDetalleReserva servicioDetalleReserva;
	
	public ControladorDetalleReserva(ManejadorCrearDetalleReserva servicioDetalleReserva) {
		this.servicioDetalleReserva = servicioDetalleReserva;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Detalle Reserva", notes = "Servicio para Crear un Detalle Reserva")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Detalle Reserva Creado Exitosamente"),
			@ApiResponse(code = 400, message = "Solicitud invalida") })
	public ResponseEntity<DetalleReserva> crearDetalleCarrera(@RequestBody DetalleReservaDTO detalleReservaDTO) {
		return new ResponseEntity<>(this.servicioDetalleReserva.ejecutar(detalleReservaDTO), HttpStatus.CREATED);
	}
}
