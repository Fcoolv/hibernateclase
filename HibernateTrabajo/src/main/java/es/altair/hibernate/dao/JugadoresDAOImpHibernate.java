package es.altair.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.hibernate.bean.Juegos;
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

	public jugadores get(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		jugadores jugador = new jugadores();
		
		
		try {

			sesion.beginTransaction();
			
			jugador = (jugadores)sesion.createQuery("From jugadores Where id = :id").setParameter("id", id).uniqueResult();
			
			sesion.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
		}
				
		return jugador;
	}

	public void PaginacionJugadores(int tpag) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		
		
		try {
		sesion.beginTransaction();
		
		long numJug = (Long) sesion.createQuery("SELECT COUNT(*) FROM jugadores").uniqueResult();
		
		int numPag = (int) Math.ceil(numJug / tpag);
		
		Query query = (Query) sesion.createQuery("FROM jugadores").setMaxResults(tpag);
		
			
			for (int i = 0; i < numPag; i++) {
				System.out.println("-- Página " + (i + 1) + " --");
				query.setFirstResult(i*tpag);
				List<jugadores> jugadores = query.list();
				for (jugadores jugador : jugadores) {
					System.out.println(jugador);
           }
		}	
			sesion.getTransaction().commit();
		
		
		}catch(Exception e) {
			//System.out.println(e.getMessage());
		}finally {
			sesion.close();
			sf.close();	
		}
		
	}


}
