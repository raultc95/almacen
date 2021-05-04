package Almacen;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import model.autor.Autor;
import model.comic.Coleccion;

import model.comic.Volumen;

import java.io.Serializable;
import java.util.ArrayList;
@XmlRootElement(name="Almacen")
@XmlAccessorType(XmlAccessType.FIELD)

public class Almacen implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Autor> listaAutores=new ArrayList<>();
	ArrayList<Volumen> listaComic = new ArrayList<Volumen>();
	ArrayList<Coleccion> listaVolumen = new ArrayList<Coleccion>();
	@XmlElement(name="comic")
	
	private static Almacen almacen;
	
	public Almacen() {
		
	}
	
	public void TodoslosAutores() {
		listaAutores.forEach(p->System.out.println(p));
	}
	public void TodoslosComics() {
		listaComic.forEach(p->System.out.println(p));
	}
	public void addComic(Volumen c) {
		listaComic.add(c);
		
	}
	public void addAutor(Autor c) {
		listaAutores.add(c);
	}
	
	public ArrayList<Volumen> getListaComic() {
		return listaComic;
	}

	public void setListaComic(ArrayList<Volumen> listaComic) {
		this.listaComic = listaComic;
	}
	
	public void borrarComic(Volumen titulo) {
		for (Volumen comic : listaComic) {
			if(comic.getTitulo().equals(titulo)) {
				listaComic.remove(comic);
		}
		}
			
		
	}

	@Override
	public String toString() {
		return "";
	}

	public static synchronized Almacen getInstance( ) {
	      if (almacen == null)
	    	  almacen=new Almacen();
	      return almacen;
	 }

}
