package com.ceiba.adn.carclick.dominio.excepcion;

public class ExcepcionClienteNoRegistrado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionClienteNoRegistrado(String message) {
        super(message);
    }
}
