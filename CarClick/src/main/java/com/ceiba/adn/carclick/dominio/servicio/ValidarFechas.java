package com.ceiba.adn.carclick.dominio.servicio;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionFechaFueraHorarioServicio;

public final class ValidarFechas {

	private static final String ESTA_CLASE_NO_DEBE_SER_INSTANCIADA = "Esta clase no debe ser instanciada";
	private static final LocalTime HORA_INICIAL_SERVICIO = LocalTime.of(8, 0);
	private static final LocalTime HORA_FINAL_SERVICIO = LocalTime.of(20, 0);
	private static final String EL_HORARIO_DE_SERVICIO_ES_DE_8_AM_A_8_PM = "El Horario de servicio es de 8 A.M a 8 P.M";

	private ValidarFechas() {
		throw new AssertionError(ESTA_CLASE_NO_DEBE_SER_INSTANCIADA);
	}
	
	/**
	 * Metodo encargado de validar si la fecha de recogida/entrega se encuentra dentro del
	 * horario de servicio que corresponde de 8 A.M a 8 P.M
	 * @param fecha
	 */
	public static void validarFechaFueraHorarioServicio(LocalDateTime fecha){	
		if (fecha.toLocalTime().isBefore(HORA_INICIAL_SERVICIO) || 
				fecha.toLocalTime().isAfter(HORA_FINAL_SERVICIO)) {
			throw new ExcepcionFechaFueraHorarioServicio(EL_HORARIO_DE_SERVICIO_ES_DE_8_AM_A_8_PM);
		}
	}
}
