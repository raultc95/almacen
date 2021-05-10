package ruina.service;

import java.sql.*;

import ruina.model.DataConnection;
/*
 * @Author Raul Tenllado
 */

public class ConectionUtil {

	public static Connection connect(DataConnection c) throws SQLException {
		Connection conn = null;

		if (c == null) {
			return null;
		}

		conn = DriverManager.getConnection("jdbc:mysql://" + c.getHost() + "/" + c.getDb(), c.getUser(), c.getPassword());
		return conn;
	}

}
