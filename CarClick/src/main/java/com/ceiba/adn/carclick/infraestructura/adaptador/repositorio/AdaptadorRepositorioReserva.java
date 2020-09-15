package com.ceiba.adn.carclick.infraestructura.adaptador.repositorio;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.ceiba.adn.carclick.dominio.modelo.Reserva;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioReserva;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.ReservaEntidad;
import com.ceiba.adn.carclick.infraestructura.mapeador.MapeadorReservaEntidad;

@Component
public class AdaptadorRepositorioReserva implements RepositorioReserva {

	private RepositorioReservaJPA reservaJPA;
	
	public AdaptadorRepositorioReserva(RepositorioReservaJPA reservaJPA) {
		
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
	public Collection<Reserva> listar(long idReserva) {	
		return null;
	}
}
