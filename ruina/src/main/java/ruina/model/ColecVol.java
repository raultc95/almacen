package ruina.model;
/*
 * @Author Raul Tenllado 	
 */

public class ColecVol {

	private String coleccion;
	private String titulo;
	private String numero;
	private String isbn;

	public ColecVol() {
		super();
	}

	public ColecVol(String coleccion, String titulo, String numero, String isbn) {
		this.coleccion = coleccion;
		this.titulo = titulo;
		this.numero = numero;
		this.isbn = isbn;

	}

	public String getColeccion() {
		return coleccion;
	}

	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
