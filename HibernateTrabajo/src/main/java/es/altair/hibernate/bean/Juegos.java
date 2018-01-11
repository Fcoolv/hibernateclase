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
	
	private String anyoCreacion;
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


	public String getAnyoCreacion() {
		return anyoCreacion;
	}

	public void setAnyoCreacion(String anyoCreacion) {
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

	public TiposJuego getTipo() {
		return tipo;
	}

	public void setTipo(TiposJuego tipo) {
		this.tipo = tipo;
	}

	public void setEquipos(Set<Equipos> equipos) {
		this.equipos = equipos;
	}

	public Juegos() {
		// TODO Auto-generated constructor stub
	}
	
	public Juegos(int idJuegos, String compayia , String nombre,String anyoCreacion,TiposJuego Tipo) {
		super();
		this.idJuegos = idJuegos;
		this.Nombre = nombre;
		this.tipo = Tipo;
		this.Compayia = compayia;
		this.anyoCreacion = anyoCreacion;
		
		
		
	}

	@Override
	public String toString() {
		return "Juegos [idJuegos=" + idJuegos + ", Nombre=" + Nombre + ", Tipo=" + tipo.getNombreTipo() + ", anyoCreacion=" + anyoCreacion
				+ ", Compayia=" + Compayia + "]";
	}
	
	
}
