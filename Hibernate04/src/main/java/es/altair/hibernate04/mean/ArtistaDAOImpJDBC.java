package es.altair.hibernate04.mean;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
			sentencia.setLong(3, a.getIdEstilo());
			sentencia.setString(4, a.getEdad());
			sentencia.setString(5, a.getPais());
			
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

}
