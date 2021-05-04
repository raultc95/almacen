package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DataConnection")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataConnection {
	private String host;
	private String db;
	private String user;
	private String password;

	public DataConnection(String host, String db, String user, String password) {
		super();
		this.host = host;
		this.db = db;
		this.user = user;
		this.password = password;
	}

	public DataConnection() {
		super();
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}