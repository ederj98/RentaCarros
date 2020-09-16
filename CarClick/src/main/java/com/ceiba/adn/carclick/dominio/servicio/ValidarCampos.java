package com.ceiba.adn.carclick.dominio.servicio;

import java.util.Objects;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionValidarCampo;

public final class ValidarCampos {

	private static final String ESTA_CLASE_NO_DEBE_SER_INSTANCIADA = "Esta clase no debe ser instanciada";
	private static final String DEBE_INGRESAR_LOS_CAMPOS_REQUERIDOS = "Debe ingresar los campos requeridos";
	
	private ValidarCampos() {
		throw new AssertionError(ESTA_CLASE_NO_DEBE_SER_INSTANCIADA);
	}
	
	/**
	 * Metodo encargado de validar si el campo suministrado esta vacio
	 * @param campo
	 */
	public static void esVacio(Object campo) {
		if (Objects.isNull(campo)) {
			throw new ExcepcionValidarCampo(DEBE_INGRESAR_LOS_CAMPOS_REQUERIDOS);
		}
	}
}
