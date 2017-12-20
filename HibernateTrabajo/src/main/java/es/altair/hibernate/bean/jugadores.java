package es.altair.hibernate.bean;

import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Equipos idEquipo;
	
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
		return idEquipo;
	}

	public void setIdEquipo(Equipos idEquipo) {
		this.idEquipo = idEquipo;
	}

	public jugadores(String nombre, String apellidos, String nickname, Equipos idEquipo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nickname = nickname;
		this.idEquipo = idEquipo;
	}

	@Override
	public String toString() {
		return "jugadores [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nickname=" + nickname
				+ ", idEquipo=" + idEquipo + "]";
	}

	
	
	
	
	
}
