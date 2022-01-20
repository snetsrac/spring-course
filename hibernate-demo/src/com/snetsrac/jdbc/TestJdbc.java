package com.snetsrac.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/hb_student_tracker?ssl=false";
        String username = "hbstudent";
        String password = "hbstudent";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection db = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connection successful.");
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
