package es.altair.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.hibernate.bean.EquipoJuego;


public class EquipoJuegoDAOImpHibernate implements EquipoJuegoDAO {


	public boolean delete(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			sesion.createSQLQuery("DELETE FROM equipojuegos WHERE id=:id").setParameter("id",id).executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: No se pudo borrar.");
			return false;
		}finally {
			sesion.close();
			sf.close();
		}
		System.out.println("Se borro con exito");
		return true;
	}

	public boolean update(EquipoJuego e) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {

			sesion.beginTransaction();
			sesion.update(e);
			sesion.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Error: No se pudo actualizar.");
			return false;
		} finally {
			sesion.close();
			sf.close();
		}
		System.out.println("Se actualizo Correctamente.");
		return true;
	}

	public List<EquipoJuego> listar() {
		System.out.println("-----LISTADO DE Equipos Con Juegos----");
		List<EquipoJuego> EqJue = new ArrayList<EquipoJuego>();
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {

			sesion.beginTransaction();
			EqJue = sesion.createCriteria(EquipoJuego.class).list();
			sesion.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
		}

		return EqJue;
	}

	

}
