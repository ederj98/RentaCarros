package com.ceiba.adn.carclick.dominio.excepcion;

public class ExcepcionCarroNoRegistrado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionCarroNoRegistrado(String message) {
        super(message);
    }
}
