package es.altair.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.altair.hibernate.bean.Ordenador;
import es.altair.hibernate.bean.Sala;
import es.altair.hibernate.util.SessionProvider;

public class SalaDAOImplHibernate implements SalaDAO {

	public List<Sala> listar() {
		
		System.out.println("LISTADO DE SALAS");
		List<Sala> salas = new ArrayList<Sala>();
		Session sesion = SessionProvider.getSession();

		try {

			sesion.beginTransaction();
			salas = sesion.createQuery("FROM Sala").list();
			sesion.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
		}

		return salas;
	}
	
	public Sala obtener(int idSala) {
		
		Sala sala = null;
		Session sesion = SessionProvider.getSession();
		
		try {

			sesion.beginTransaction();
			sala = (Sala)sesion.createQuery("FROM Sala WHERE idSala =:parametro")
					.setParameter("parametro", idSala)
					.uniqueResult();
			
			sesion.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
		}
				
		return sala;
	}

	public void guardar(Sala s) {
				
		Session sesion = SessionProvider.getSession();
		sesion.beginTransaction();
		sesion.save(s);
		sesion.getTransaction().commit();
		sesion.close();

	}

	public void borrar(Sala s) {
		
		Session sesion = SessionProvider.getSession();
		sesion.beginTransaction();
		sesion.delete(s);
		sesion.getTransaction().commit();
		sesion.close();
		
	}	
}
