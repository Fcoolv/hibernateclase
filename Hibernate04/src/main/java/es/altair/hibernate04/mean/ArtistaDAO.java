package es.altair.hibernate04.mean;

import java.util.List;

import es.altair.hibernate03.bean.Artista;

public interface ArtistaDAO {

	public boolean insertar(Artista a);
	public void listarArtistas();
	public boolean modificarEdad(int idArtista,String edad);
	public void paisesArtistas();
	public int[] idArtistasPais(String pais);
	public List<Artista> artistaSegunEstilo(int idEst);
	public Artista[] lArtistas();
}
