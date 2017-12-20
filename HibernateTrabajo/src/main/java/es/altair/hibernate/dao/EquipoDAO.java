package es.altair.hibernate.dao;

import java.util.List;

import es.altair.hibernate.bean.Equipos;

public interface EquipoDAO {

	public void save(Equipos e);
	
	public void delete(int id);
	
	
	public List<Equipos> listar();
}
