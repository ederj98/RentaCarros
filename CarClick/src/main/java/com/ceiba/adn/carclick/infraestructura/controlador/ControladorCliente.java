package com.ceiba.adn.carclick.infraestructura.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.adn.carclick.aplicacion.dto.ClienteDTO;
import com.ceiba.adn.carclick.aplicacion.manejador.ManejadorCrearCliente;
import com.ceiba.adn.carclick.dominio.modelo.Cliente;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/cliente")
@Api(tags = "cliente")
public class ControladorCliente {

	private final ManejadorCrearCliente servicioCrearCliente;
	
	public ControladorCliente(ManejadorCrearCliente servicioCliente) {
		this.servicioCrearCliente = servicioCliente;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Cliente", notes = "Servicio para Crear un Cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente Creado Exitosamente"),
			@ApiResponse(code = 400, message = "Solicitud invalida") })
	public ResponseEntity<Cliente> crearCliente(@RequestBody ClienteDTO clienteDTO) {
		return new ResponseEntity<>(this.servicioCrearCliente.ejecutar(clienteDTO), HttpStatus.CREATED);
	}
}
