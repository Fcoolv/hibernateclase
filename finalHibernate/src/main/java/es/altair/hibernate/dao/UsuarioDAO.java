package es.altair.hibernate.dao;

import java.util.List;

import es.altair.hibernate.bean.Usuario;

public interface UsuarioDAO {	

	// Metodo listar usuarios de la BD devuelve una lista de usuarios
	public List<Usuario> listar();

	public Usuario obtener(int idUsuario);
	
	public boolean guardar(Usuario u);
	
	public boolean editar(Usuario u);
	
	public boolean borrar(Usuario u);
}
