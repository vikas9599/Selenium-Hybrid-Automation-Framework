package com.v3mobi.utills;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnector {

	public Connection con;
	public Statement stmt;

	public Statement getStatement() throws ClassNotFoundException, SQLException {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";

			/* connection URL of the server */
			String connection = "jdbc:mysql://localhost:3306/customer";
			String userName = "root"; /* Insert username of database */
			String password = "password"; /* Insert Password of database */
			Class.forName(driver);
			con = DriverManager.getConnection(connection, userName, password);
			stmt = con.createStatement();
			return stmt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stmt;
	}

	public void insertData(String query) throws ClassNotFoundException, SQLException {
		Statement sta = getStatement();
		sta.executeUpdate(query);
	}

	public ResultSet getData(String query) throws ClassNotFoundException, SQLException {
		ResultSet data = getStatement().executeQuery(query);
		return data;
	}

	public void updateData(String query) throws ClassNotFoundException, SQLException {
		getStatement().executeUpdate(query);

	}
}
