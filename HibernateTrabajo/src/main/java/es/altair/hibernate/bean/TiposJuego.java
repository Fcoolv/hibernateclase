package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tiposjuego")
public class TiposJuego implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipo;
	private String nombreTipo;
	
	@OneToMany(mappedBy="tipo", cascade=CascadeType.ALL)
	private Set<Juegos> juegos;
	
	
	public int getidTipo() {
		return idTipo;
	}
	public void setId(int idTipo) {
		this.idTipo = idTipo;
	}
	public String getNombreTipo() {
		return nombreTipo;
	}
	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
	public TiposJuego(int idTipo, String nombreTipo) {
		super();
		this.idTipo = idTipo;
		this.nombreTipo = nombreTipo;
	}
	public TiposJuego() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TiposJuego [idTipo=" + idTipo + ", nombreTipo=" + nombreTipo + "]";
	}
	
	
}
