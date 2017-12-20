package es.altair.hibernate.dao;

import java.util.List;

import es.altair.hibernate.bean.Ordenador;
import es.altair.hibernate.bean.Usuario;

public interface OrdenadorDAO {

	// Metodo listar ordenadores de la BD
	public List<Ordenador> listar();
	
	// Metodo obtener un registro de un ordenador de la BD
	public Ordenador obtener(int idOrdenador);
	
	// Metodo para guardar un registro de un ordenador en la BD
	public boolean guardar(Ordenador pc);
	
	public boolean editar(Ordenador o);
	
	public boolean borrar(Ordenador o);
	
	public List<Ordenador> listadoPorSala(int sala);

	public List<Ordenador> listadoActivos(boolean isActivo);
}
