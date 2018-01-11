package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="juegos")
public class Juegos implements Serializable{

	@Id
	private int idJuegos;
	private String Nombre;
	
	@ManyToOne
	@JoinColumn(name="idtipo")
	private TiposJuego tipo;
	
	private int anyoCreacion;
	private String Compayia;
	
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="juegos")
	private Set<Equipos> equipos = new HashSet<Equipos>();

	public int getIdJuegos() {
		return idJuegos;
	}

	public void setIdJuegos(int idJuegos) {
		this.idJuegos = idJuegos;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
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

	public Juegos() {
		// TODO Auto-generated constructor stub
	}
	
	public Juegos(int idJuegos, String compayia , String nombre,int anyoCreacion,TiposJuego Tipo) {
		super();
		this.idJuegos = idJuegos;
		this.Compayia = compayia;
		this.Nombre = nombre;
		this.anyoCreacion = anyoCreacion;
		this.tipo = Tipo;
		
		
	}

	@Override
	public String toString() {
		return "Juegos [idJuegos=" + idJuegos + ", Nombre=" + Nombre + ", Tipo=" + tipo.getNombreTipo() + ", anyoCreacion=" + anyoCreacion
				+ ", Compayia=" + Compayia + "]";
	}
	
	
}
