package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="equipos")
public class Equipos implements Serializable{

	@Id
	private int id;
	private String nombre;
	private String pais;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="equipojuegos",
	           joinColumns = {@JoinColumn(name="idEquipo")},
	           inverseJoinColumns = {@JoinColumn(name="idJuego")})
	private Set<Juegos> juegos = new HashSet<Juegos>();

	public Equipos() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Set<Juegos> getJuegos() {
		return juegos;
	}

	public void setJuegos(Set<Juegos> juegos) {
		this.juegos = juegos;
	}

	public Equipos(int id, String nombre, String pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", pais=" + pais + "]";
	}
	
	
}
