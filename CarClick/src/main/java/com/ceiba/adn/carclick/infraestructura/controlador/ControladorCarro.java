package com.ceiba.adn.carclick.infraestructura.controlador;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.adn.carclick.aplicacion.dto.CarroDTO;
import com.ceiba.adn.carclick.aplicacion.manejador.ManejadorCrearCarro;
import com.ceiba.adn.carclick.aplicacion.manejador.ManejadorListarCarro;
import com.ceiba.adn.carclick.dominio.modelo.Carro;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api/carro")
@Api(tags = "carro")
public class ControladorCarro {

	private final ManejadorCrearCarro manejadorCrearCarro;
	private final ManejadorListarCarro manejadorListarCarro;
	
	public ControladorCarro(ManejadorCrearCarro manejadorCrearCarro, ManejadorListarCarro manejadorListarCarro) {
		this.manejadorCrearCarro = manejadorCrearCarro;
		this.manejadorListarCarro = manejadorListarCarro;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Carro", notes = "Servicio para Crear un Carro")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Carro Creado Exitosamente"),
			@ApiResponse(code = 400, message = "Solicitud invalida") })
	public ResponseEntity<HttpStatus> crearCarro(@RequestBody CarroDTO carroDTO) {
		this.manejadorCrearCarro.ejecutar(carroDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Carro>> consultarCarros() {
		return new ResponseEntity<>(this.manejadorListarCarro.ejecutar(), HttpStatus.OK);
	}
}
