package es.altair.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.hibernate.bean.Usuario;
import es.altair.hibernate.util.SessionProvider;

public class UsuarioDAOImplHibernate implements UsuarioDAO {
	
	public List<Usuario> listar() {		
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Session sesion = SessionProvider.getSession();

		try {

			sesion.beginTransaction();
			usuarios = sesion.createQuery("FROM Usuario").list();
			sesion.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
		}

		return usuarios;
	}

	// Metodo obtener usuario por ID
	public Usuario obtener(int idUsuario) {
		
		Usuario usu = null;
		Session sesion = SessionProvider.getSession();
		
		try {

			sesion.beginTransaction();
			usu = (Usuario)sesion.createQuery("FROM Usuario WHERE idUsuario =:parametro")
					.setParameter("parametro", idUsuario)
					.uniqueResult();
			
			sesion.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
		}
				
		return usu;
	}

	public boolean guardar(Usuario u) {
		
		Session sesion = SessionProvider.getSession();
		
		try {
			sesion.beginTransaction();
			sesion.save(u);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se ha podido guardar el Usuario.");
			return false;
		} finally {
			sesion.close();
		}
		System.out.println("El usuario se ha guardado correctamente.");
		return true;		
	}
	
	public boolean editar(Usuario u) {
		
		Session sesion = SessionProvider.getSession();
		
		try {
			
			sesion.beginTransaction();
			sesion.update(u);
			sesion.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se han podido actualizar los datos del Usuario.");
			return false;
		} finally {
			sesion.close();
		}
		System.out.println("El usuario se ha actualizado correctamente en la Base de Datos.");
		return true;
		
	}

	public boolean borrar(Usuario u) {
		
		Session sesion = SessionProvider.getSession();
		
		try {
			
			sesion.beginTransaction();
			sesion.delete(u);
			sesion.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se ha podido borrar el Usuario.");
			return false;
		} finally {
			sesion.close();
		}
		System.out.println("El Usuario se ha borrado correctamente.");
		return true;
	}

}
