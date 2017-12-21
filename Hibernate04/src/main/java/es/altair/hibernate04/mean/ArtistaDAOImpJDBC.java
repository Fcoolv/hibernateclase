package es.altair.hibernate04.mean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.altair.hibernate03.bean.Artista;

public class ArtistaDAOImpJDBC implements ArtistaDAO {

	public boolean insertar(Artista a) {
    int num_filas = 0;
		
		ConexionDAo.abrirConexion();
		
		String query = "INSERT INTO artista VALUES(null, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement sentencia = ConexionDAo.getConexion().prepareStatement(query);
			sentencia.setString(1, a.getNombre());
			sentencia.setString(2, a.getApellidos());
			sentencia.setString(3, a.getEdad());
			sentencia.setString(4, a.getPais());
			sentencia.setLong(5, a.getIdEstilo());
			
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

	public void listarArtistas() {
		List<Artista> artistas= new ArrayList<Artista>();
		String query="SELECT * FROM artista";
		ConexionDAo.abrirConexion();
		try {
			Statement sentencia= ConexionDAo.getConexion().createStatement();
			ResultSet resultado=sentencia.executeQuery(query);
			while(resultado.next()) {
				Artista a= new Artista(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(4),resultado.getString(5),resultado.getInt(6));
				artistas.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Artista artista : artistas) {
			System.out.println(artista);
		}
		ConexionDAo.cerrarConexion();
	}

	public void paisesArtistas() {
		List<String> paises= new ArrayList<String>();
		ConexionDAo.abrirConexion();
		String query="SELECT pais FROM artista";
		try {
			Statement sentencia= ConexionDAo.getConexion().createStatement();
			ResultSet resultado=sentencia.executeQuery(query);
			while(resultado.next()) {
				paises.add(resultado.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (String string : paises) {
			System.out.println(string);
		}
		ConexionDAo.cerrarConexion();
		
	}
	
	public boolean modificarEdad(int idArtista, String edad) {
		ConexionDAo.abrirConexion();
		String query="UPDATE artista SET edad=? WHERE idArtista=?";
		int num_filas=0;
		try {
			PreparedStatement sentencia= ConexionDAo.getConexion().prepareStatement(query);
			sentencia.setString(1,edad);
			sentencia.setInt(2,idArtista);

			num_filas=sentencia.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexionDAo.cerrarConexion();
		if(num_filas!=0) {
			System.out.println("Edad Actualizada");
			return true;
		}else {
			System.out.println("Edad no actualizada");
			return false;
		}	}

	public int[] idArtistasPais(String pais) {
		List<Integer> idArtistas=new ArrayList<Integer>();
		int[] idArtista;
		ConexionDAo.abrirConexion();
		String query="SELECT idArtista FROM artista WHERE pais = ?";
		try {
			PreparedStatement sentencia= ConexionDAo.getConexion().prepareStatement(query);
			sentencia.setString(1, pais);
			ResultSet resultado=sentencia.executeQuery();
			while(resultado.next()) {
				idArtistas.add(resultado.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		idArtista = new int[idArtistas.size()];
		int i=0;
		try {
			PreparedStatement sentencia= ConexionDAo.getConexion().prepareStatement(query);
			sentencia.setString(1, pais);
			ResultSet resultado=sentencia.executeQuery();
			while(resultado.next()) {
				idArtista[i]=resultado.getInt(1);
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexionDAo.cerrarConexion();
		return idArtista;
	}

	public List<Artista> artistaSegunEstilo(int idEst) {
		List<Artista> artistas= new ArrayList<Artista>();
		ConexionDAo.abrirConexion();
		String query="SELECT * FROM artista LEFT JOIN estilos ON (artista.idEstilos=estilos.idestilos) WHERE estilos.idestilos = "+idEst;
		try {
			Statement sentencia= ConexionDAo.getConexion().createStatement();
			ResultSet resultado=sentencia.executeQuery(query);
			while(resultado.next()) {
				Artista a= new Artista(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(4),resultado.getString(5), resultado.getInt(6));
				artistas.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexionDAo.cerrarConexion();
		return artistas;
	}

	public Artista[] lArtistas() {
		List<Artista> artistas = new ArrayList<Artista>();
		ConexionDAo.abrirConexion();
		String query="SELECT * FROM artista";
		try {
			Statement sentencia= ConexionDAo.getConexion().createStatement();
			ResultSet resultado=sentencia.executeQuery(query);
			while(resultado.next()) {
				Artista a= new Artista(resultado.getInt(1));
				artistas.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Artista[] mostrarArtistasTodos= new Artista[artistas.size()];
		try {
			Statement sentencia= ConexionDAo.getConexion().createStatement();
			ResultSet resultado=sentencia.executeQuery(query);
			int i=0;
			while(resultado.next()) {
				mostrarArtistasTodos[i]= new Artista(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(4),resultado.getString(5), resultado.getInt(6));
				i++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexionDAo.cerrarConexion();
		return mostrarArtistasTodos;
	}
}
