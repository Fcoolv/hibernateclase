package es.altair.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import es.altair.hibernate.bean.TiposJuego;

public class TipoDAOImpHibernate implements TipoDAO {

	public void save(TiposJuego t) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			sesion.save(t);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
			sf.close();
		}

	}

	public List<TiposJuego> listar() {
		
		System.out.println("-----LISTADO DE TIPOSDEJUEGO----");
		List<TiposJuego> tipos = new ArrayList<TiposJuego>();
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {

			sesion.beginTransaction();
			tipos = sesion.createQuery("FROM TiposJuego").list();
			sesion.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
		}

		return tipos;

	}
	
	
	@SuppressWarnings("deprecation")
	public boolean delete(int idtipo) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			sesion.createSQLQuery("DELETE FROM tiposjuego WHERE idtipo = :idtipo").setParameter("idtipo",idtipo).executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: No se pudo borrar el tipo de juego.");
			return false;
		}finally {
			sesion.close();
			sf.close();
		}
		System.out.println("Se borro el tipo de juego seleccionado.");
		return true;

	}

	public boolean update(TiposJuego t) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {

			sesion.beginTransaction();
			sesion.update(t);
			sesion.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: No se pudo actualizar el tipo de juego.");
			return false;
		} finally {
			sesion.close();
			sf.close();
		}
		System.out.println("Se actualizo el tipo de juego seleccionado.");
		return true;
	}


}
