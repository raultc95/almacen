package raultc95.ruina;

import java.awt.Insets;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ChangeListener;

import Utilidades.ConectionUtil;
import Utilidades.Utilidades;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.DataConnection;
import model.comic.Coleccion;
import model.comic.ColeccionDAO;
import model.comic.Volumen;
import model.comic.VolumenDAO;

public class PrimaryController {
	private DataConnection dc = new DataConnection("localhost", "almacen", "root", "");

	@FXML
	private Button listaCompleta;
	@FXML
	private Button Cpendientes;
	@FXML
	private Button add;
	@FXML
	private MenuItem donacion;
	@FXML
	private Button autor;
	@FXML
	private CheckBox check;

	@FXML
	private TableView<Volumen> tablaComic;
	@FXML
	private TableColumn<Volumen, String> tituloColumna;
	@FXML
	private TableColumn<Volumen, String> editorialColumna;
	@FXML
	private TableColumn<Volumen, String> autorColumna;
	@FXML
	private TableColumn<Volumen, Number> numeroColumna;

	@FXML
	private TableColumn<Volumen, Boolean> leidoColumna;
	
	ArrayList<Volumen> comic= new ArrayList<Volumen>();

	@FXML
	protected void initialize() {
		System.out.println("Bienvenido a LIBRONJAMES");
		System.out.println("Cargando.........");

		configuraTabla();
		
		tablaComic.setRowFactory(tv -> {
			TableRow<Volumen> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
					Volumen rowData = row.getItem();
					System.out.println(rowData);

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
		// cargar de la base de datos
		List<Volumen> completo = new ArrayList<>();
		try {
			Connection miConexion = ConectionUtil.connect(dc);

			Statement st = miConexion.createStatement();
			String instruccionSQL = "SELECT volumen.titulo,volumen.autor, volumen.editorial,volumen.numero,volumen.leido\r\n"
					+ "FROM volumen ORDER BY volumen.titulo ASC";
			ResultSet rs = st.executeQuery(instruccionSQL);

			while (rs.next()) {
				String titulo = rs.getString("titulo");
				String autor = rs.getString("autor");
				String editorial = rs.getString("editorial");
				int numero = rs.getInt("numero");
				boolean leido = rs.getBoolean("leido");

				Volumen c = new Volumen(titulo, autor, editorial, numero, leido);
				completo.add(c);
			}

			rs.close();
			st.close();
		} catch (SQLException e) {
			System.out.println("Error de conexion");
			e.printStackTrace();
		}
		tablaComic.setItems(FXCollections.observableArrayList(completo));
		// tablaComic.getSelectionModel().selectedItemProperty().addListener((Observable));
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
			SimpleIntegerProperty v = new SimpleIntegerProperty();
			v.setValue(cadalibro.getValue().getNumero());
			return v;
		});
		
		leidoColumna.setCellValueFactory(new PropertyValueFactory<Volumen, Boolean>("check"));
		leidoColumna.setCellValueFactory(cadalibro -> {
			SimpleBooleanProperty v = new SimpleBooleanProperty();
			v.setValue(cadalibro.getValue().Leido());
			comic.add(cadalibro.getValue());
			return v;

		});
	
			leidoColumna.setCellFactory(cadalibro -> {
				CheckBoxTableCell<Volumen, Boolean> a = new CheckBoxTableCell<Volumen, Boolean>();
				
				a.setEditable(true);
				//a.setDisable(false);
				a.setOnMouseClicked(event -> {
					System.out.println("se ha pulsado");
				});
				return a;
			});
			leidoColumna.setCellFactory(CheckBoxTableCell.forTableColumn(new Callback<Integer, ObservableValue<Boolean>>() {

			    @Override
			    public ObservableValue<Boolean> call(Integer param) {
			        System.out.println("Cours "+comic.get(param)+" changed value to " +comic.get(param).isLeido());
			        return new ObservableValue<Boolean>(true);
			        
			    }
			}));


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

	public static void addComic(String titulo, String autor, String editorial, int numero, boolean leido) {
		VolumenDAO.addComic(titulo, autor, editorial, numero, leido);
	}
	
	@FXML
	protected void listaCompleta() {
		System.out.println("Pulsando Lista Completa");
		List<Volumen> completo = new ArrayList<>();
		try {
			Connection miConexion = ConectionUtil.connect(dc);
			Statement st = miConexion.createStatement();
			String instruccionSQL = "SELECT volumen.titulo,volumen.autor, volumen.editorial,volumen.numero,volumen.leido\r\n"
					+ "FROM volumen ORDER BY volumen.titulo ASC";
			ResultSet rs = st.executeQuery(instruccionSQL);

			while (rs.next()) {
				String titulo = rs.getString("titulo");
				String autor = rs.getString("autor");
				String editorial = rs.getString("editorial");
				int numero = rs.getInt("numero");
				boolean leido = rs.getBoolean("leido");

				Volumen c = new Volumen(titulo, autor, editorial, numero, leido);
				completo.add(c);
			}

			rs.close();
			st.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		tablaComic.setItems(FXCollections.observableArrayList(completo));
		// tablaComic.getSelectionModel().selectedItemProperty().addListener((Observable));
	}
		

	@FXML
	protected void listaPendientes() {

		System.out.println("Pulsando Lista Pendientes");
		List<Volumen> completo = new ArrayList<>();

		try {
			Connection miConexion = ConectionUtil.connect(dc);
			Statement st = miConexion.createStatement();
			String instruccionSQL = "SELECT volumen.titulo,volumen.autor, volumen.editorial,volumen.numero,volumen.leido\r\n"
					+ "FROM volumen WHERE volumen.leido=false  ORDER BY volumen.titulo ASC";
			ResultSet rs = st.executeQuery(instruccionSQL);

			while (rs.next()) {
				String titulo = rs.getString("titulo");
				String autor = rs.getString("autor");
				String editorial = rs.getString("editorial");
				int numero = rs.getInt("numero");
				boolean leido = rs.getBoolean("leido");

				Volumen c = new Volumen(titulo, autor, editorial, numero,leido);
				completo.add(c);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		tablaComic.setItems(FXCollections.observableArrayList(completo));
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
	private void addAutor() {
		System.out.println("Cargando Añadir Autores.........");
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("autor.fxml"));
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

	// Select * from autor a, left join libro l on where a.dni=l.dni_autor and
	// a.dni=25;
	//
	@FXML
	private void save_xml() {
		Utilidades.saveFile(dc, "conexion");
	}
	
	private void editar() {
		VolumenDAO comic=(VolumenDAO) tablaComic.getSelectionModel().getSelectedItem();
		
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
	 public  VolumenDAO comic() {
		 VolumenDAO comic=(VolumenDAO) tablaComic.getSelectionModel().getSelectedItem();
		return comic;
		   
	   }
}