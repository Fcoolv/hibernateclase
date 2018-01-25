package es.altair.hibernate.bean;

import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="jugadores")
public class jugadores implements Serializable{

	@Id
	private int id;
	private String nombre;
	private String apellidos;
	private String nickname;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idEquipo")
	private Equipos equipo;
	
	public jugadores() {
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Equipos getIdEquipo() {
		return equipo;
	}

	public void setIdEquipo(Equipos equipo) {
		this.equipo = equipo;
	}

	public jugadores(String nombre, String apellidos, String nickname, Equipos idEquipo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nickname = nickname;
		this.equipo = idEquipo;
	}

	@Override
	public String toString() {
		return "jugadores [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nickname=" + nickname
				+ ", equipo=" + equipo.getNombre() + "]";
	}

	
	
	
	
	
}
