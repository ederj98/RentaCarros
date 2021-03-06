package com.ceiba.adn.carclick.infraestructura.adaptador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.ReservaEntidad;

/**
 * Interfaz que permite tener acceso a los metodos que proporciona JpaRepository
 * @author eder.fernandez
 *
 */
public interface RepositorioReservaJPA extends JpaRepository<ReservaEntidad, Long> {}
