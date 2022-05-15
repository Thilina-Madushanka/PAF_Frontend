package model;

import java.sql.*;

public class connection {
	
	public Connection connect() {
		
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/billcalculation.bill", "root", "");
			
			//for testing
			System.out.print("Database Connected Successfully  ");
			
		}
		catch(Exception e){
			
			e.printStackTrace();
			
		}
		return con;
		
	}

}
