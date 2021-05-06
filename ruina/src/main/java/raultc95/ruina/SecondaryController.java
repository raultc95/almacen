package raultc95.ruina;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import ruina.model.Volumen;
import ruina.dao.VolumenDAO;

public class SecondaryController {
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
	private Button add;

//	private DataConnection dc = new DataConnection("localhost", "almacen", "root", "");
	VolumenDAO comic = new VolumenDAO();

	/**
	 * Llama a VolumenDAO para guardar el comic en la BD
	 *
	 */
	@FXML
	private void addLibro() {
		comic.setIsbn(isbn.getText());
		comic.setTitulo(titulo.getText());
		comic.setAutor(autor.getText());
		comic.setEditorial(editorial.getText());
		comic.setDibujante(dibujante.getText());
		comic.setColorista(colorista.getText());
		comic.setEntintador(entintador.getText());
		comic.setEdicion(edicion.getText());
		comic.setColor(color.getText());
		comic.setContenido(contenido.getText());
		comic.setNumero(volumen.getText());

		comic.guardar();
		System.out.println("Se ha añadido correctamente");
	}

}