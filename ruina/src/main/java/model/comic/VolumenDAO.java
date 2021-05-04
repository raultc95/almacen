package model.comic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Utilidades.ConectionUtil;
import Utilidades.Utilidades;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import model.DataConnection;

public class VolumenDAO extends Volumen {
	/**
	 * 
	 */
	private static DataConnection dc= new DataConnection("localhost","almacen","root","");
	private static final long serialVersionUID = 1L;
	private final static String GETBYTITULO = "SELECT titulo,autor,editorial FROM autor WHERE titulo=";
	private final static String INSERTUPDATE= "INSERT INTO volumen (id, id_coleccion, titulo, autor, numero, isbn,"
			+ " editorial, dibujante, entintador, colorista, edicion, color, contenido, leido) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
			+ "ON DUPLICATE KEY UPDATE titulo=?,autor=?";
	private final static String LEIDO = "UPDATE volumen SET leido = ? WHERE volumen.id=?";
	private final static String DELETE ="DELETE FROM comic WHERE comic=?";
	

	static List<Volumen> listaComic = new ArrayList<>();

	public VolumenDAO(String titulo,String autor,String editorial,int numero,boolean leido) {
		super(titulo,autor,editorial,numero,leido);
	}
	public VolumenDAO(String titulo,String autor) {
		super(titulo,autor);
	}
	public VolumenDAO() {
		super();
	}
	

	public static List<Volumen> getListaComic() {
		return listaComic;
	}


	public static void setListaComic(List<Volumen> listaComic) {
		VolumenDAO.listaComic = listaComic;
	}

	public static void addComic(String titulo, String autor,String editorial,int numero, boolean leido) {
		listaComic.add(new Volumen(titulo,autor,editorial,numero, leido));
	}
	public VolumenDAO(String titulo) {
		//getByID from MAriaDB
		Connection con=null;
		try {
			con = ConectionUtil.connect(dc);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if (con !=null) {
			try {
				Statement st=con.createStatement();
				String q=GETBYTITULO+""+titulo+"";
				ResultSet rs =st.executeQuery(q);
				
				while(rs.next()) {
					this.titulo=rs.getNString("titulo");
					this.autor=rs.getNString("autor");
					this.editorial=rs.getNString("editorial");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public int guardar() {
		// INSERT o UPDATE
				//INSERT -> si no existe OK
				//En caso de ERROR -> hago un update
				int rs=0;
				Connection con = null;
				try {
					con = ConectionUtil.connect(dc);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if (con != null) {
					try {
						PreparedStatement q=con.prepareStatement(INSERTUPDATE);
						q.setInt(1, this.id);
						q.setString(2, this.id_coleccion);
						q.setString(3, this.titulo);
						q.setString(4, this.autor);
						q.setInt(5, this.numero);
						q.setString(6, this.isbn);
						q.setString(7, this.editorial);
						q.setString(8, this.dibujante);
						q.setString(9, this.entintador);
						q.setString(10, this.colorista);
						q.setString(11, this.edicion);
						q.setString(12, this.color);
						q.setString(13, this.contenido);
						q.setBoolean(14, this.leido);
						q.setString(15, this.titulo);
						q.setString(16, this.autor);
						rs =q.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return rs;
	}
	public int eliminar() {
		//DELETE
		int rs=0;
		Connection con = null;
		try {
			con = ConectionUtil.connect(dc);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (con != null) {
			try {
				PreparedStatement q=con.prepareStatement(LEIDO);
				q.setString(1, this.titulo);
				rs =q.executeUpdate();
				this.titulo="";
				this.autor="";
				this.editorial="";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	public static List<Volumen> buscaPorNombre(String nombre){
		return listaComic;
	}
	
	public static void leido(boolean leido,int idvol) {
		Connection con = null;
		try {
			con = ConectionUtil.connect(dc);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (con != null) {
			try {
				PreparedStatement q=con.prepareStatement(LEIDO);
				q.setBoolean(1,leido);
				q.setInt(2, idvol);
				q.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	
	}

}
