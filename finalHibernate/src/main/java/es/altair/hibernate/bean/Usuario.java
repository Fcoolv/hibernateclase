package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;

	@NotNull
	//@NotBlank
	private String nombre;
	
	@NotNull
	//@NotBlank
	private String apellidos;
	
	@NotNull
	//@NotBlank
	//@Email
	private String email;
	
	@NotNull
	//@NotBlank
	private String password;

	@Past
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;

	@OneToMany(mappedBy = "usuario")
	private Set<Acceso> acesos = new HashSet<Acceso>();

	public Usuario() {
		super();
	}

	public Usuario(String nombre, String apellidos, String email, String password, Date fechaRegistro) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.fechaRegistro = fechaRegistro;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Set<Acceso> getAcesos() {
		return acesos;
	}

	public void setAcesos(Set<Acceso> acesos) {
		this.acesos = acesos;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email="
				+ email + ", password=" + password + ", fechaRegistro=" + fechaRegistro + "]";
	}

}
