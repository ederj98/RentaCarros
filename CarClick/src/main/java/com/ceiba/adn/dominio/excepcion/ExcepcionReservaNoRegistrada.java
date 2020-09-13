package com.ceiba.adn.dominio.excepcion;

public class ExcepcionReservaNoRegistrada extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionReservaNoRegistrada(String message) {
        super(message);
    }
}
