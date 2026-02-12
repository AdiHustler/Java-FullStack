package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateEmployeeTable {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5433/postgres";
        String un = "postgres";
        String pwd = "root";

        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(url, un, pwd);
            Statement stmt = con.createStatement();

            String sql =
                    "CREATE TABLE employee (" +
                    "emp_id SERIAL PRIMARY KEY, " +
                    "emp_name VARCHAR(50), " +
                    "emp_email VARCHAR(50), " +
                    "emp_salary INT" +
                    ")";

            stmt.executeUpdate(sql);
            System.out.println("Employee table created successfully");

            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
