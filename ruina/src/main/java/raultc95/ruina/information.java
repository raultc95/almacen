package raultc95.ruina;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.comic.Volumen;
import model.comic.VolumenDAO;

public class information {
	
	
	@FXML
		private ImageView portada;
	@FXML
		private Button guardar;
	
	@FXML 
	private TextField titulo;
	@FXML 
	private TextField autor;
	@FXML 
	private TextField dibujante;
	@FXML
	private TextField colorista;
	@FXML
	private TextField volumen;
	@FXML
	private TextField entintador;
	
	@FXML
	private TextField edicion;
	@FXML
	private TextField color;
	@FXML
	private TextArea contenido;
	@FXML
	private TextField editorial;
	@FXML
	private TextField isbn;
	
	private static VolumenDAO comic;
	
	
	
	@FXML
	protected void initialize(){
		PrimaryController p=new PrimaryController();
		comic=p.comic();
		isbn.setText(comic.getIsbn());
		titulo.setText(comic.getTitulo());
		autor.setText(comic.getAutor());
		editorial.setText(comic.getEditorial());
		dibujante.setText(comic.getDibujante());
		colorista.setText(comic.getColorista());
		volumen.setText(Integer.toString(comic.getNumero()));
		entintador.setText(comic.getEntintador());
		edicion.setText(comic.getEdicion());
		color.setText(comic.getColor());
		contenido.setText(comic.getContenido());
		
	}
  
}