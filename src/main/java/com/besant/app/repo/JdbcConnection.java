package com.besant.app.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {
	
	static Connection getDbConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/application";		
		Connection connection= DriverManager.getConnection(url, "root", "Pass@123");	
		return  connection;		
	}

}
