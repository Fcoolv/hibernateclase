package es.altair.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
		
		System.out.println("-----LISTADO DE EQUIPOS----");
		List<Juegos> equipos = new ArrayList<Juegos>();
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {

			sesion.beginTransaction();
			equipos = sesion.createQuery("FROM Juegos").list();
			sesion.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
		}

		return equipos;

	}
	
	
	public boolean delete(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			sesion.createSQLQuery("DELETE FROM juegos WHERE idJuego=:id").setParameter("id",id);
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

}
