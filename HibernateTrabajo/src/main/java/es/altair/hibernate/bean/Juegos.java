package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="juegos")
public class Juegos implements Serializable{

	@Id
	private int id;
	private String Nombre;
	@ManyToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private TiposJuego idTipo;
	
	private int anyoCreacion;
	private String Compayia;
	
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="juegos")
	private Set<Equipos> equipos = new HashSet<Equipos>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public TiposJuego getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(TiposJuego idTipo) {
		this.idTipo = idTipo;
	}

	public int getAnyoCreacion() {
		return anyoCreacion;
	}

	public void setAnyoCreacion(int anyoCreacion) {
		this.anyoCreacion = anyoCreacion;
	}

	public String getCompayia() {
		return Compayia;
	}

	public void setCompayia(String compayia) {
		Compayia = compayia;
	}

	public Set<Equipos> getEquipos() {
		return equipos;
	}

	public void setEquipos(Set<Equipos> equipos) {
		this.equipos = equipos;
	}

	public Juegos(int id, String nombre, TiposJuego idTipo, int anyoCreacion, String compayia) {
		super();
		this.id = id;
		Nombre = nombre;
		this.idTipo = idTipo;
		this.anyoCreacion = anyoCreacion;
		Compayia = compayia;
	}

	@Override
	public String toString() {
		return "Juegos [id=" + id + ", Nombre=" + Nombre + ", idTipo=" + idTipo + ", anyoCreacion=" + anyoCreacion
				+ ", Compayia=" + Compayia + "]";
	}
	
	
}
