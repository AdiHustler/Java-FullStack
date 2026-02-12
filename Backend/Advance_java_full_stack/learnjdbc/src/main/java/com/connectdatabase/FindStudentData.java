package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class FindStudentData {
	public static void main(String[] args) {
		
		String url="jdbc:postgresql://localhost:5433/postgres";
		String un="postgres";
		String pwd="root";
		try {
			Class.forName("org.postgresql.Driver");
			
			
			try {
				Connection connect=DriverManager.getConnection(url,un,pwd);
				
				Statement stmt=connect.createStatement();
				
				String sql="select * from student";
				
				
				ResultSet res=stmt.executeQuery(sql);
				
				while(res.next()) {
					System.out.println(res.getInt(1)+" -> "+res.getString(2)+" -> "+res.getString(3)+" -> "+res.getString(4));
				}
				
				
				stmt.close();
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
