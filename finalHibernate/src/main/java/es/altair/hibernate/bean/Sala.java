package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="salas")
public class Sala implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSala;
	
	@NotNull
	//@NotBlank
	private String nombre;
	
	@OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
	private Set<Ordenador> misOrdenadores = new HashSet<Ordenador>();

	public Sala() {
		super();
	}	

	public Sala(int idSala, String nombre) {
		super();
		this.idSala = idSala;
		this.nombre = nombre;
	}

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Ordenador> getOrdenadores() {
		return misOrdenadores;
	}

	public void setOrdenadores(Set<Ordenador> ordenadores) {
		this.misOrdenadores = ordenadores;
	}

	@Override
	public String toString() {
		return "Sala [idSala=" + idSala + ", nombre=" + nombre + "]";
	}
	
		
}
