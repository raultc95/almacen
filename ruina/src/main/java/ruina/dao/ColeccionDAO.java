package ruina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ruina.model.Coleccion;
import ruina.model.DataConnection;
import ruina.service.ConectionUtil;

public class ColeccionDAO extends Coleccion {
	private DataConnection dc = new DataConnection("localhost", "almacen", "root", "");
	private static final long serialVersionUID = 1L;
	private final static String GETCOL = "SELECT coleccion.titulo FROM coleccion";
	private final static String INSERTCOL = "INSERT INTO coleccion (titulo) VALUES (?) ON DUPLICATE KEY UPDATE titulo=?";

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
				String q = GETCOL + "" + titulo + "";
				ResultSet rs = st.executeQuery(q);

				while (rs.next()) {
					this.titulo = rs.getNString("titulo");
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
				q.setString(1, this.titulo);
				q.setString(2, this.titulo);

				rs = q.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}

}
