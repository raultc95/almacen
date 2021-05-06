package ruina.model;

import java.io.Serializable;

public class Coleccion implements Serializable {
	private static final long serialVersionUID = 1L;
	protected int id;
	protected String titulo;
		
	public Coleccion(int id, String titulo) {
		super();
		this.id=id;
		this.titulo=titulo;
	}

	public Coleccion() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Coleccion [id=" + id + ", titulo=" + titulo + "]";
	}

}