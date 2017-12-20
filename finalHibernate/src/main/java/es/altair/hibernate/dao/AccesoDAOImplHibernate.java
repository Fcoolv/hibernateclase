package es.altair.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.Session;

import es.altair.hibernate.bean.Acceso;
import es.altair.hibernate.util.SessionProvider;

public class AccesoDAOImplHibernate implements AccesoDAO {

	public List<Acceso> listar() {

		List<Acceso> accesos = new ArrayList<Acceso>();
		Session sesion = SessionProvider.getSession();

		try {

			sesion.beginTransaction();
			accesos = sesion.createQuery("FROM Acceso").list();
			sesion.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
		}

		return accesos;
	}

	public Acceso obtener(int idAcceso) {

		Acceso acceso = null;
		Session sesion = SessionProvider.getSession();

		try {

			sesion.beginTransaction();
			acceso = (Acceso) sesion.createQuery("FROM Acceso WHERE idAcceso =:parametro")
					.setParameter("parametro", idAcceso).uniqueResult();

			sesion.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
		}

		return acceso;
	}

	public boolean guardar(Acceso acs) {

		Session sesion = SessionProvider.getSession();

		try {
			sesion.beginTransaction();
			sesion.save(acs);
			sesion.getTransaction().commit();
		} catch (ConstraintViolationException e) {
			sesion.getTransaction().rollback();
			System.out.println("|            ERROR            |");
			for (ConstraintViolation item : e.getConstraintViolations()) {
				System.out.println("Campo: " + item.getPropertyPath());
				System.out.println("Mensaje: " + item.getMessage());
			}
			System.out.println("No se ha podido guardar el Acceso.");
			return false;
			
		} finally {
			sesion.close();
		}
		System.out.println("El Acceso se ha guardado correctamente.");
		return true;

	}

	public boolean editar(Acceso acs) {

		Session sesion = SessionProvider.getSession();

		try {

			sesion.beginTransaction();
			sesion.update(acs);
			sesion.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se ha podido actualizar el Acceso.");
			return false;
		} finally {
			sesion.close();
		}
		System.out.println("El Acceso se ha actualizado correctamente en la Base de Datos.");
		return true;
	}

	public boolean borrar(Acceso acs) {

		Session sesion = SessionProvider.getSession();

		try {

			sesion.beginTransaction();
			sesion.delete(acs);
			sesion.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se ha podido borrar el Acceso.");
			return false;
		} finally {
			sesion.close();
		}
		System.out.println("El Acceso se ha borrado correctamente.");
		return true;
	}

}
