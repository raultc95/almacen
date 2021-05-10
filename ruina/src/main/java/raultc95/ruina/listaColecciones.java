package raultc95.ruina;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ruina.dao.ColeccionDAO;
import ruina.dao.VolumenDAO;
import ruina.model.ColecVol;
import ruina.model.Coleccion;
import ruina.model.Volumen;
/*
 * @Author Raul Tenllado
 */

public class listaColecciones {
	@FXML
	private  TableView<ColecVol> tablaColecciones;
	@FXML
	private TableColumn<ColecVol, String> coleccionColumna;
	@FXML
	private TableColumn<ColecVol, String> tituloColumna;
	@FXML
	private TableColumn<ColecVol, String> volumenColumna;
	@FXML
	private TableColumn<ColecVol, String> isbnColumna;
	
	
	@FXML
	protected void initialize() {
		listarTabla();
		mostrarTabla();
	}
	@FXML
	private void listarTabla() {
		coleccionColumna.setCellValueFactory(cadacoleccion -> {
			SimpleStringProperty v = new SimpleStringProperty();
			v.setValue(cadacoleccion.getValue().getColeccion());
			return v;
		});
		tituloColumna.setCellValueFactory(cadacoleccion -> {
			SimpleStringProperty v = new SimpleStringProperty();
			v.setValue(cadacoleccion.getValue().getTitulo());
			return v;
		});
		volumenColumna.setCellValueFactory(cadacoleccion -> {
			SimpleStringProperty v = new SimpleStringProperty();
			v.setValue(cadacoleccion.getValue().getNumero());
			return v;
		});
		isbnColumna.setCellValueFactory(cadacoleccion -> {
			SimpleStringProperty v = new SimpleStringProperty();
			v.setValue(cadacoleccion.getValue().getIsbn());
			return v;
		});
	}
	private void mostrarTabla() {
		List<ColecVol> completo = new ArrayList<>();
		completo = ColeccionDAO.obtenerListaColecciones();
		tablaColecciones.setItems(FXCollections.observableArrayList(completo));
	}

}
