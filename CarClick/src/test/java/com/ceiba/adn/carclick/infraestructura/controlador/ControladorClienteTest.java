package com.ceiba.adn.carclick.infraestructura.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;

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
import com.ceiba.adn.carclick.aplicacion.dto.ClienteDTO;
import com.ceiba.adn.carclick.aplicacion.dto.ReservaDTO;
import com.ceiba.adn.carclick.testdatabuilder.ClienteDTOTestDataBuilder;
import com.ceiba.adn.carclick.testdatabuilder.ReservaDTOTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CarClickApplication.class)
@WebAppConfiguration
@TestPropertySource(locations = "classpath:application-test.properties")
public class ControladorClienteTest {

	private static final String URL_BASE = "http://localhost:8080/api/cliente";
	private static final String GET_URL_BASE = "http://localhost:8080/api/cliente/{id}";

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
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "/scripts/limpiar-data.sql")
	public void cuandoPeticionCrearClienteNoExistenteEntoncesDeberiaCrear() throws Exception {
		// arrange
		ClienteDTO clienteDTO = new ClienteDTOTestDataBuilder().build();

		// act - assert
		mockMvc.perform(post(URL_BASE)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapperTest.writeValueAsString(clienteDTO)))
				.andDo(print())
				.andExpect(status().isCreated());
	}
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/scripts/crear-cliente.sql")
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "/scripts/limpiar-data.sql")
	public void cuandoPeticionCrearClienteExistenteEntoncesDeberiaLanzarExcepcion() throws Exception {
		// arrange
		ClienteDTO clienteDTO = new ClienteDTOTestDataBuilder().conIdCliente(1123321432).build();
		
		// act - assert
		mockMvc.perform(post(URL_BASE)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapperTest.writeValueAsString(clienteDTO)))
				.andDo(print())
				.andExpect(status().isBadRequest());
	}
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/scripts/crear-cliente.sql")
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "/scripts/limpiar-data.sql")
	public void cuandoPeticionConsultarClienteEntoncesDeberiaRetornarCliente() throws Exception {
		// arrange 
		final long idCliente = 1123321432;
		
		// act - assert
		mockMvc.perform(get(GET_URL_BASE, idCliente).
				contentType(MediaType.APPLICATION_JSON).
				accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(jsonPath("$.*", hasSize(5)))
				.andExpect(status().isOk());
	}
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/scripts/crear-cliente.sql")
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "/scripts/limpiar-data.sql")
	public void cuandoPeticionConsultarClienteNoExisteEntoncesDeberiaLanzarExcepcion() throws Exception {
		// arrange 
		final long idCliente = 1258787555;

		// act - assert
		mockMvc.perform(get(GET_URL_BASE, idCliente)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isNotFound());
	}
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/scripts/crear-cliente.sql")
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "/scripts/limpiar-data.sql")
	public void cuandoPeticionActualizarClienteNoExisteEntoncesDeberiaLanzarExcepcion() throws Exception {
		// arrange
		ClienteDTO clienteDTO = new ClienteDTOTestDataBuilder().conIdCliente(1112587799).build();

		// act - assert
		mockMvc.perform(put(URL_BASE)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapperTest.writeValueAsString(clienteDTO)))
				.andDo(print())
				.andExpect(status().isNotFound());
	}
		
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/scripts/crear-cliente.sql")
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "/scripts/limpiar-data.sql")
	public void cuandoPeticionActualizarClienteExisteEntoncesDeberiaActualizar() throws Exception {
		// arrange
		ClienteDTO clienteDTO = new ClienteDTOTestDataBuilder().conIdCliente(1123321432).build();

		// act - assert
		mockMvc.perform(put(URL_BASE)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapperTest.writeValueAsString(clienteDTO)))
				.andDo(print())
				.andExpect(status().isCreated());
	}
}
