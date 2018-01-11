package es.altair.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.hibernate.bean.jugadores;

public class JugadoresDAOImpHibernate implements JugadoresDAO {

	public void save(jugadores ju) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			sesion.save(ju);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
			sf.close();
		}

	}

	public List<jugadores> listar() {
		
		System.out.println("-----LISTADO DE Jugadores----");
		List<jugadores> jugadores = new ArrayList<jugadores>();
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {

			sesion.beginTransaction();
			jugadores = sesion.createQuery("FROM jugadores").list();
			sesion.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
		}

		return jugadores;

	}
	
	
	public boolean delete(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			sesion.createSQLQuery("DELETE FROM jugadores WHERE id=:id").setParameter("id",id).executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: No se pudo borrar el jugador.");
			return false;
		}finally {
			sesion.close();
			sf.close();
		}
		System.out.println("Se borro el jugador seleccionado.");
		return true;

	}

	public boolean update(jugadores ju) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {

			sesion.beginTransaction();
			sesion.update(ju);
			sesion.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: No se pudo actualizar el jugadore.");
			return false;
		} finally {
			sesion.close();
			sf.close();
		}
		System.out.println("Se actualizo el jugador seleccionado.");
		return true;
	}


}
