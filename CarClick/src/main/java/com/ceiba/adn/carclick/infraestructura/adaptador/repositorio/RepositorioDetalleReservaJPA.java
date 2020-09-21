package com.ceiba.adn.carclick.infraestructura.adaptador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.DetalleReservaEntidad;

/**
 * Interfaz que permite tener acceso a los metodos que proporciona JpaRepository
 * @author eder.fernandez
 *
 */
public interface RepositorioDetalleReservaJPA extends JpaRepository<DetalleReservaEntidad, Long> {
	
	/**
	 * Metodo encargado de consultar un DetalleReserva por numero de reserva.
	 * @param idReserva
	 * @return Optional<DetalleReserva>
	 */
	public DetalleReservaEntidad findByReservaId(@Param("id") long idReserva);
}
