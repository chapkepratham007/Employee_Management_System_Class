package com.empapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
 
	static Connection con;
	public static Connection createDBConnection() {
		try {
			String url="jdbc:mysql://127.0.0.1:3306/employeeDB";
			String username="root";
			String password="root";
			con=DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
