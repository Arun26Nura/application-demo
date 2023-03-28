package com.besant.app.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginRepo {
	
	public boolean checkValidUser(String userName, String password) {
		try {
			String dbPassword=null;
			Connection con= JdbcConnection.getDbConnection();
			String insertQuery= "select * from profile where username=?";
			PreparedStatement ps= con.prepareStatement(insertQuery);
			ps.setString(1, userName);
			
			ResultSet result =ps.executeQuery();
			
			while(result.next()) {
				dbPassword= result.getString("password");
			}
			
			return dbPassword !=null && password.equals(dbPassword);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return false;
	}

}
