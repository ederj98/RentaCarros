package com.ceiba.adn.carclick.infraestructura.adaptador.repositorio;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.ceiba.adn.carclick.dominio.modelo.DetalleReserva;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioDetalleReserva;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.DetalleReservaEntidad;
import com.ceiba.adn.carclick.infraestructura.mapeador.MapeadorDetalleReservaEntidad;

@Component
public class RepositorioDetalleReservaMySql implements RepositorioDetalleReserva {

	private RepositorioDetalleReservaJPA detalleReservaJPA;
	
	public RepositorioDetalleReservaMySql(RepositorioDetalleReservaJPA detalleReservaJPA) {
		this.detalleReservaJPA = detalleReservaJPA;
	}

	@Override
	public DetalleReserva crear(DetalleReserva detalleReserva) {
		DetalleReservaEntidad entidad = MapeadorDetalleReservaEntidad.mapearAEntidad(detalleReserva);
		return MapeadorDetalleReservaEntidad.mapearAModelo(detalleReservaJPA.save(entidad));
	}

	@Override
	public Optional<DetalleReserva> buscarDetalleReserva(long idDetalleReserva) {
		return detalleReservaJPA.findById(idDetalleReserva).map(MapeadorDetalleReservaEntidad::mapearAModelo);
	}
}
