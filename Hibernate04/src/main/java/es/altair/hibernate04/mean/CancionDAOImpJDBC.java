package es.altair.hibernate04.mean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.altair.hibernate03.bean.Cancion;

public class CancionDAOImpJDBC implements CancionDAO {

	public boolean insertar(Cancion c) {
    int num_filas = 0;
		
		ConexionDAo.abrirConexion();
		
		String query = "INSERT INTO canciones VALUES(null, ?, ?, ?)";
		
		try {
			PreparedStatement sentencia = ConexionDAo.getConexion().prepareStatement(query);
			sentencia.setString(1, c.getNombre());
			sentencia.setInt(2, c.getDuracion());
			sentencia.setInt(3, c.getIdArtista());
			
			num_filas = sentencia.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ConexionDAo.cerrarConexion();
		
		if(num_filas == 0)
		return false;
		else
		return true;

	}

	public void cancionesArtista(int idArtista) {
		ConexionDAo.abrirConexion();
		List<Cancion> canciones= new ArrayList<Cancion>();
		String query="Select * from canciones where idArtista = "+idArtista;
		try {
			Statement sentencia= ConexionDAo.getConexion().createStatement();
			ResultSet resultado=sentencia.executeQuery(query);
			while(resultado.next()) {
				Cancion c= new Cancion(resultado.getInt(1), resultado.getString(2), resultado.getInt(3), resultado.getInt(4));
				canciones.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Cancion cancion : canciones) {
			System.out.println(cancion);
		}
		ConexionDAo.cerrarConexion();

	}

	public void inserMinMasPais(int[] idArtista) {
		ConexionDAo.abrirConexion();
		int num_filas=0;
		for (int i = 0; i < idArtista.length; i++) {
			String query="update canciones set duracion=duracion+1 where idArtista = ? ";
			
			try {
				PreparedStatement sentencia= ConexionDAo.getConexion().prepareStatement(query);
				sentencia.setInt(1,idArtista[i]);
				num_filas=sentencia.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
			ConexionDAo.cerrarConexion();
			if(num_filas!=0) {
				System.out.println("Las canciones se actualizaron");
			}else {
				System.out.println("Las canciones no se actualizarons");
			}
			
		

	}

	public void borrarCancionesArt(int idArtista) {
		ConexionDAo.abrirConexion();
		String query="delete from canciones where idArtista = ? ";
		int num_filas=0;
		try {
			PreparedStatement sentencia= ConexionDAo.getConexion().prepareStatement(query);
			sentencia.setInt(1,idArtista);
			num_filas=sentencia.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexionDAo.cerrarConexion();
		if(num_filas!=0) {
			System.out.println("Las canciones se actualizaron");
		}else {
			System.out.println("Las canciones no se actualizarons");
		}
		ConexionDAo.cerrarConexion();	

	}

	public List<Cancion> cancionesTodas(int idArtista) {
	    ConexionDAo.abrirConexion();
		List<Cancion> canciones= new ArrayList<Cancion>();
		String query="Select * from canciones where idArtista = "+idArtista;
		try {
			Statement sentencia= ConexionDAo.getConexion().createStatement();
			ResultSet resultado=sentencia.executeQuery(query);
			while(resultado.next()) {
				Cancion c= new Cancion(resultado.getInt(1), resultado.getString(2), resultado.getInt(3), resultado.getInt(4));
				canciones.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      ConexionDAo.cerrarConexion();
      return canciones;
	}

}
