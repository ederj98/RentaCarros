package com.ceiba.adn.carclick.infraestructura.adaptador.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ceiba.adn.carclick.dominio.modelo.Cliente;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.ClienteEntidad;

/**
 * Interfaz que permite tener acceso a los metodos que proporciona JpaRepository
 * @author eder.fernandez
 *
 */
public interface RepositorioClienteJPA extends JpaRepository<ClienteEntidad, Long> {

	/**
	 * Metodo que permite la busqueda de un Cliente por id
	 * @param idCliente
	 * @return
	 */
	public Optional<Cliente> buscarPorId(@Param("idCliente") long idCliente);
	
	/**
	 * Metodo que permite validar si un Cliente se encuentra registrado con el id
	 * suministrado
	 * @param idCliente
	 * @return
	 */
	public boolean existe(@Param("idCliente") long idCliente);
}
