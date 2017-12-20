package es.altair.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.collection.internal.PersistentList;
import org.hibernate.criterion.Restrictions;

import es.altair.hibernate.bean.Ordenador;
import es.altair.hibernate.util.SessionProvider;

public class OrdenadorDAOImplHibernate implements OrdenadorDAO {
	
	public List<Ordenador> listar() {
		
		System.out.println("LISTADO DE TODOS LOS ORDENADORES");
		List<Ordenador> ordenadores = new ArrayList<Ordenador>();
		Session sesion = SessionProvider.getSession();

		try {

			sesion.beginTransaction();
			ordenadores = sesion.createQuery("FROM Ordenador").list();
			sesion.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
		}

		return ordenadores;

	}
	
	// Metodo obtener ordenador por ID
		public Ordenador obtener(int idOrdenador) {
			
			Ordenador pc = null;
			Session sesion = SessionProvider.getSession();
			
			try {

				sesion.beginTransaction();
				pc = (Ordenador) sesion.createQuery("FROM Ordenador WHERE idOrdenador =:parametro")
						.setParameter("parametro", idOrdenador)
						.uniqueResult();
				
				sesion.getTransaction().commit();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sesion.close();
			}
					
			return pc;
		}

		public boolean guardar(Ordenador pc) {
			
			Session sesion = SessionProvider.getSession();
			
			try {
				sesion.beginTransaction();
				sesion.save(pc);
				sesion.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("No se ha podido guardar el Ordenador.");
				return false;
			} finally {
				sesion.close();
			}
			System.out.println("El Ordenador se ha guardado correctamente.");
			return true;
		}
		
		public boolean editar(Ordenador o) {
			
			Session sesion = SessionProvider.getSession();
			
			try {
				
				sesion.beginTransaction();
				sesion.update(o);
				sesion.getTransaction().commit();
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("No se han podido actualizar los datos del Ordenador.");
				return false;
			} finally {
				sesion.close();
			}
			System.out.println("El Ordenador se ha actualizado correctamente en la Base de Datos.");
			return true;
		}

		public boolean borrar(Ordenador o) {
			
			Session sesion = SessionProvider.getSession();
			
			try {
				
				sesion.beginTransaction();
				sesion.delete(o);
				sesion.getTransaction().commit();
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("No se ha podido borrar el Ordenador.");
				return false;
			} finally {
				sesion.close();
			}
			System.out.println("El Ordenador se ha borrado correctamente.");
			return true;
		}


		public List<Ordenador> listadoPorSala(int sala) {
			
			List<Ordenador> ordenadores = new ArrayList<Ordenador>();
			Session sesion = SessionProvider.getSession();

			try {

				sesion.beginTransaction();
				ordenadores = sesion.createQuery("FROM Ordenador WHERE idSala = :parametro").setParameter("parametro", sala).list();
				sesion.getTransaction().commit();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sesion.close();
			}

			return ordenadores;			
		}

		public List<Ordenador> listadoActivos(boolean isActivo) {
			
			List<Ordenador> ordenadores = new ArrayList<Ordenador>();
			Session sesion = SessionProvider.getSession();			
			
			try {

				sesion.beginTransaction();			
				ordenadores = sesion.createCriteria(Ordenador.class).add(Restrictions.eq("isActivo", isActivo)).list();				
				sesion.getTransaction().commit();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sesion.close();
			}
			return ordenadores;
		}

		
}
