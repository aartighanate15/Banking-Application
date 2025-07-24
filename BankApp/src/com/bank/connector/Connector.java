package com.bank.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
		public static Connection requestCon() {

			Connection con = null;
			String url="jdbc:mysql://localhost:3306/bank";
			String Pass="shona22";
			String user="root";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url,user,Pass);				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return con;
		}
		
	
}
