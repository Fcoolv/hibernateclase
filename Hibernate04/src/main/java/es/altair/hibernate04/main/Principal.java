package es.altair.hibernate04.main;

import es.altair.hibernate03.bean.Artista;
import es.altair.hibernate04.mean.ArtistaDAO;
import es.altair.hibernate04.mean.ArtistaDAOImpJDBC;

public class Principal {

	private static ArtistaDAO aDAO = new ArtistaDAOImpJDBC();
	
	public static void main(String[] args) {
	   Artista a = new Artista("nombre", "apellidos", "edad", "pais", 2);

	}

}
