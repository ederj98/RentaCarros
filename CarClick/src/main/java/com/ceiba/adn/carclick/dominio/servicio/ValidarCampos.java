package com.ceiba.adn.carclick.dominio.servicio;

import java.util.Objects;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionValidarCampo;

public final class ValidarCampos {

	private static final String ESTA_CLASE_NO_DEBE_SER_INSTANCIADA = "Esta clase no debe ser instanciada";
	
	private ValidarCampos() {
		throw new AssertionError(ESTA_CLASE_NO_DEBE_SER_INSTANCIADA);
	}
	
	/**
	 * Metodo encargado de validar si el campo suministrado esta vacio
	 * @param campo
	 */
	public static void esVacio(Object campo, String mensaje) {
		if (Objects.isNull(campo)) {
			throw new ExcepcionValidarCampo(mensaje);
		}
	}
}
