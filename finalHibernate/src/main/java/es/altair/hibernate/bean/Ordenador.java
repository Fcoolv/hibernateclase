package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="ordenadores")
public class Ordenador implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOrdenador;
	
	@NotNull
	//@NotBlank
	@Size(min = 7, max = 15)
	private String ipNum;
	
	private String sisOperativo;	
	
	@ManyToOne
	@JoinColumn(name="idSala")
	private Sala sala;
	private boolean isActivo;
	
	// Utilizar .EAGER en este caso no es recomendable, la aplicación obtendrá datos de la DB de todos modos.
	// Si esta consulta es muy difícil, esto puede afectar el rendimiento.
	@OneToMany(mappedBy = "ordenador", fetch = FetchType.EAGER)
	private Set<Acceso> acesos = new HashSet<Acceso>();

	public Ordenador() {
		super();
	}

	public Ordenador(int idOrdenador, String ipNum, String sistemaOperativo, Sala sala) {
		super();
		this.idOrdenador = idOrdenador;
		this.ipNum = ipNum;
		this.sisOperativo = sistemaOperativo;		
		this.sala = sala;
		this.isActivo = false;
	}

	public int getIdOrdenador() {
		return idOrdenador;
	}

	public void setIdOrdenador(int idOrdenador) {
		this.idOrdenador = idOrdenador;
	}

	public String getIpNum() {
		return ipNum;
	}

	public void setIpNum(String ipNum) {
		this.ipNum = ipNum;
	}	

	public String getSisOperativo() {
		return sisOperativo;
	}

	public void setSisOperativo(String sisOperativo) {
		this.sisOperativo = sisOperativo;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	public boolean getActivo() {
		return isActivo;
	}

	public void setActivo(boolean isActivo) {
		this.isActivo = isActivo;
	}

	public Set<Acceso> getAcesos() {
		return acesos;
	}

	public void setAcesos(Set<Acceso> acesos) {
		this.acesos = acesos;
	}

	@Override
	public String toString() {
		return "Ordenador [idOrdenador=" + idOrdenador + ", ipNum=" + ipNum + ", sisOperativo=" + sisOperativo
				+ ", sala=" + sala + ", isActivo=" + isActivo + ", acesos=" + acesos + "]";
	}	
	
}
