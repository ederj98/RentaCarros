package com.ceiba.adn.carclick.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionFechaFueraHorarioServicio;

public class ValidarFechasTest {


	private static final String EL_HORARIO_DE_SERVICIO_ES_DE_8_AM_A_8_PM = "El Horario de servicio es de 8 A.M a 8 P.M";
	
	@Test
	public void fechaFueraHorarioServicioAntes() {
		// arrange
		LocalDateTime fechaRecogida = LocalDateTime.of(2020, 9, 15, 7, 0);
		

		// act / assert
		assertThrows(ExcepcionFechaFueraHorarioServicio.class, 
						() ->  ValidarFechas.validarFechaFueraHorarioServicio(fechaRecogida), 
						EL_HORARIO_DE_SERVICIO_ES_DE_8_AM_A_8_PM);	    
	}
	
	@Test
	public void fechaFueraHorarioServicioDespues() {
		// arrange
		LocalDateTime fechaEntrega = LocalDateTime.of(2020, 9, 15, 21, 0);
		

		// act / assert
		assertThrows(ExcepcionFechaFueraHorarioServicio.class, 
						() ->  ValidarFechas.validarFechaFueraHorarioServicio(fechaEntrega), 
						EL_HORARIO_DE_SERVICIO_ES_DE_8_AM_A_8_PM);	    
	}
}
