package es.altair.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.hibernate.bean.Equipos;
import es.altair.hibernate.bean.Juegos;

public class JuegosDAOImpHibernate implements JuegosDAO {

	public void save(Juegos j) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			sesion.save(j);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
			sf.close();
		}

	}

	public List<Juegos> listar() {
		
		System.out.println("-----LISTADO DE JUEGOS----");
		List<Juegos> juegos = new ArrayList<Juegos>();
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {

			sesion.beginTransaction();
			juegos = sesion.createQuery("From Juegos").list();
			sesion.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
		}

		return juegos;

	}
	
	
	public boolean delete(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			sesion.createSQLQuery("DELETE FROM juegos WHERE idJuegos=:id").setParameter("id",id).executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: No se pudo borrar el juego.");
			return false;
		}finally {
			sesion.close();
			sf.close();
		}
		System.out.println("Se borro el juego seleccionado.");
		return true;

	}

	public boolean update(Juegos j) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {

			sesion.beginTransaction();
			sesion.update(j);
			sesion.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: No se pudo actualizar el juego.");
			return false;
		} finally {
			sesion.close();
			sf.close();
		}
		System.out.println("Se actualizo el juego seleccionado.");
		return true;
	}

	public Juegos get(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		Juegos Juegos = new Juegos();
		
		
		try {

			sesion.beginTransaction();
			
			Juegos = (Juegos)sesion.createQuery("From Juegos Where idJuegos = :id").setParameter("id", id).uniqueResult();
			
			sesion.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
		}
				
		return Juegos;
	}

}
