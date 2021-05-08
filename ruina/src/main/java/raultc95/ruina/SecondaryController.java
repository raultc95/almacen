package raultc95.ruina;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import ruina.dao.VolumenDAO;

public class SecondaryController  {
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
	@FXML
	private Button portada;
	@FXML
	private AnchorPane anchorpane;
	@FXML
	private ListView listview;

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
		comic.setPortada(portada.getText());
		

		comic.guardar();
		System.out.println("Se ha añadido correctamente");
	}
	@FXML
	public void actionPerformed(ActionEvent e){
		/*FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showOpenDialog(null);
		 
		if (selectedFile != null) {
		 
		    portada.setText("File selected: " + selectedFile.getName());
		}
		else {
		    portada.setText("File selection cancelled.");
		}
		*/
		FileChooser fc3 = new FileChooser();
	       File selectedFile = fc3.showOpenDialog(null);

	        fc3.getExtensionFilters().addAll(
	        new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));


	    if (selectedFile != null) {

	        String location =   (selectedFile.getAbsoluteFile().toURI().toString());
	        System.out.println(location);
	        

	    } else {

	        Alert alert = new Alert(AlertType.CONFIRMATION,"Imagen no seleccionada");

	        alert.showAndWait()
	        .filter(response -> response == ButtonType.OK)
	        .ifPresent((ButtonType response) -> {
	            System.out.println("OK");
	        });

	    }
		
        
		
       
    }


   	
		
	

}