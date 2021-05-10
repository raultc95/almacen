package raultc95.ruina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import ruina.model.*;
import ruina.dao.*;
import ruina.service.*;
/*
 * @Author Raul Tenllado
 */

public class BotonSello {
	private DataConnection dc = new DataConnection("localhost", "almacen", "root", "");
	
	ColeccionDAO coleccion= new ColeccionDAO();
	@FXML 
	private TextField titulo;
	@FXML
	private Button add;
	@FXML
	private void addColeccion() {
		coleccion.setSerie(titulo.getText());
		
		try {
			Connection miConexion = ConectionUtil.connect(dc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Platform.runLater(() -> {
		        Alert dialog = new Alert(AlertType.ERROR, "NO SE HA PODIDO GUARDAR", ButtonType.OK);
		        dialog.show();
		    });
		}
		coleccion.guardar();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("AÑADIR");
		alert.setHeaderText("AÑADIDO");
		alert.setContentText("COLECCION AÑADIDA CORRECTAMENTE");

		alert.showAndWait();
	}
	
}
