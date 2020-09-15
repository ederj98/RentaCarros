package com.ceiba.adn.carclick.dominio.servicio;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.ceiba.adn.carclick.dominio.modelo.Reserva;

public final class Alquiler {
	
	private static final String ESTA_CLASE_NO_DEBE_SER_INSTANCIADA = "Esta clase no debe ser instanciada";
	private static final int TARIFA_ESTANDAR_POR_HORA = 15000;
	private static final double PORCENTAJE_RECARGO_NOCTURNO = 0.05;
	private static final double PORCENTAJE_RECARGO_TARIFA_FINES_DE_SEMANA = 0.1;
	private static final int NUM_HORAS_DIA = 24;
	private static final int NUM_HORAS_MAX_RECARGO_NOCTURNO = 11;
	private static final int NUM_DIAS_RECOGIDA_ENTREGA = 2;
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
		long totalHoras = Duration.between(reserva.getFechaRecogida(), fechaEntrega).toHours();
		
		if (esEntregaMismoDia(reserva.getFechaRecogida().toLocalDate(), fechaEntrega.toLocalDate())) {
			costoReserva = calcularRecargoPorDiaRecogidaEntrega(reserva, fechaEntrega, totalHoras, true);
		} else {
			long horas = Duration.between(reserva.getFechaRecogida().toLocalTime(), LocalTime.MAX).toHours();
			costoReserva = calcularRecargoPorDiaRecogidaEntrega(reserva, fechaEntrega, (horas + 1), true);
		}
		
		costoReserva = costoReserva.add(BigDecimal.valueOf(totalHoras * TARIFA_ESTANDAR_POR_HORA).add(
				calcularRecargoVariosDias(reserva, fechaEntrega, totalHoras)));
		
		return costoReserva;
	}
	
	/**
	 * Metodo encargado calcular los recargos aplicables al dia en especifico suministrado
	 * 
	 * @param reserva
	 * @param fechaEntrega
	 * @param horas
	 * @return BigDecimal correspondiente al costo de los recargos para el dia suministrado
	 */
	private static BigDecimal calcularRecargoPorDiaRecogidaEntrega(Reserva reserva, LocalDateTime  fechaEntrega, long horas, boolean diaRecogida) {
		BigDecimal costoRecargos = new BigDecimal(0);
		
		if (esFinDeSemana(fechaEntrega)) {
			costoRecargos = costoRecargos.add(
					BigDecimal.valueOf((horas * TARIFA_ESTANDAR_POR_HORA) * PORCENTAJE_RECARGO_TARIFA_FINES_DE_SEMANA));
		} else {
			long horasNocturnas = 0;
			
			if (diaRecogida &&
					!esEntregaMismoDia(reserva.getFechaRecogida().toLocalDate(), fechaEntrega.toLocalDate())) {
				horasNocturnas = Duration.between(LocalTime.of(20, 00, 00), LocalTime.MAX).toHours();
				horasNocturnas++;
			} else if(!diaRecogida &&
					!esEntregaMismoDia(reserva.getFechaRecogida().toLocalDate(), fechaEntrega.toLocalDate())) {
				horasNocturnas = Duration.between(LocalTime.of(00, 00), LocalTime.of(07, 00)).toHours();
				
			}
			
			if (horasNocturnas > 0) {
				costoRecargos = costoRecargos.add(
						BigDecimal.valueOf((horasNocturnas * TARIFA_ESTANDAR_POR_HORA) * PORCENTAJE_RECARGO_NOCTURNO));
			}
		}
		
		return costoRecargos;
	}
	
	/**
	 * Metodo encargado calcular los recargos aplicables a varios dias
	 * 
	 * @param reserva
	 * @param fechaEntrega
	 * @param diasReserva
	 * @param costoReserva
	 * @param totalHoras
	 * @return
	 */
	private static BigDecimal calcularRecargoVariosDias(Reserva reserva, LocalDateTime  fechaEntrega, long totalHoras) {
		int contDias = 1;
		int contadorFinSemana = 0;
		long diasReserva = Duration.between(reserva.getFechaRecogida(), fechaEntrega).toDays();
		LocalDateTime contadorFecha = reserva.getFechaRecogida();
		BigDecimal costoRecargos = new BigDecimal(0);
		
		while(contDias <= diasReserva) {
			if (contDias == diasReserva) {
				costoRecargos = costoRecargos.add(calcularRecargoPorDiaRecogidaEntrega(reserva, fechaEntrega, totalHoras, false));
			} else if (esFinDeSemana(contadorFecha)) {
				contadorFinSemana++;
			}
			contadorFecha = contadorFecha.plusDays(1);
			contDias++;
		}
		
		if (!esEntregaMismoDia(reserva.getFechaRecogida().toLocalDate(), fechaEntrega.toLocalDate()) &&
				diasReserva == 0) {
			costoRecargos = costoRecargos.add(calcularRecargoPorDiaRecogidaEntrega(reserva, fechaEntrega, totalHoras, false));		
		}
		
		if (contadorFinSemana > CERO) {
			int costoHoras = (contadorFinSemana * NUM_HORAS_DIA) * TARIFA_ESTANDAR_POR_HORA;
			costoRecargos = costoRecargos.add(BigDecimal.valueOf((costoHoras * 
					PORCENTAJE_RECARGO_TARIFA_FINES_DE_SEMANA)));
		}
		long numDiasRecargoNocturno = (diasReserva+1) - NUM_DIAS_RECOGIDA_ENTREGA - contadorFinSemana;
		if (numDiasRecargoNocturno > CERO) {
			long costoHoras = (numDiasRecargoNocturno * NUM_HORAS_MAX_RECARGO_NOCTURNO) * TARIFA_ESTANDAR_POR_HORA;
			costoRecargos = costoRecargos.add(BigDecimal.valueOf((costoHoras * 
					PORCENTAJE_RECARGO_NOCTURNO)));
		}
		
		return costoRecargos;
	}
	
	/**
	 * Metodo encargado de validar si la entrega del carro se realizo el mismo dia que fue recogido
	 * 
	 * @param fechaRecogida
	 * @param fechaEntrega
	 * @return boolean
	 */
	private static boolean esEntregaMismoDia(LocalDate  fechaRecogida, LocalDate  fechaEntrega) {
		return fechaRecogida.isEqual(fechaEntrega);
	}
	
	/**
	 * Metodo encargado de validar si la fecha suministrada corresponde a un dia sabado o domingo
	 * 
	 * @param fecha
	 * @return boolean
	 */
	private static boolean esFinDeSemana (LocalDateTime fecha) {
		return fecha.getDayOfWeek() == DayOfWeek.SATURDAY || fecha.getDayOfWeek() == DayOfWeek.SUNDAY;
	}
}