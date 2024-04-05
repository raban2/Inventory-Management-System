package com.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDb {
	
	
	
   public static Connection getDbConnection() {
	   try {
		   Class.forName("com.mysql.cj.jdbc.Driver");

		    return DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketemployeedb", "root",
					"admin@123");
	} catch (Exception e) {
	  e.printStackTrace();
	}
	   return null;
   }
}
