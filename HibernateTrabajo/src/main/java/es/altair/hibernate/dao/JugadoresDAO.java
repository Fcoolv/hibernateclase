package es.altair.hibernate.dao;

import java.util.List;

import es.altair.hibernate.bean.jugadores;

public interface JugadoresDAO {

public void save(jugadores e);
	
	public boolean delete(int id);
	
	public boolean update(jugadores e);
	
	public List<jugadores> listar();
	
	public jugadores get(int id);
	
	public void PaginacionJugadores(int pag);
}
