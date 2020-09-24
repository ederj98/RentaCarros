package com.ceiba.adn.carclick.infraestructura.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.adn.carclick.aplicacion.dto.DetalleReservaDTO;
import com.ceiba.adn.carclick.aplicacion.manejador.ManejadorCrearDetalleReserva;
import com.ceiba.adn.carclick.aplicacion.manejador.ManejadorListarDetalleReserva;
import com.ceiba.adn.carclick.dominio.modelo.DetalleReserva;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api/detalleReserva")
@Api(tags = "detalleReserva")
public class ControladorDetalleReserva {

	private final ManejadorCrearDetalleReserva manejadorCrearDetalleReserva;
	private final ManejadorListarDetalleReserva manejadorListarDetalleReserva;
	
	public ControladorDetalleReserva(ManejadorCrearDetalleReserva manejadorCrearDetalleReserva,
			ManejadorListarDetalleReserva manejadorListarDetalleReserva) {
		this.manejadorCrearDetalleReserva = manejadorCrearDetalleReserva;
		this.manejadorListarDetalleReserva = manejadorListarDetalleReserva;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Detalle Reserva", notes = "Servicio para Crear un Detalle Reserva")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Detalle Reserva Creado Exitosamente"),
			@ApiResponse(code = 400, message = "Solicitud invalida") })
	public ResponseEntity<DetalleReserva> crearDetalleReserva(@RequestBody DetalleReservaDTO detalleReservaDTO) {
		return new ResponseEntity<>(this.manejadorCrearDetalleReserva.ejecutar(detalleReservaDTO), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalleReserva> consultarDetalleReserva(@PathVariable("id") long idReserva) {
	    return new ResponseEntity<>(this.manejadorListarDetalleReserva.ejecutar(idReserva), HttpStatus.OK);	    
	}
}
