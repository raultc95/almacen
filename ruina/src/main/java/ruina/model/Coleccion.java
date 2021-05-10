package ruina.model;

import java.io.Serializable;
/*
 * @Author : Raul Tenllado 		Ha llegado la hora... lo sabes en lo mas profundo de tu alma... Porque yo soy tu alma 
 */
public class Coleccion implements Serializable {
	private static final long serialVersionUID = 1L;
	protected int id;
	protected  String serie;
		
	public Coleccion(int id, String serie) {
		super();
		this.id=id;
		this.serie=serie;
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

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	@Override
	public String toString() {
		return "Coleccion [id=" + id + ", titulo=" + serie + "]";
	}

}