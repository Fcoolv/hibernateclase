package es.altair.hibernate.dao;

import java.util.List;

import es.altair.hibernate.bean.Sala;

public interface SalaDAO {

	// Listar salas
	public List<Sala> listar();
	
	// Obtener Sala por ID
	public Sala obtener(int sala);
	
	// Metodo para guardar/crear una nueva sala en la BD
	public void guardar(Sala s);
	
	// Metodo para borrar una nueva sala en la BD
	public void borrar(Sala s);
	
}
