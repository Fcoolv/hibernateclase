package es.altair.hibernate.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="equipojuegos")
public class EquipoJuego {

	
	private int idJuego;
	private int idEquipo;
	
	public EquipoJuego() {
		// TODO Auto-generated constructor stub
	}
	
	public EquipoJuego(int idJuego, int idEquipo) {
		super();
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
		return "EquipoJuego [idJuego=" + idJuego + ", idEquipo=" + idEquipo + "]";
	}
	
	
}
