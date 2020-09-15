package com.ceiba.adn.carclick.infraestructura.adaptador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.DetalleReservaEntidad;

/**
 * Interfaz que permite tener acceso a los metodos que proporciona JpaRepository
 * @author eder.fernandez
 *
 */
public interface RepositorioDetalleReservaJPA extends JpaRepository<DetalleReservaEntidad, Long> {}
