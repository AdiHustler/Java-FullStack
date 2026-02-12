package com.connectdatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class ToReadFromStudentByDelimeter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		
		String url="jdbc:postgresql://localhost:5433/postgres";
		String un="postgres";
		String pwd="root";
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connect;
			try {
				connect = DriverManager.getConnection(url,un,pwd);
				
				
				String sql="insert into student values(?,?,?,?)";
				PreparedStatement pstm=connect.prepareStatement(sql);
				
				
				System.out.println("Enter Id: ");
				int id=sc.nextInt();
				System.out.println("Enter Name: ");
				String name=sc.next();
				System.out.println("Enter email: ");
				String email=sc.next();
				System.out.println("Enter gender: ");
				String gender=sc.next();
				
				pstm.setInt(1, id);
				pstm.setString(2, name);
				pstm.setString(3, email);
				pstm.setString(4, gender);
				
				
				pstm.execute();
				
				System.out.println("Data inserted...........");
				pstm.close();
				
				
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
