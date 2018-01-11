package es.altair.hibernate.dao;

import java.util.List;

import es.altair.hibernate.bean.TiposJuego;

public interface TipoDAO {

public void save(TiposJuego e);
	
	public boolean delete(int id);
	
	public boolean update(TiposJuego e);
	
	public List<TiposJuego> listar();

	public TiposJuego get(int id);
}
