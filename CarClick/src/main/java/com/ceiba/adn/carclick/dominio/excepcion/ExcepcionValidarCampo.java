package com.ceiba.adn.carclick.dominio.excepcion;

public class ExcepcionValidarCampo extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionValidarCampo(String message) {
        super(message);
    }
}
