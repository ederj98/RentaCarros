package com.ceiba.adn.carclick.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionValidarCampo;

public class ValidarCamposTest {

	private static final String DEBE_INGRESAR_LOS_CAMPOS_REQUERIDOS = "Debe ingresar los campos requeridos";
	
	@Test
	public void cuandoCampoVacioEntoncesDeberiaLanzarExcepcion() {
		// arrange
		String campoVacio = null;

		// act / assert
		assertThrows(ExcepcionValidarCampo.class, 
						() ->  ValidarCampos.esVacio(campoVacio), 
						DEBE_INGRESAR_LOS_CAMPOS_REQUERIDOS);	    
	}
}
