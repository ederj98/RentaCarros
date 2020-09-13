package com.ceiba.adn.dominio.servicio;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.ceiba.adn.dominio.modelo.Reserva;

public final class Alquiler {
	
	private static final String ESTA_CLASE_NO_DEBE_SER_INSTANCIADA = "Esta clase no debe ser instanciada";
	private static final int TARIFA_ESTANDAR_POR_HORA = 15000;
	private static final int PORCENTAJE_RECARGO_NOCTURNO = 5;
	private static final int PORCENTAJE_RECARGO_TARIFA_FINES_DE_SEMANA = 10;
	private static final int NUM_HORAS_DIA = 24;
	private static final int NUM_HORAS_MAX_RECARGO_NOCTURNO = 11;
	private static final long NUM_DIAS_CALCULO_ESPECIFICO = 2;
	private static final int CERO = 0;

	private Alquiler() {
		throw new AssertionError(ESTA_CLASE_NO_DEBE_SER_INSTANCIADA);
	}
	
	/**
	 * Metodo encargada de calcular el costo de una reserva
	 * @param reserva
	 * @param fechaEntrega
	 * @return BigDecimal correspondiente al costo de una reserva de acuerdo a las reglas de negocio
	 */
	public static BigDecimal calcularCosto(Reserva reserva, LocalDateTime  fechaEntrega) {
		
		BigDecimal costoReserva;
		
		long diasReserva = Duration.between(reserva.getFechaRecogida(), fechaEntrega).toDays();
		LocalDateTime contadorFecha = reserva.getFechaRecogida();
		int contadorFinSemana = 0;
		
		
			long totalHoras = Duration.between(reserva.getFechaRecogida(), fechaEntrega).toHours();
			long horas = totalHoras;
			if (esEntregaMismoDia(reserva.getFechaRecogida().toLocalDate(), fechaEntrega.toLocalDate())) {
				costoReserva = calcularRecargoPorDia(reserva, fechaEntrega, horas);
			} else {
				horas = Duration.between(reserva.getFechaRecogida(), LocalTime.of(00, 00, 00)).toHours();
				costoReserva = calcularRecargoPorDia(reserva, reserva.getFechaRecogida(), horas);
			}
			
			int contDias = 2;
			while(contDias <= diasReserva) {
				if (contDias == diasReserva) {
					costoReserva = costoReserva.add(calcularRecargoPorDia(reserva, fechaEntrega, horas));
				} else if (esFinDeSemana(fechaEntrega)) {
					contadorFinSemana++;
					contadorFecha = contadorFecha.plusDays(1);
				}
				contDias++;
			}
			
			if (contadorFinSemana > CERO) {
				costoReserva = costoReserva.add(new BigDecimal((((contadorFinSemana * NUM_HORAS_DIA) * TARIFA_ESTANDAR_POR_HORA) * 
						(PORCENTAJE_RECARGO_TARIFA_FINES_DE_SEMANA / 100))));
			}
			long numDiasRecargoNocturno = diasReserva - NUM_DIAS_CALCULO_ESPECIFICO;
			if (numDiasRecargoNocturno > CERO) {
				costoReserva = costoReserva.add(new BigDecimal((((numDiasRecargoNocturno * NUM_HORAS_MAX_RECARGO_NOCTURNO) * TARIFA_ESTANDAR_POR_HORA) * 
						(PORCENTAJE_RECARGO_TARIFA_FINES_DE_SEMANA / 100))));
			}
		
			costoReserva = costoReserva.add(new BigDecimal(totalHoras * TARIFA_ESTANDAR_POR_HORA));
		
		return costoReserva;
	}
	
	/**
	 * Metodo encargado calcular los recargos aplicables al dia en especifico suministrado
	 * @param reserva
	 * @param fechaEntrega
	 * @param horas
	 * @return BigDecimal correspondiente al costo de los recargos para el dia suministrado
	 */
	private static BigDecimal calcularRecargoPorDia (Reserva reserva, LocalDateTime  fechaEntrega, long horas) {
		BigDecimal costoRecargos = null;
		if (esFinDeSemana(fechaEntrega)) {
			costoRecargos = new BigDecimal(((horas * TARIFA_ESTANDAR_POR_HORA) * (PORCENTAJE_RECARGO_TARIFA_FINES_DE_SEMANA / 100))); 
		} else {
			if (esRecargoNocturno(fechaEntrega)) {
				long horasNocturnas = esEntregaMismoDia(reserva.getFechaRecogida().toLocalDate(), fechaEntrega.toLocalDate()) ? 
						Duration.between(LocalTime.of(20, 00, 00), fechaEntrega).toHours() : 
							Duration.between(LocalTime.of(20, 00, 00), LocalTime.of(00, 00, 00)).toHours();
				costoRecargos = new BigDecimal(((horasNocturnas * TARIFA_ESTANDAR_POR_HORA) * (PORCENTAJE_RECARGO_NOCTURNO / 100)));
			}
		}
		return costoRecargos == null ? new BigDecimal(0) : costoRecargos;
	}
	
	/**
	 * Metodo encargado de validar si la entrega del carro se realizo el mismo dia que fue recogido
	 * @param fechaRecogida
	 * @param fechaEntrega
	 * @return boolean
	 */
	private static boolean esEntregaMismoDia(LocalDate  fechaRecogida, LocalDate  fechaEntrega) {
		return fechaRecogida == fechaEntrega;
	}
	
	/**
	 * Metodo encargado de validar si la fecha suministrada corresponde a un dia sabado o domingo
	 * @param fecha
	 * @return boolean
	 */
	private static boolean esFinDeSemana (LocalDateTime fecha) {
		return fecha.getDayOfWeek() == DayOfWeek.SATURDAY || fecha.getDayOfWeek() == DayOfWeek.SUNDAY;
	}
	
	/**
	 * Metodo encargado de validar si la fecha suministrada se encuentra en los rangos correspondientes
	 * a un recargo nocturno (entre las 20:00 - 7:00 horas)
	 * @param fechaEntrega
	 * @return boolean
	 */
	private static boolean esRecargoNocturno (LocalDateTime fechaEntrega) {
		return fechaEntrega.getHour() >= 20 || fechaEntrega.getHour() < 7;
	}
}