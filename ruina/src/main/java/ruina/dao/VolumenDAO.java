package ruina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ruina.model.DataConnection;
import ruina.model.Volumen;
import ruina.service.ConectionUtil;
/*
 * @Author Raul Tenllado
 */
public class VolumenDAO extends Volumen {
	private static DataConnection dc = new DataConnection("localhost", "almacen", "root", "");
	private static final long serialVersionUID = 1L;
//	private final static String GETBYTITULO = "SELECT titulo,autor,editorial FROM autor WHERE titulo=";
	private final static String INSERTUPDATE = "INSERT INTO volumen (id, id_coleccion, titulo, autor, numero, isbn,"
			+ " editorial, dibujante, entintador, colorista, edicion, color, contenido, leido, portada) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final static String LEIDO = "UPDATE volumen SET leido = ? WHERE volumen.id=?";
	private final static String ELIMINAR = "DELETE FROM volumen WHERE id = ?";
	private final static String UPDATE = "UPDATE volumen SET id_coleccion = ?, titulo = ?, autor = ?, numero = ?, isbn = ?, editorial = ?, dibujante = ?,"
			+ " entintador = ?, colorista = ?, edicion = ?, color = ?, contenido = ?, leido = ?, portada =? "
			+ " WHERE volumen.id=?";
	static List<Volumen> listaComic = new ArrayList<>();

	public VolumenDAO() {
		super();
	}

	public static void addComic(String titulo, String autor, String editorial, String numero, boolean leido) {
		listaComic.add(new Volumen(titulo, autor, editorial, numero, leido));
	}

	public int guardar() {

		int rs = 0;
		Connection con = null;

		try {
			con = ConectionUtil.connect(dc);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(INSERTUPDATE);
				q.setInt(1, this.id);
				q.setInt(2, this.id_coleccion);
				q.setString(3, this.titulo);
				q.setString(4, this.autor);
				q.setString(5, this.numero);
				q.setString(6, this.isbn);
				q.setString(7, this.editorial);
				q.setString(8, this.dibujante);
				q.setString(9, this.entintador);
				q.setString(10, this.colorista);
				q.setString(11, this.edicion);
				q.setString(12, this.color);
				q.setString(13, this.contenido);
				q.setBoolean(14, this.leido);
				q.setString(15, this.portada);
				
				rs = q.executeUpdate();
				q.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	public void  actualizar(Volumen comic) {

		Connection con = null;

		try {
			con = ConectionUtil.connect(dc);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(UPDATE);
				
				q.setInt(1, comic.getId_coleccion());
				q.setString(2, comic.getTitulo());
				q.setString(3, comic.getAutor());
				q.setString(4, comic.getNumero());
				q.setString(5, comic.getIsbn());
				q.setString(6, comic.getEditorial());
				q.setString(7, comic.getDibujante());
				q.setString(8, comic.getEntintador());
				q.setString(9, comic.getColorista());
				q.setString(10, comic.getEdicion());
				q.setString(11,comic.getColor());
				q.setString(12, comic.getContenido());
				q.setBoolean(13, comic.Leido());
				q.setString(14, comic.getPortada());
				q.setInt(15, comic.getId());
				
				q.executeUpdate();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	
	public int eliminar(int id) {
		int rs = 0;
		Connection con = null;

		try {
			con = ConectionUtil.connect(dc);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(ELIMINAR);
				q.setInt(1, id);
				q.execute();
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}

	public static List<Volumen> buscaPorNombre(String nombre) {
		return listaComic;
	}


	public static void leido(boolean leido, int idvol) {
		Connection con = null;

		try {
			con = ConectionUtil.connect(dc);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(LEIDO);
				q.setBoolean(1, leido);
				q.setInt(2, idvol);
				q.executeUpdate();
				
				q.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	public static List<Volumen> obtenerListaComics() {
		List<Volumen> completo = new ArrayList<>();
		try {
			Connection miConexion = ConectionUtil.connect(dc);
			Statement st = miConexion.createStatement();
			String instruccionSQL = "SELECT * FROM volumen  ORDER BY titulo ASC";
			ResultSet rs = st.executeQuery(instruccionSQL);

			while (rs.next()) {
				int id = rs.getInt("id");
				int id_coleccion = rs.getInt("id_coleccion");
				String isbn = rs.getString("isbn");
				String titulo = rs.getString("titulo");
				String autor = rs.getString("autor");
				String editorial = rs.getString("editorial");
				String numero = rs.getString("numero");
				String dibujante = rs.getString("dibujante");
				String entintador = rs.getString("entintador");
				String colorista = rs.getString("colorista");
				String edicion = rs.getString("edicion");
				String color = rs.getString("color");
				String contenido = rs.getString("contenido");
				String portada = rs.getString("portada");
				boolean leido = rs.getBoolean("leido");

				Volumen c = new Volumen(id, id_coleccion, isbn, titulo, autor, editorial, numero, dibujante, entintador,
						colorista, edicion, color, contenido,portada, leido);
				completo.add(c);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			completo = new ArrayList<>();
		}
		return completo;
	}

	public static List<Volumen> obtenerListaComicsLeidos(String condicion) {
		List<Volumen> completo = new ArrayList<>();
		try {
			Connection miConexion = ConectionUtil.connect(dc);
			Statement st = miConexion.createStatement();
			String instruccionSQL = "SELECT * FROM volumen WHERE " + condicion + " ORDER BY titulo ASC ";
			ResultSet rs = st.executeQuery(instruccionSQL);

			while (rs.next()) {
				int id = rs.getInt("id");
				int id_coleccion = rs.getInt("id_coleccion");
				String isbn = rs.getString("isbn");
				String titulo = rs.getString("titulo");
				String autor = rs.getString("autor");
				String editorial = rs.getString("editorial");
				String numero = rs.getString("numero");
				String dibujante = rs.getString("dibujante");
				String entintador = rs.getString("entintador");
				String colorista = rs.getString("colorista");
				String edicion = rs.getString("edicion");
				String color = rs.getString("color");
				String contenido = rs.getString("contenido");
				String portada = rs.getString("portada");
				boolean leido = rs.getBoolean("leido");

				Volumen c = new Volumen(id, id_coleccion, isbn, titulo, autor, editorial, numero, dibujante, entintador,
						colorista, edicion, color, contenido,portada, leido);
				completo.add(c);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			completo = new ArrayList<>();
		}
		return completo;
	}

}
