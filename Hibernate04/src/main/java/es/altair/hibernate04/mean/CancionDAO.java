package es.altair.hibernate04.mean;


import java.util.List;

import es.altair.hibernate03.bean.Cancion;


public interface CancionDAO {
	public boolean insertar(Cancion c);
	public void cancionesArtista(int idArtista);
	public void inserMinMasPais(int[] idArtista);
	public void borrarCancionesArt(int idArtista);
	public List<Cancion> cancionesTodas(int idArtista);
}
