package com.ceiba.adn.carclick.dominio.excepcion;

public class ExcepcionFechaEntregaMenorFechaRecogida extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionFechaEntregaMenorFechaRecogida(String message) {
        super(message);
    }
}
