package com.ceiba.adn.carclick.infraestructura.adaptador.repositorio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.ceiba.adn.carclick.dominio.modelo.Reserva;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioReserva;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.ReservaEntidad;
import com.ceiba.adn.carclick.infraestructura.mapeador.MapeadorReservaEntidad;

@Repository
public class RepositorioReservaMySql implements RepositorioReserva {

	private RepositorioReservaJPA reservaJPA;
	
	public RepositorioReservaMySql(RepositorioReservaJPA reservaJPA) {
		this.reservaJPA = reservaJPA;
	}

	@Override
	public void crear(Reserva reserva) {
		ReservaEntidad entidad = MapeadorReservaEntidad.mapearAEntidad(reserva);
		MapeadorReservaEntidad.mapearAModelo(reservaJPA.save(entidad));
	}

	@Override
	public Optional<Reserva> buscarReserva(long idReserva) {
		return reservaJPA.findById(idReserva).map(MapeadorReservaEntidad::mapearAModelo);
	}

	@Override
	public List<Reserva> listar() {
		List<ReservaEntidad> entidades = reservaJPA.findAll();
		return entidades.stream().map(MapeadorReservaEntidad::mapearAModelo).collect(Collectors.toList());
	}

	@Override
	public void actualizar(Reserva reserva) {
		ReservaEntidad entidad = MapeadorReservaEntidad.mapearAEntidad(reserva);		
		MapeadorReservaEntidad.mapearAModelo(reservaJPA.save(entidad));
	}

	@Override
	public boolean existe(long idReserva) {
		return reservaJPA.existsById(idReserva);
	}
}
