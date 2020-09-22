package com.ceiba.adn.carclick.dominio.excepcion;

public class ExcepcionFechaRecogidaAnteriorAFechaActual extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionFechaRecogidaAnteriorAFechaActual(String message) {
        super(message);
    }
}
