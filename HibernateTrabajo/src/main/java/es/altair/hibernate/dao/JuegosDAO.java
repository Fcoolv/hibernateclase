package es.altair.hibernate.dao;

import java.util.List;

import es.altair.hibernate.bean.Juegos;

public interface JuegosDAO {
public void save(Juegos e);
	
	public boolean delete(int id);
	
	public boolean update(Juegos e);
	
	public List<Juegos> listar();
}
