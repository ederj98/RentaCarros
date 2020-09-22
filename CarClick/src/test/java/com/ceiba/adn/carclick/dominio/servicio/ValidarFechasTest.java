package com.ceiba.adn.carclick.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionFechaEntregaMenorFechaRecogida;
import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionFechaFueraHorarioServicio;
import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionFechaRecogidaAnteriorAFechaActual;

public class ValidarFechasTest {


	private static final String EL_HORARIO_DE_SERVICIO_ES_DE_8_AM_A_8_PM = "El Horario de servicio es de 8 A.M a 8 P.M";
	private static final String LA_FECHA_DE_ENTREGA_DEL_VEHICULO_NO_PUEDE_SER_MENOR_A_LA_FECHA_DE_RECOGIDA = "La fecha de entrega del vehiculo no puede ser menor a la fecha de recogida";
	private static final String LA_FECHA_DE_RECOGIDA_DEL_VEHICULO_NO_PUEDE_SER_MENOR_A_LA_FECHA_ACTUAL = "La fecha de recogida del vehiculo no puede ser menor a la fecha actual";
		
	@Test
	public void cuandoFechaRecogidaFueraHorarioServicioPorLaMañanaEntoncesDeberiaLanzarExcepcion() {
		// arrange
		LocalDateTime fechaRecogida = LocalDateTime.of(2020, 9, 15, 7, 0);
		

		// act / assert
		assertThrows(ExcepcionFechaFueraHorarioServicio.class, 
						() ->  ValidarFechas.validarFechaFueraHorarioServicio(fechaRecogida), 
						EL_HORARIO_DE_SERVICIO_ES_DE_8_AM_A_8_PM);	    
	}
	
	@Test
	public void cuandoFechaEntregaFueraHorarioServicioPorLaNocheEntoncesDeberiaLanzarExcepcion() {
		// arrange
		LocalDateTime fechaEntrega = LocalDateTime.of(2020, 9, 15, 21, 0);
		

		// act / assert
		assertThrows(ExcepcionFechaFueraHorarioServicio.class, 
						() ->  ValidarFechas.validarFechaFueraHorarioServicio(fechaEntrega), 
						EL_HORARIO_DE_SERVICIO_ES_DE_8_AM_A_8_PM);	    
	}
	
	@Test
	public void cuandoFechaEntregaMenorFechaRecogidaEntoncesDeberiaLanzarExcepcion() {
		// arrange
		LocalDateTime fechaRecogida = LocalDateTime.of(2020, 9, 15, 14, 0);
		LocalDateTime fechaEntrega = LocalDateTime.of(2020, 9, 10, 9, 0);
		

		// act / assert
		assertThrows(ExcepcionFechaEntregaMenorFechaRecogida.class, 
						() ->  ValidarFechas.validarFechaRecogidaAnteriorAFechaEntrega(fechaRecogida, fechaEntrega), 
						LA_FECHA_DE_ENTREGA_DEL_VEHICULO_NO_PUEDE_SER_MENOR_A_LA_FECHA_DE_RECOGIDA);	    
	}
	
	@Test
	public void cuandoFechaRecogidaMenorFechaActualEntoncesDeberiaLanzarExcepcion() {
		// arrange
		LocalDateTime fechaActual = LocalDateTime.of(2020, 9, 15, 14, 0);
		LocalDateTime fechaRecogida = LocalDateTime.of(2020, 9, 15, 14, 0);

		// act / assert
		assertThrows(ExcepcionFechaRecogidaAnteriorAFechaActual.class, 
						() ->  ValidarFechas.validarFechaRecogidaPosteriorAFechaActual(fechaRecogida, fechaActual), 
						LA_FECHA_DE_RECOGIDA_DEL_VEHICULO_NO_PUEDE_SER_MENOR_A_LA_FECHA_ACTUAL);	    
	}
}
