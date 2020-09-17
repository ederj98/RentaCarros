package com.ceiba.adn.carclick.infraestructura.controlador;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.ceiba.adn.carclick.aplicacion.dto.ReservaDTO;
import com.ceiba.adn.carclick.testdatabuilder.ReservaDTOTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CarClickApplication.class)
@WebAppConfiguration
@TestPropertySource(locations = "classpath:application-test.properties")
public class ControladorReservaTest {

	private static final String URL_BASE = "http://localhost:8080/api/reserva";

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
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/scripts/crear-cliente-carro.sql")
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "/scripts/limpiar-data.sql")
	public void cuandoPeticionCrearReservaNoExisteEntoncesDeberiaCrear() throws Exception {
		// arrange
		ReservaDTO reservaDTO = new ReservaDTOTestDataBuilder().build();

		// act - assert
		mockMvc.perform(post(URL_BASE)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapperTest.writeValueAsString(reservaDTO)))
				.andDo(print())
				.andExpect(status().isCreated());
	}
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/scripts/crear-cliente-carro.sql")
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "/scripts/limpiar-data.sql")
	public void cuandoPeticionCrearReservaClienteNoExisteEntoncesDeberiaLanzarExcepcion() throws Exception {
		// arrange
		ReservaDTO reservaDTO = new ReservaDTOTestDataBuilder().conIdCliente(1223222333).build();

		// act - assert
		mockMvc.perform(post(URL_BASE)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapperTest.writeValueAsString(reservaDTO)))
				.andDo(print())
				.andExpect(status().isBadRequest());
	}
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/scripts/crear-cliente-carro.sql")
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "/scripts/limpiar-data.sql")
	public void cuandoPeticionCrearReservaCarroNoExisteEntoncesDeberiaLanzarExcepcion() throws Exception {
		// arrange
		ReservaDTO reservaDTO = new ReservaDTOTestDataBuilder().conIdCarro(12).build();

		// act - assert
		mockMvc.perform(post(URL_BASE)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapperTest.writeValueAsString(reservaDTO)))
				.andDo(print())
				.andExpect(status().isBadRequest());
	}
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/scripts/listar-reservas.sql")
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "/scripts/limpiar-data.sql")
	public void cuandoPeticionListarReservasEntoncesDeberiaRetornarReservas() throws Exception {
		// arrange - act - assert
		mockMvc.perform(get(URL_BASE).
				contentType(MediaType.APPLICATION_JSON).
				accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(jsonPath("$.*", hasSize(4)))
				.andExpect(status().isOk());
	}
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/scripts/crear-reserva.sql")
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "/scripts/limpiar-data.sql")
	public void cuandoPeticionActualizarReservaClienteNoExisteEntoncesDeberiaLanzarExcepcion() throws Exception {
		// arrange
		ReservaDTO reservaDTO = new ReservaDTOTestDataBuilder().conIdCliente(1112587790).build();

		// act - assert
		mockMvc.perform(put(URL_BASE)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapperTest.writeValueAsString(reservaDTO)))
				.andDo(print())
				.andExpect(status().isBadRequest());
	}
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/scripts/crear-reserva.sql")
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "/scripts/limpiar-data.sql")
	public void cuandoPeticionActualizarReservaCarroNoExisteEntoncesDeberiaLanzarExcepcion() throws Exception {
		// arrange
		ReservaDTO reservaDTO = new ReservaDTOTestDataBuilder().conIdCarro(20).build();

		// act - assert
		mockMvc.perform(put(URL_BASE)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapperTest.writeValueAsString(reservaDTO)))
				.andDo(print())
				.andExpect(status().isBadRequest());
	}
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/scripts/crear-reserva.sql")
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "/scripts/limpiar-data.sql")
	public void cuandoPeticionActualizarReservaClienteExisteCarroExisteEntoncesDeberiaActualizar() throws Exception {
		// arrange
		ReservaDTO reservaDTO = new ReservaDTOTestDataBuilder().conIdCarro(2).build();

		// act - assert
		mockMvc.perform(put(URL_BASE)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapperTest.writeValueAsString(reservaDTO)))
				.andDo(print())
				.andExpect(status().isCreated());
	}
}
