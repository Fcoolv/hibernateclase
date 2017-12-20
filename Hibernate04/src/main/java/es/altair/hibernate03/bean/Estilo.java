package es.altair.hibernate03.bean;

public class Estilo {
	private int idestilo;
	private String nEstilo;
	public int getIdestilo() {
		return idestilo;
	}
	public void setIdestilo(int idestilo) {
		this.idestilo = idestilo;
	}
	public String getnEstilo() {
		return nEstilo;
	}
	public void setTipo(String tipo) {
		this.nEstilo = tipo;
	}
	public Estilo(int idestilo, String nEstilo) {
		super();
		this.idestilo = idestilo;
		this.nEstilo = nEstilo;
	}
	public Estilo() {
		super();
	}
	@Override
	public String toString() {
		return "Estilo [idestilos=" + idestilo + ", tipo=" + nEstilo + "]";
	}
}
