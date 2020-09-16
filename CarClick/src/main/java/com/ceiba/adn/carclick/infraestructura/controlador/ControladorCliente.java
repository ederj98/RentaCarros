package com.ceiba.adn.carclick.infraestructura.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.adn.carclick.aplicacion.dto.ClienteDTO;
import com.ceiba.adn.carclick.aplicacion.manejador.ManejadorCrearCliente;
import com.ceiba.adn.carclick.aplicacion.manejador.ManejadorListarCliente;
import com.ceiba.adn.carclick.dominio.modelo.Cliente;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api/cliente")
@Api(tags = "cliente")
public class ControladorCliente {

	private final ManejadorCrearCliente manejadorCrearCliente;
	private final ManejadorListarCliente manejadorListarCliente;
	
	public ControladorCliente(ManejadorCrearCliente manejadorCrearCliente, ManejadorListarCliente manejadorListarCliente) {
		this.manejadorCrearCliente = manejadorCrearCliente;
		this.manejadorListarCliente = manejadorListarCliente;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Cliente", notes = "Servicio para Crear un Cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente Creado Exitosamente"),
			@ApiResponse(code = 400, message = "Solicitud invalida") })
	public ResponseEntity<Cliente> crearCliente(@RequestBody ClienteDTO clienteDTO) {
		return new ResponseEntity<>(this.manejadorCrearCliente.ejecutar(clienteDTO), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> consultarCliente(@PathVariable("id") long idCliente) {
	    return new ResponseEntity<>(this.manejadorListarCliente.ejecutar(idCliente), HttpStatus.OK);	    
	 }
}
