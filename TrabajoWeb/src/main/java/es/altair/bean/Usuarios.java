package es.altair.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuarios implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsuario;
	private String email;
	private String password;
	private String nombre;
	private String apellido;
	private int tipo;
	
	
	@OneToMany(mappedBy="usuario")
	private Set<Ticket> ticket = new HashSet<Ticket>();
	
	public Usuarios() {
		// TODO Auto-generated constructor stub
	}

	public Usuarios(String email, String password, String nombre, String apellido, int tipo) {
		super();
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo = tipo;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Set<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(Set<Ticket> ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Usuarios [idUsuario=" + idUsuario + ", email=" + email + ", password=" + password + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", tipo=" + tipo + "]";
	}
	
	
}
