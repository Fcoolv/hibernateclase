package es.altair.hibernate.bean;

import java.io.Serializable;

public class TiposJuego implements Serializable{

	private int id;
	private String nombreTipo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreTipo() {
		return nombreTipo;
	}
	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
	public TiposJuego(int id, String nombreTipo) {
		super();
		this.id = id;
		this.nombreTipo = nombreTipo;
	}
	@Override
	public String toString() {
		return "TiposJuego [id=" + id + ", nombreTipo=" + nombreTipo + "]";
	}
	
	
}
