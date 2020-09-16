package com.ceiba.adn.carclick.infraestructura.adaptador.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.ReservaEntidad;

/**
 * Interfaz que permite tener acceso a los metodos que proporciona JpaRepository
 * @author eder.fernandez
 *
 */
public interface RepositorioReservaJPA extends JpaRepository<ReservaEntidad, Long> {
	
	/**
	 * Metodo que permite buscar todas las reservas que coincidan con el idCliente suministrado
	 * @param idCliente
	 * @return
	 */
	public List<ReservaEntidad> findAllByIdCliente(@Param("idCliente") long idCliente);
}
