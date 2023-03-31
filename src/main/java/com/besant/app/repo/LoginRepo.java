package com.besant.app.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.besant.app.pojo.Profile;


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

	
	public Profile getuser(String userName) {
		try {
			Profile profile= new Profile();
			Connection con= JdbcConnection.getDbConnection();
			String insertQuery= "select * from profile where username=?";
			PreparedStatement ps= con.prepareStatement(insertQuery);
			ps.setString(1, userName);
			
			ResultSet result =ps.executeQuery();
			
			while(result.next()) {
				String firstName= result.getString("firstname");
				String lastName= result.getString("lastname");
				String email= result.getString("email");
				String phone= result.getString("phone");
				 profile.setName(firstName + " "+lastName);
				 profile.setEmail(email);
				 profile.setPhone(phone);
			}
			return profile;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
