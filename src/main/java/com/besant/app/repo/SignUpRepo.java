package com.besant.app.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpRepo {

	public boolean insertIntoProfile(String userName, String password, 
			String email, String firstName,
			String lastName,String phone) {
		try {
			Connection con= JdbcConnection.getDbConnection();
			String insertQuery= "insert into profile values (?,?,?,?,?,?)";
			PreparedStatement ps= con.prepareStatement(insertQuery);
			ps.setString(1, userName);
			ps.setString(2, password);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			ps.setString(5, email);
			ps.setString(6, phone);
			
			int result =ps.executeUpdate();
			
			return result ==1;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return false;
	}
}
