package es.altair.hibernate.dao;

import java.util.List;

import es.altair.hibernate.bean.EquipoJuego;

public interface EquipoJuegoDAO {

	
    public boolean delete(int id);
	
	public boolean update(EquipoJuego ej);
	
	public List<EquipoJuego> listar();
}
