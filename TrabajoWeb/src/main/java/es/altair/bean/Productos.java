package es.altair.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Productos implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	private String Nombproducto;
	private float precio;
	private byte[] foto;

	@OneToMany(mappedBy="producto")
	private Set<Ticket> ticket = new HashSet<Ticket>();
	
	public Productos() {
		// TODO Auto-generated constructor stub
	}

	public Productos(String nombproducto, float precio, byte[] foto) {
		super();
		this.Nombproducto = nombproducto;
		this.precio = precio;
		this.foto = foto;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombproducto() {
		return Nombproducto;
	}

	public void setNombproducto(String nombproducto) {
		Nombproducto = nombproducto;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Set<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(Set<Ticket> ticket) {
		this.ticket = ticket;
	}
	
	
}
