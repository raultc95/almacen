package raultc95.ruina;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ruina.model.DataConnection;
import ruina.model.Volumen;
import ruina.dao.VolumenDAO;
import ruina.service.Utilidades;

public class PrimaryController {
	@FXML
	private Button listaCompleta;
	@FXML
	private Button Cpendientes;
	@FXML
	private Button add;
	@FXML
	private Button editar;
	@FXML
	private MenuItem donacion;
	@FXML
	private Button coleccion;
	@FXML
	private Button listaColecciones;
	@FXML
	private CheckBox check;
	@FXML
	private  TableView<Volumen> tablaComic;
	@FXML
	private TableColumn<Volumen, String> tituloColumna;
	@FXML
	private TableColumn<Volumen, String> editorialColumna;
	@FXML
	private TableColumn<Volumen, String> autorColumna;
	@FXML
	private TableColumn<Volumen, String> numeroColumna;
	@FXML
	private TableColumn<Volumen, CheckBox> leidoColumna;

	private DataConnection dc = new DataConnection("localhost", "almacen", "root", "");
	private static boolean tablaCompleta = true;
	private Alert alerta = new Alert(AlertType.CONFIRMATION);

	@FXML
	protected void initialize() {
		alerta.setContentText("Bienvenido a LIBRONJAMES");
		alerta.showAndWait();
		System.out.println("Bienvenido a LIBRONJAMES");
		System.out.println("Cargando.........");

		configuraTabla();

		tablaComic.setRowFactory(tv -> {
			TableRow<Volumen> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
					information.setId(row.getItem().getId());
					information.setTabla(tablaCompleta);
					// Abrir ventana de información
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("information.fxml"));
					Parent root = null;

					try {
						root = fxmlLoader.load();
					} catch (IOException e) {

						e.printStackTrace();
					}
					
					
					
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setOpacity(1);
					stage.setTitle("INFORMACION");
					stage.setScene(new Scene(root));
					stage.setResizable(false);
					stage.showAndWait();
				}
			});
			return row;
		});
		// cargar listacompleta
		listaCompleta();
	}

	private void configuraTabla() {

		tituloColumna.setCellValueFactory(cadalibro -> {
			SimpleStringProperty v = new SimpleStringProperty();
			v.setValue(cadalibro.getValue().getTitulo());
			return v;
		});
		autorColumna.setCellValueFactory(cadalibro -> {
			SimpleStringProperty v = new SimpleStringProperty();
			v.setValue(cadalibro.getValue().getAutor());
			return v;
		});
		editorialColumna.setCellValueFactory(cadalibro -> {
			SimpleStringProperty v = new SimpleStringProperty();
			v.setValue(cadalibro.getValue().getEditorial());
			return v;
		});
		numeroColumna.setCellValueFactory(cadalibro -> {
			SimpleStringProperty v = new SimpleStringProperty();
			v.setValue(cadalibro.getValue().getNumero());
			return v;
		});

		leidoColumna.setCellValueFactory(cadalibro -> {
			CheckBox checkBox = new CheckBox();
			checkBox.selectedProperty().setValue(cadalibro.getValue().Leido());
			checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
				public void changed(ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) {
					cadalibro.getValue().setLeido(new_val);
					System.out.println(cadalibro.getValue().getId() + " " + cadalibro.getValue().Leido());
					VolumenDAO.leido(cadalibro.getValue().Leido(), cadalibro.getValue().getId());
					if (tablaCompleta) {
						listaCompleta();
					} else {
						listaPendientes();
					}
				}
			});
			return new SimpleObjectProperty<CheckBox>(checkBox);
		});

	}

	@FXML
	private void pulsado() {
		System.out.println("Cargando Añadir.........");
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("secondary.fxml"));
		Parent root = null;
		try {
			root = fxmlLoader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setOpacity(1);
		stage.setTitle("AÑADIR");
		stage.setScene(new Scene(root));
		stage.setResizable(false);
		stage.getIcons().add(new Image("file:pruebaportada.jpg"));
		stage.showAndWait();
	}

	public static void addComic(String titulo, String autor, String editorial, String numero, boolean leido) {
		VolumenDAO.addComic(titulo, autor, editorial, numero, leido);
	}

	@FXML
	protected  void listaCompleta() {
		System.out.println("Pulsando Lista Completa");
		List<Volumen> completo = new ArrayList<>();
		completo = VolumenDAO.obtenerListaComics();
		tablaComic.setItems(FXCollections.observableArrayList(completo));
		tablaCompleta = true;
	}

	@FXML
	protected  void listaPendientes() {
		System.out.println("Pulsando Lista Pendientes");
		List<Volumen> completo = new ArrayList<>();
		completo = VolumenDAO.obtenerListaComicsLeidos("leido=false");
		tablaComic.setItems(FXCollections.observableArrayList(completo));
		tablaCompleta = false;
	}

	@FXML
	private void donacion() {
		System.out.println("Cargando donacion.........");
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("donation.fxml"));
		Parent root = null;
		try {
			root = fxmlLoader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setOpacity(1);
		stage.setTitle("APOYA");
		stage.setScene(new Scene(root));
		stage.setResizable(false);
		stage.showAndWait();
	}

	@FXML
	private void informacion() {
		System.out.println("Cargando Información.........");
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sobre.fxml"));
		Parent root = null;
		try {
			root = fxmlLoader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setOpacity(1);
		stage.setTitle("AGRADECIMIENTOS");
		stage.setScene(new Scene(root));
		stage.setResizable(false);
		stage.showAndWait();
	}

	@FXML
	private void addColeccion() {
		System.out.println("Cargando Añadir Autores.........");
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("coleccion.fxml"));
		Parent root = null;
		try {
			root = fxmlLoader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setOpacity(1);
		stage.setTitle("AÑADIR COLECCION");
		stage.getIcons().add(new Image(App.class.getResourceAsStream("Black.jpg")));
		stage.setScene(new Scene(root));
		stage.setResizable(false);
		stage.showAndWait();
	}

	
	@FXML
	private void save_xml() {
		Utilidades.saveFile(dc, "conexion");
	}
	
	@FXML
	private void editar() {
		Volumen comic = tablaComic.getSelectionModel().getSelectedItem();
		
		information.setId(comic.getId());
//		List<Volumen>lista=VolumenDAO.obtenerListaComicsLeidos("id="+comic.getId());
//		comic=lista.get(0);
//		System.out.println(comic);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("information.fxml"));
		Parent root = null;

		try {
			root = fxmlLoader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setOpacity(1);
		stage.setTitle("INFORMACION");
		stage.setScene(new Scene(root));
		stage.setResizable(false);
		stage.showAndWait();
	}

	@SuppressWarnings("exports")
	public VolumenDAO comic() {
		VolumenDAO comic = (VolumenDAO) tablaComic.getSelectionModel().getSelectedItem();
		return comic;

	}

	@FXML
	private void listColecciones() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tablacolecciones.fxml"));
		Parent root = null;

		try {
			root = fxmlLoader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setOpacity(1);
		stage.setTitle("LISTADO DE COLECCIONES");
		stage.setScene(new Scene(root));
		stage.setResizable(false);
		stage.showAndWait();
	}
		
	


}