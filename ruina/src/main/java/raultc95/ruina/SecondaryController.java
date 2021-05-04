package raultc95.ruina;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Utilidades.ConectionUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.DataConnection;
import model.comic.Coleccion;
import model.comic.Volumen;
import model.comic.VolumenDAO;


public class SecondaryController {
		
	private DataConnection dc= new DataConnection("localhost","almacen","root","");
	 VolumenDAO comic = new VolumenDAO();
    	@FXML 
    	private TextField titulo;
    	@FXML 
    	private TextField autor;
    	@FXML 
    	private TextField dibujante;
    	@FXML
    	private TextField colorista;
    	@FXML
    	private Spinner<Volumen> volumen;
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
    	/*
    	String textTitulo;
    	String textAutor;
    	String textDibujante;
    	String textColorista;
    	//int numVolumen=volumen.getValueFactory();
    	String textEntintador;
    	String textEdicion;
    	String textColor;
    	String textContenido;
    	String textEditorial;
    	*/
    	@FXML
    	private void addLibro() {
    		comic.setIsbn(isbn.getText());
    		comic.setTitulo(titulo.getText());
        	comic.setAutor(autor.getText());
        	 comic.setEditorial(editorial.getText());
        	 comic.setDibujante(dibujante.getText());
        	comic.setColorista(colorista.getText());
        	//int numVolumen=volumen.getValueFactory();
        	//comic.setNumero(Integer.parseInt(volumen.getPromptText()));
        	 comic.setEntintador(entintador.getText());
        	 comic.setEdicion(edicion.getText());
        	 comic.setColor(color.getText());
        	 comic.setContenido(contenido.getText());
        	
    	 	 
    		try {
    			Connection miConexion = ConectionUtil.connect(dc);
    			comic.guardar();
    			
    			 /*Statement st = miConexion.createStatement();
    			String instruccionSQL = "SELECT volumen.titulo,volumen.autor, volumen.editorial,volumen.numero,volumen.leido\r\n"
    					+ "FROM volumen";
    			ResultSet rs = st.executeQuery(instruccionSQL);
    			
    			while(rs.next()) {
    				String titulo=rs.getString("titulo");
    				String autor=rs.getString("autor");
    				String editorial=rs.getString("editorial");
    				int numero=rs.getInt("numero");
    				boolean leido=rs.getBoolean("leido");
    				
    				Volumen c=new Volumen(titulo,autor,editorial,numero,leido);
    				completo.add(c);
    			}
    			
    			rs.close();
    			st.close();*/
    		} catch (SQLException e) {
    			
    			e.printStackTrace();
    		}
    		
    		
    		//PrimaryController.addComic(titulo.getText(), autor.getText(),editorial.getText(), 0, false);
    		
    		System.out.println("Se ha añadido correctamente");
    	}
    	
}