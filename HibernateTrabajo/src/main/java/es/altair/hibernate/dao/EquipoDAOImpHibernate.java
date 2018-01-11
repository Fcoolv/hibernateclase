package es.altair.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.hibernate.bean.Equipos;


public class EquipoDAOImpHibernate implements EquipoDAO {

	public void save(Equipos e) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			sesion.save(e);
			sesion.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			sesion.close();
			sf.close();
		}

	}

	public List<Equipos> listar() {
		
		System.out.println("-----LISTADO DE EQUIPOS----");
		List<Equipos> equipos = new ArrayList<Equipos>();
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {

			sesion.beginTransaction();
			equipos = sesion.createQuery("FROM Equipos").list();
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
			sesion.createSQLQuery("DELETE FROM equipos WHERE id=:id").setParameter("id",id).executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: No se pudo borrar el equipo.");
			return false;
		}finally {
			sesion.close();
			sf.close();
		}
		System.out.println("Se borro el equipo seleccionado.");
		return true;

	}

	public boolean update(Equipos e) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {

			sesion.beginTransaction();
			sesion.update(e);
			sesion.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Error: No se pudo actualizar el Equipo.");
			return false;
		} finally {
			sesion.close();
			sf.close();
		}
		System.out.println("Se actualizo el equipo seleccionado.");
		return true;
	}
}
