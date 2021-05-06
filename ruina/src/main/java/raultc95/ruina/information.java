package raultc95.ruina;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import ruina.dao.VolumenDAO;
import ruina.model.Volumen;

public class information {
	@FXML
	private ImageView portada;

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
	@FXML
	private Button eliminar;
	@FXML
	private Button guardar;

	private static Volumen comic;

	private List<Volumen> lista = new ArrayList<>();
	private static int id = 1;
	private static Boolean tabla=true;
	VolumenDAO v = new VolumenDAO();
	

	@FXML
	protected void initialize() {

		lista = VolumenDAO.obtenerListaComicsLeidos("id=" + id);
		comic = lista.get(0);
		isbn.setText(comic.getIsbn());
		titulo.setText(comic.getTitulo());
		autor.setText(comic.getAutor());
		editorial.setText(comic.getEditorial());
		dibujante.setText(comic.getDibujante());
		colorista.setText(comic.getColorista());
		volumen.setText(comic.getNumero());
		entintador.setText(comic.getEntintador());
		edicion.setText(comic.getEdicion());
		color.setText(comic.getColor());
		contenido.setText(comic.getContenido());
	}
	@FXML
	protected void actualizar() {
		System.out.println(comic);
		comic.setId(id);
		comic.setIsbn(isbn.getText());
		comic.setTitulo(titulo.getText());
		comic.setAutor(autor.getText());
		comic.setEditorial(editorial.getText());
		comic.setDibujante(dibujante.getText());
		comic.setColorista(colorista.getText());
		comic.setNumero(volumen.getText());
		comic.setEntintador(entintador.getText());
		comic.setEdicion(edicion.getText());
		comic.setColor(color.getText());
		comic.setContenido(contenido.getText());
		v.actualizar(comic);

	}
	@FXML
	protected void borrar() {
		v.eliminar(id);
		Stage stage = (Stage) eliminar.getScene().getWindow();
		stage.close();

	}
	

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		information.id = id;
	}
	
	public static Boolean getTabla() {
		return tabla;
	}
	
	public static void setTabla(Boolean tabla) {
		information.tabla = tabla;
	}
	

}