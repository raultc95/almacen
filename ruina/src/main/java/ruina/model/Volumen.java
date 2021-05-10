package ruina.model;

import java.io.Serializable;
import java.sql.Blob;
/*
 * @Author Raul Tenllado 	Damas. Caballeros, Han comido bien, han devorado la riqueza de Gotham, su espiritu
 * 							El banquete llega a su fin, desde este momento, nadie esta ha salvo
 */
public class Volumen implements Serializable {
	protected final static String GETBYTITULO = "SELECT titulo,autor,editorial FROM volumen";
	private static final long serialVersionUID = 1L;
	protected int id;
	protected int id_coleccion;
	protected String isbn;
	protected String titulo;
	protected String autor;
	protected String editorial;
	protected String numero;
	protected String dibujante;
	protected String entintador;
	protected String colorista;
	protected String edicion;
	protected String color;
	protected String contenido;
	protected boolean leido;
	protected String portada;

	public Volumen() { }
	public Volumen(String titulo, String numero, String isbn) {
		this.titulo = titulo;
		this.numero = numero;
		this.isbn = isbn;
	}

	public Volumen(String titulo, String autor, String editorial, String numero, Boolean leido) {
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.numero = numero;
		this.leido = leido;
	}

	public Volumen(int id, int id_coleccion, String isbn, String titulo, String autor, String editorial, String numero,
			String dibujante, String entintador, String colorista, String edicion, String color, String contenido,String portada,
			boolean leido) {
		this.id = id;
		this.id_coleccion = id_coleccion;
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.numero = numero;
		this.dibujante = dibujante;
		this.entintador = entintador;
		this.colorista = colorista;
		this.edicion = edicion;
		this.color = color;
		this.contenido = contenido;
		this.portada = portada;
		this.leido = leido;
	}
	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_coleccion() {
		return id_coleccion;
	}

	public void setId_coleccion(int id_coleccion) {
		this.id_coleccion = id_coleccion;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDibujante() {
		return dibujante;
	}

	public void setDibujante(String dibujante) {
		this.dibujante = dibujante;
	}

	public String getEntintador() {
		return entintador;
	}

	public void setEntintador(String entintador) {
		this.entintador = entintador;
	}

	public String getColorista() {
		return colorista;
	}

	public void setColorista(String colorista) {
		this.colorista = colorista;
	}

	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public void setLeido(boolean leido) {
		this.leido = leido;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getNumero() {
		return numero;
	}

	public Boolean Leido() {
		return leido;
	}

	public void setLeido(Boolean leido) {
		this.leido = leido;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	

	
	public String getPortada() {
		return portada;
	}
	public void setPortada(String portada) {
		this.portada = portada;
	}
	@Override
	public String toString() {
		return ""

				+ "id=" + id + ", id_coleccion=" + id_coleccion + ", isbn=" + isbn + ", titulo=" + titulo
				+ ", autor=" + autor + ", editorial=" + editorial + ", numero=" + numero + ", dibujante=" + dibujante
				+ ", entintador=" + entintador + ", colorista=" + colorista + ", edicion=" + edicion + ", color="
				+ color + ", contenido=" + contenido + ", leido=" + leido
				;
	}

}