package com.masai.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection GEtconnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/mahesh";
			try {
				con=DriverManager.getConnection(url,"root","M13a1h8@");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		
		return con;
		
	}

}
