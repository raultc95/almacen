package Utilidades;

import java.sql.*;

import model.DataConnection;

public class ConectionUtil {
	public static Connection connect(DataConnection c) throws SQLException {
    Connection conn=null;
    if(c==null){
        return null;
    }
    //Class.forName("com.mysql.jdbc.Driver");
    conn=DriverManager.getConnection("jdbc:mysql://"+c.getHost()+"/"+c.getDb(),c.getUser(),c.getPassword());
    return conn;
}

}
