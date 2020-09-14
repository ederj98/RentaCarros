package com.ceiba.adn.carclick.dominio.excepcion;

public class ExcepcionFechaFueraHorarioServicio extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionFechaFueraHorarioServicio(String message) {
        super(message);
    }
}
