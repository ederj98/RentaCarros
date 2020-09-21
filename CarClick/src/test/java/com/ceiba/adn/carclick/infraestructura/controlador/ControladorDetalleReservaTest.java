package com.ceiba.adn.carclick.infraestructura.controlador;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ceiba.adn.carclick.CarClickApplication;
import com.ceiba.adn.carclick.aplicacion.dto.DetalleReservaDTO;
import com.ceiba.adn.carclick.testdatabuilder.DetalleReservaDTOTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CarClickApplication.class)
@WebAppConfiguration
@TestPropertySource(locations = "classpath:application-test.properties")
public class ControladorDetalleReservaTest {

	private static final String URL_BASE = "http://localhost:8080/api/detalleReserva";
	private static final String GET_URL_BASE = "http://localhost:8080/api/detalleReserva/{id}";

	@Autowired
	private ObjectMapper objectMapperTest;

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/scripts/crear-reserva.sql")
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "/scripts/limpiar-data.sql")
	public void cuandoPeticionCrearDetalleReservaConReservaNoExistenteEntoncesDeberiaCrear() throws Exception {
		// arrange
		DetalleReservaDTO detalleReservaDTO = new DetalleReservaDTOTestDataBuilder().build();

		// act - assert
		if (LocalTime.now().isAfter(LocalTime.of(20, 0)) ||
				LocalTime.now().isBefore(LocalTime.of(7, 0))) {
			mockMvc.perform(post(URL_BASE)
					.contentType(MediaType.APPLICATION_JSON)
					.content(objectMapperTest.writeValueAsString(detalleReservaDTO)))
					.andDo(print())
					.andExpect(status().isBadRequest());
		} else {
			mockMvc.perform(post(URL_BASE)
					.contentType(MediaType.APPLICATION_JSON)
					.content(objectMapperTest.writeValueAsString(detalleReservaDTO)))
					.andDo(print())
					.andExpect(status().isCreated());
		}
	}
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/scripts/crear-detalle-reserva.sql")
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "/scripts/limpiar-data.sql")
	public void cuandoPeticionCrearDetalleReservaConReservaNoExistenteEntoncesDeberiaLanzarExcepcion() throws Exception {
		// arrange
		DetalleReservaDTO detalleReservaDTO = new DetalleReservaDTOTestDataBuilder().conIdReserva(50).build();
		
		// act - assert
		mockMvc.perform(post(URL_BASE)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapperTest.writeValueAsString(detalleReservaDTO)))
				.andDo(print())
				.andExpect(status().isNotFound());
	}
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/scripts/crear-detalle-reserva.sql")
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "/scripts/limpiar-data.sql")
	public void cuandoPeticionConsultarClienteEntoncesDeberiaRetornarCliente() throws Exception {
		// arrange 
		final long idReserva = 1;
		
		// act - assert
		mockMvc.perform(get(GET_URL_BASE, idReserva).
				contentType(MediaType.APPLICATION_JSON).
				accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(jsonPath("$.*", hasSize(4)))
				.andExpect(status().isOk());
	}
}
