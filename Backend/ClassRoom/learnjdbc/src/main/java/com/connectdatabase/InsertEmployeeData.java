package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEmployeeData {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5433/postgres";
        String un = "postgres";
        String pwd = "root";

        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(url, un, pwd);
            Statement stmt = con.createStatement();

            String sql =
                    "INSERT INTO employee (emp_name, emp_email, emp_salary) VALUES " +
                    "('Amit', 'amit@gmail.com', 45000), " +
                    "('Ravi', 'ravi@gmail.com', 38000), " +
                    "('Neha', 'neha@gmail.com', 52000)";

            int rows = stmt.executeUpdate(sql);
            System.out.println(rows + " rows inserted successfully");

            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
