package es.altair.hibernate.dao;

import java.util.List;

import es.altair.hibernate.bean.Equipos;

public interface EquipoDAO {

	public void save(Equipos e);
	
	public Equipos get(int id);
	
	public boolean delete(int id);
	
	public boolean update(Equipos e);
	
	public List<Equipos> listar();
}
