package es.altair.hibernate03.bean;

public class Artista {

	private int id;
	private String nombre;
	private String apellidos;
	private String edad;
	private String pais;
	
	private int idEstilo;

	

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



	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getIdEstilo() {
		return idEstilo;
	}

	public void setIdEstilo(int idEstilo) {
		this.idEstilo = idEstilo;
	}
	
	public Artista() {
		// TODO Auto-generated constructor stub
	}

	public Artista(int id, String nombre, String apellidos, String edad, String pais, int idEstilo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.pais = pais;
		this.idEstilo = idEstilo;
	}
	public Artista(int id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Artista [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos 
				+ ", edad=" + edad + ", pais=" + pais + ", idEstilo=" + idEstilo + "]";
	}
	
}
