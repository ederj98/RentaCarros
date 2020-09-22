package com.ceiba.adn.carclick.infraestructura.adaptador.repositorio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.ceiba.adn.carclick.dominio.modelo.Carro;
import com.ceiba.adn.carclick.dominio.puerto.repositorio.RepositorioCarro;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.CarroEntidad;
import com.ceiba.adn.carclick.infraestructura.mapeador.MapeadorCarroEntidad;

@Repository
public class RepositorioCarroMySql implements RepositorioCarro {
	
	private RepositorioCarroJPA carroJPA;
	
	public RepositorioCarroMySql(RepositorioCarroJPA carroJPA) {
		this.carroJPA = carroJPA;
	}

	@Override
	public Carro crear(Carro carro) {
		CarroEntidad entidad = MapeadorCarroEntidad.mapearAEntidad(carro);
		return MapeadorCarroEntidad.mapearAModelo(carroJPA.save(entidad));
	}

	@Override
	public List<Carro> listar() {
		List<CarroEntidad> entidades = carroJPA.findAll();
		return entidades.stream().map(MapeadorCarroEntidad::mapearAModelo).collect(Collectors.toList());
	}

	@Override
	public boolean existe(long idCarro) {
		return carroJPA.existsById(idCarro);
	}
}
