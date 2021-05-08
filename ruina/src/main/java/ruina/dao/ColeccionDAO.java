package ruina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ruina.model.ColecVol;
import ruina.model.Coleccion;
import ruina.model.DataConnection;
import ruina.model.Volumen;
import ruina.service.ConectionUtil;

public class ColeccionDAO extends Coleccion {
	private static DataConnection dc = new DataConnection("localhost", "almacen", "root", "");
	private static final long serialVersionUID = 1L;
	private final static String GETCOL = "SELECT coleccion.serie, volumen.titulo ,volumen.numero, volumen.isbn "
			+ " FROM coleccion, volumen " + " WHERE coleccion.id=volumen.id_coleccion ORDER BY coleccion.serie";
	private final static String INSERTCOL = "INSERT INTO coleccion (serie) VALUES (?) ON DUPLICATE KEY UPDATE serie=?";

	private static String titulov;
	private static String isbn;
	private static String numero;

	public ColeccionDAO() {
		super();
	}

	public ColeccionDAO(String titulo) {
		// getByID from MAriaDB
		Connection con = null;
		try {
			con = ConectionUtil.connect(dc);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (con != null) {
			try {
				Statement st = con.createStatement();
				String q = GETCOL + "" + serie + "";
				ResultSet rs = st.executeQuery(q);

				while (rs.next()) {
					this.serie = rs.getNString("serie");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int guardar() {
		// INSERT o UPDATE
		// INSERT -> si no existe OK
		// En caso de ERROR -> hago un update
		int rs = 0;
		Connection con = null;
		try {
			con = ConectionUtil.connect(dc);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(INSERTCOL);
				q.setString(1, this.serie);
				q.setString(2, this.serie);

				rs = q.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}

	public static List<ColecVol> obtenerListaColecciones() {
		List<ColecVol> listado = new ArrayList<>();
		try {
			Connection miConexion = ConectionUtil.connect(dc);
			Statement st = miConexion.createStatement();

			ResultSet rs = st.executeQuery(GETCOL);

			while (rs.next()) {
				// int id = rs.getInt("id");
				String tituloc = rs.getString("serie");
				titulov = rs.getString("titulo");
				numero = rs.getString("numero");
				isbn = rs.getString("isbn");

				ColecVol c = new ColecVol(tituloc, titulov, numero, isbn);

				listado.add(c);

			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			listado = new ArrayList<>();
		}
		return listado;
	}

	public String getTitulov() {
		return titulov;
	}

	public void setTitulov(String titulov) {
		this.titulov = titulov;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
