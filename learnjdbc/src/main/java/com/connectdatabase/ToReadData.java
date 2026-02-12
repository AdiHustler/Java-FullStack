package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ToReadData {

	public static void main(String[] args) {
		
		String url="jdbc:postgresql://localhost:5432/postgres";
		String un="postgres";
		String pwd="root";
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connect=DriverManager.getConnection(url, un, pwd);
			
			// Taking the values from the user dynamically
			String sql="INSERT INTO STUDENT VALUES(?,?,?,?)";
			
			// Prepared Statement is used instead of simple statement
			PreparedStatement pstm = connect.prepareStatement(sql);
			
			Scanner sc = new Scanner(System.in);

	        System.out.print("Enter ID: ");
	        int id = sc.nextInt();
	        sc.nextLine();

	        System.out.print("Enter Name: ");
	        String name = sc.nextLine();

	        System.out.print("Enter Email: ");
	        String email = sc.nextLine();

	        System.out.print("Enter Gender: ");
	        String gender = sc.nextLine();
	        
	        pstm.setInt(1, id);
	        pstm.setString(2, name);
	        pstm.setString(3, email);
	        pstm.setString(4, gender);

	        pstm.executeUpdate();
	        System.out.println("Record inserted successfully!");

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
