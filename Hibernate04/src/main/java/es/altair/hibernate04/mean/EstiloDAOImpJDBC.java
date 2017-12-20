package es.altair.hibernate04.mean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.altair.hibernate03.bean.Estilo;

public class EstiloDAOImpJDBC implements EstiloDAO {

	public boolean insertar(Estilo est) {		
         int num_filas = 0;
		
		ConexionDAo.abrirConexion();
		
		String query="INSERT INTO estilos VALUES(null,?)";
		
		try {
			PreparedStatement sentencia = ConexionDAo.getConexion().prepareStatement(query);
			sentencia.setString(1, est.getnEstilo());
			
			num_filas = sentencia.executeUpdate();
		} catch (SQLException e) {
		      e.printStackTrace();
		}
		
		
		ConexionDAo.cerrarConexion();
		if(num_filas == 0)
		return false;
		else
		return true;
	}

	public void listarEstilos() {
		List<Estilo> estilos= new ArrayList<Estilo>();
		ConexionDAo.abrirConexion();
		String query="Select * from estilos";
		try {
			Statement sentencia= ConexionDAo.getConexion().createStatement();
			ResultSet resultado=sentencia.executeQuery(query);
			while(resultado.next()) {
				Estilo est= new Estilo(resultado.getInt(1),resultado.getString(2));
				estilos.add(est);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Estilo estilo : estilos) {
			System.out.println(estilo);
		}
		ConexionDAo.cerrarConexion();
	}

}
