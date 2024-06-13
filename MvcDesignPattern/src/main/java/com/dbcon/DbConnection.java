package com.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	public Connection getConnection()
	{
		Connection con =  null;
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvcDb","ananya" ,"ananya220701");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		 return con;
	}

}
