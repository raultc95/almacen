package model.comic;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.WritableBooleanValue;
import javafx.scene.control.CheckBox;

public class Volumen implements Serializable {
	/**
	 * 
	 */
	protected final static String GETBYTITULO="SELECT titulo,autor,editorial FROM volumen";
	private static final long serialVersionUID = 1L;
	protected int id;
	protected String id_coleccion;
	protected String isbn;
	protected  String titulo;
	protected String autor;
	protected String editorial;
	protected int numero;
	protected String dibujante;
	protected String entintador;
	protected String colorista;
	protected String edicion;
	protected String color;
	protected String contenido;
	protected boolean leido;
	
	private SimpleBooleanProperty checked = new SimpleBooleanProperty(false);
	
	private ArrayList<Coleccion> volumenes;
	
	public Volumen() {
		
	}
	
	public Volumen(String titulo, String autor,String editorial,int numero, Boolean leido) {

		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.numero= numero;
		this.leido=leido;
		
	}
	public Volumen(String titulo,String autor) {
		this(titulo,autor,"desconocido");
	}
	public Volumen(String autor) {
		this.autor=autor;
	}
	public Volumen(String titulo,String autor,String editorial) {
		
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

	public String getId_coleccion() {
		return id_coleccion;
	}

	public void setId_coleccion(String id_coleccion) {
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

	@Override
	public String toString() {
		return titulo + "," +autor+","+editorial +","+leido;
	}
	public int getNumero() {
		return numero;
	}
	
	
	/*public CheckBox getCheck() {
		return check;
	}

	public void setCheck(CheckBox check) {
		this.check = check;
	}*/

	public Boolean Leido() {
		return leido;
	}

	public void setLeido(Boolean leido) {
		this.leido = leido;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public boolean isLeido() {
		
	/*for (Volumen v :volumenes) {
			if(!v.isEsLeido()) {
				return false;
			}
	}
	*/
	return true;
	
	}
	
	

}