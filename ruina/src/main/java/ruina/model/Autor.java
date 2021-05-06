package ruina.model;

import java.io.Serializable;

public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre;

	public Autor(String nombre) {

		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}

}