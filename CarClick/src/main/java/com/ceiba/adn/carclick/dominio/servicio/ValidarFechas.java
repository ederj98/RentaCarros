package com.ceiba.adn.carclick.dominio.servicio;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionFechaEntregaMenorFechaRecogida;
import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionFechaFueraHorarioServicio;
import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionFechaRecogidaAnteriorAFechaActual;

public final class ValidarFechas {

	private static final String ESTA_CLASE_NO_DEBE_SER_INSTANCIADA = "Esta clase no debe ser instanciada";
	private static final LocalTime HORA_INICIAL_SERVICIO = LocalTime.of(8, 0);
	private static final LocalTime HORA_FINAL_SERVICIO = LocalTime.of(20, 0);
	private static final String EL_HORARIO_DE_SERVICIO_ES_DE_8_AM_A_8_PM = "El Horario de servicio es de 8 A.M a 8 P.M";
	private static final String LA_FECHA_DE_ENTREGA_DEL_VEHICULO_NO_PUEDE_SER_MENOR_A_LA_FECHA_DE_RECOGIDA = "La fecha de entrega del vehiculo no puede ser menor a la fecha de recogida";
	private static final String LA_FECHA_DE_RECOGIDA_DEL_VEHICULO_NO_PUEDE_SER_MENOR_A_LA_FECHA_ACTUAL = "La fecha de recogida del vehiculo no puede ser menor a la fecha actual";
	
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
	
	/**
	 * Metodo encargado de validar que la fecha de Entrega sea posterior a la fecha de recogida
	 * 
	 * @param fechaRecogida
	 * @param fechaEntrega
	 */
	public static void validarFechaRecogidaAnteriorAFechaEntrega(LocalDateTime fechaRecogida, LocalDateTime fechaEntrega){	
		if (!fechaEntrega.isAfter(fechaRecogida)) {
			throw new ExcepcionFechaEntregaMenorFechaRecogida(LA_FECHA_DE_ENTREGA_DEL_VEHICULO_NO_PUEDE_SER_MENOR_A_LA_FECHA_DE_RECOGIDA);
		}
	}
	
	/**
	 * Metodo encargado de validar que la fecha de recogida no sea anterior a la fecha actual
	 * 
	 * @param fechaRecogida
	 * @param fechaEntrega
	 */
	public static void validarFechaRecogidaPosteriorAFechaActual(LocalDateTime fechaRecogida, LocalDateTime fechaActual){	
		if (!fechaRecogida.isAfter(fechaActual)) {
			throw new ExcepcionFechaRecogidaAnteriorAFechaActual(LA_FECHA_DE_RECOGIDA_DEL_VEHICULO_NO_PUEDE_SER_MENOR_A_LA_FECHA_ACTUAL);
		}
	}
}
