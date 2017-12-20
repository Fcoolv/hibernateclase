package es.altair.hibernate.dao;

import java.util.List;

import es.altair.hibernate.bean.Acceso;

public interface AccesoDAO {

	// Metodo listar accesos de la BD
	public List<Acceso> listar();
	
	// Metodo obtener un registro de un acceso de la BD
	public Acceso obtener(int id);
	
	// Metodo para guardar un registro de acceso en la BD
	public boolean guardar(Acceso acs);
	
	// Metodo para editar un registro de acceso en la BD
	public boolean editar(Acceso acs);
	
	// Metodo para borrar un registro de acceso en la BD
	public boolean borrar(Acceso acs);
	
	
}
