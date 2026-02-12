package com.connectdatabase;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class StepstoConnectDatabase {
	public static void main(String[] args){
		
		String url="jdbc:postgresql://localhost:5432/postgres";
		String un="postgres";
		String pwd="root";
		// Load the driver class
		try {
			Class.forName("org.postgresql.Driver"); // forName() imported from 'lang' package, it is imported by default
			
			// To establish Connection
			Connection connect = DriverManager.getConnection(url, un, pwd);
			String sql="UPDATE STUDENT SET gender='MALE' WHERE id=103";
			
			// Create statement - carriers query from java to database
			Statement stmt=connect.createStatement();
			
			// Execute the statement
			stmt.execute(sql);
			
			// Close the connection
			connect.close()	;
			
			System.out.println("Connection Created");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}   
		
		
	}
}
