package raultc95.ruina;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import ruina.dao.VolumenDAO;
import ruina.model.Volumen;
/*
 * @Author Raul Tenllado
 */

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
	private static Boolean tabla = true;
	VolumenDAO v = new VolumenDAO();
	private String imagePath = "";

	@FXML
	protected void initialize() throws FileNotFoundException {

		lista = VolumenDAO.obtenerListaComicsLeidos("id=" + id);

		comic = lista.get(0);
		imagePath = comic.getPortada();
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

		String caratula = comic.getPortada();

		if (caratula != null && !caratula.trim().equals("")) {
			FileInputStream inputstream = new FileInputStream(caratula);
			Image image = new Image(inputstream);
			portada.setImage(image);
		}

	}

	@FXML
	protected void actualizar() {

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
		comic.setPortada(imagePath);

		v.actualizar(comic);

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("ACTUALIZAR");
		alert.setHeaderText("ACTUALIZACION");
		alert.setContentText("COMIC ACTUALIZADO CORRECTAMENTE");

		alert.showAndWait();
	}

	@FXML
	protected void actualizarPortada() throws FileNotFoundException {
		FileChooser fc3 = new FileChooser();
		File selectedFile = fc3.showOpenDialog(null);

		fc3.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));

		if (selectedFile != null) {

			imagePath = selectedFile.getAbsolutePath();
			FileInputStream inputstream = new FileInputStream(imagePath);
			Image image = new Image(inputstream);
			portada.setImage(image);

		} else {

			Alert alert = new Alert(AlertType.CONFIRMATION, "Imagen no seleccionada");

			alert.showAndWait().filter(response -> response == ButtonType.OK).ifPresent((ButtonType response) -> {
				System.out.println("OK");
			});
		}

	}

	@FXML
	protected void borrar() {
		Alert alert = new Alert(AlertType.CONFIRMATION, "VA A ELIMINAR UN COMIC DEL ALMACEN ¿ESTA SEGURO?");

		alert.showAndWait().filter(response -> response == ButtonType.OK).ifPresent((ButtonType response) -> {
			v.eliminar(id);
			Stage stage = (Stage) eliminar.getScene().getWindow();
			stage.close();
		});



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