package com.ceiba.adn.carclick.infraestructura.adaptador.repositorio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ceiba.adn.carclick.dominio.modelo.Reserva;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioReserva;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.CarroEntidad;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.ReservaEntidad;
import com.ceiba.adn.carclick.infraestructura.mapeador.MapeadorReservaEntidad;

@Component
public class RepositorioReservaMySql implements RepositorioReserva {

	private RepositorioReservaJPA reservaJPA;
	private RepositorioCarroJPA carroJPA;
	
	public RepositorioReservaMySql(RepositorioReservaJPA reservaJPA, RepositorioCarroJPA carroJPA) {
		this.reservaJPA = reservaJPA;
		this.carroJPA = carroJPA;
	}

	@Override
	public Reserva crear(Reserva reserva) {
		ReservaEntidad entidad = MapeadorReservaEntidad.mapearAEntidad(reserva);
		return MapeadorReservaEntidad.mapearAModelo(reservaJPA.save(entidad));
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
		Optional<ReservaEntidad> tempReserva = reservaJPA.findById(reserva.getId());
		Optional<CarroEntidad> tempCarro = carroJPA.findById(reserva.getIdCarro());
	
		if (tempReserva.isPresent()) {
			tempReserva.get().setFechaRecogida(reserva.getFechaRecogida());
			if (tempCarro.isPresent()) {
				tempReserva.get().setIdCarro(tempCarro.get());
			}
		}
		
		MapeadorReservaEntidad.mapearAModelo(reservaJPA.save(entidad));
	}
}
