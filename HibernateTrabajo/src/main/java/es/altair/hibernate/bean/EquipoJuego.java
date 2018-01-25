package es.altair.hibernate.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="equipojuegos")
public class EquipoJuego {
	
	@Id
	private int id;
	
	private int idJuego;
	private int idEquipo;
	
	public EquipoJuego() {
		// TODO Auto-generated constructor stub
	}
	
	public EquipoJuego(int id,int idJuego, int idEquipo) {
		super();
		this.id = id;
		this.idJuego = idJuego;
		this.idEquipo = idEquipo;
	}


	public int getIdJuego() {
		return idJuego;
	}


	public void setIdJuego(int idJuego) {
		this.idJuego = idJuego;
	}


	public int getIdEquipo() {
		return idEquipo;
	}


	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}


	@Override
	public String toString() {
		return "EquipoJuego [" + id + "-- idJuego=" + idJuego + ", idEquipo=" + idEquipo + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
