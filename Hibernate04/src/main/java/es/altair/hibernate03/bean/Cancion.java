package es.altair.hibernate03.bean;

public class Cancion {
	private int idcanciones;
	private String nombre;
	private int duracion;
	private int idArtista;
	public int getIdcanciones() {
		return idcanciones;
	}
	public void setIdcanciones(int idcanciones) {
		this.idcanciones = idcanciones;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public int getIdArtista() {
		return idArtista;
	}
	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}
	public Cancion(int idcanciones, String nombre, int duracion, int idArtista) {
		super();
		this.idcanciones = idcanciones;
		this.nombre = nombre;
		this.duracion = duracion;
		this.idArtista = idArtista;
	}
	public Cancion() {
		super();
	}
	@Override
	public String toString() {
		return "Cancion [id=" + idcanciones + ", nombre=" + nombre + ", duracion=" + duracion + ", idArtista=" + idArtista + "]";
	}
}
