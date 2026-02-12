package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class CrudOnEmpTable {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter number to perform action: ");
		int n=sc.nextInt();
		switch(n) {
			case 1:{addEmployee();
					break;
			}
			case 2:{
				deleteData();
				break;
			}
			case 3:{
				updateData();
				break;
			}
			case 4:{
				findData();
				break;
			}
			default: {
				System.out.println("Enter valid number: ");
			}
		}		
	}
	
	public  static void addEmployee() {
		
		String url="jdbc:postgresql://localhost:5433/postgres";
		String un="postgres";
		String pwd="root";
		
		
		try {
			Connection connect=DriverManager.getConnection(url,un,pwd);
			
			
			System.out.println("Enter Id:");
			int id=sc.nextInt();
			System.out.println("Enter name:");
			String name=sc.next();
			System.out.println("Enter email:");
			String email=sc.next();
			System.out.println("Enter salary:");
			int salary=sc.nextInt();
			
			String sql="insert into employee values(?,?,?,?)";
			
			PreparedStatement pstm=connect.prepareStatement(sql);
			
			
			pstm.setInt(1, id);
			pstm.setString(2, name);
			pstm.setString(3, email);
			pstm.setInt(4, salary);
			
			
			pstm.execute();
			
			System.out.println("Data inserted...........");
			pstm.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void deleteData() {

		String url="jdbc:postgresql://localhost:5433/postgres";
		String un="postgres";
		String pwd="root";
		
		
		try {
			Connection connect=DriverManager.getConnection(url,un,pwd);
			
			
			
			String sql="delete from employee where emp_id=?";
			
			PreparedStatement pstm=connect.prepareStatement(sql);
			
			System.out.println("Enter id to delete:");
			int id=sc.nextInt();
			
			pstm.setInt(1, id);
			
			
			pstm.execute();
			
			System.out.println("Data delete...........");
			pstm.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void updateData() {

		String url="jdbc:postgresql://localhost:5433/postgres";
		String un="postgres";
		String pwd="root";
		
		
		try {
			Connection connect=DriverManager.getConnection(url,un,pwd);
			
			
			System.out.println("Enter Id to update:");
			int id=sc.nextInt();
			System.out.println("Enter salary to update:");
			int salary=sc.nextInt();
			
			String sql="update employee set emp_salary=? where emp_id=?";
			
			PreparedStatement pstm=connect.prepareStatement(sql);
			
			pstm.setInt(2, salary);
			pstm.setInt(1, id);
			
			
			
			pstm.execute();
			
			System.out.println("Data update...........");
			pstm.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void findData() {

	    String url="jdbc:postgresql://localhost:5433/postgres";
	    String un="postgres";
	    String pwd="root";

	    try {
	        Connection connect=DriverManager.getConnection(url,un,pwd);

	        System.out.println("Enter Id to find:");
	        int id=sc.nextInt();

	        String sql="select * from employee where emp_id=?";
	        PreparedStatement pstm=connect.prepareStatement(sql);
	        pstm.setInt(1, id);

	        ResultSet rs = pstm.executeQuery();

	        if(rs.next()) {
	            System.out.println(
	                rs.getInt(1) + " " +
	                rs.getString(2) + " " +
	                rs.getString(3) + " " +
	                rs.getInt(4)
	            );
	        } else {
	            System.out.println("Record not found");
	        }

	        rs.close();
	        pstm.close();
	        connect.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


}
