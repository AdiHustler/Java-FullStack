package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StepsToConnectDatabase {
	
	public static void main(String[] args) {
		//load the driver class
		String url="jdbc:postgresql://localhost:5433/postgres";
		String un="postgres";
		String pwd="root";
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Class loaded");
			
			// to establish connection
			try {
				Connection connect=DriverManager.getConnection(url,un,pwd);
				
				String sql="insert into student values(2,'virat','virat12@gmail.com','Male'),(3,'rohit','rohti@gmail.com','male')";
				
				//create stmt
				Statement stmt=connect.createStatement();
				
				//exuecute query
				stmt.execute(sql);
				
				//close connection
				connect.close();
				
				System.out.println("data inserted");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
