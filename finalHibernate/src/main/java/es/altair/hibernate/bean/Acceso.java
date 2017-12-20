package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="accesos")
public class Acceso implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAcceso;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idOrdenador")
	private Ordenador ordenador;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFin;
	
	public Acceso() {
		super();
		
	}

	public Acceso(Usuario usuario, Ordenador ordenador, Date fechaInicio, Date fechaFin) {
		super();
		this.usuario = usuario;
		this.ordenador = ordenador;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public int getIdAcceso() {
		return idAcceso;
	}

	public void setIdAcceso(int idAcceso) {
		this.idAcceso = idAcceso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Ordenador getOrdenador() {
		return ordenador;
	}

	public void setOrdenador(Ordenador ordenador) {
		this.ordenador = ordenador;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return "Acceso [idAcceso=" + idAcceso + ", usuario=" + usuario.getNombre() + ", ordenador=" + ordenador.getIpNum() + ", fechaInicio="
				+ fechaInicio + ", fechaFin=" + fechaFin + "]";
	}

	

	
	
	
}
