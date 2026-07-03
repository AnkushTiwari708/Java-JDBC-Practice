/*
Program: Type-4 JDBC PreparedStatement Insert

Description:
This program demonstrates how to insert user data into a MySQL database
using the Type-4 JDBC driver and the PreparedStatement interface.

Topics Covered:
- JDBC Driver Loading
- Database Connection
- User Input using Scanner
- PreparedStatement Interface
- Parameterized SQL Query
- executeUpdate()
- Resource Management
- Exception Handling

Technologies Used:
- Java
- JDBC
- MySQL

Author: Ankush Tiwari
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Type4PreparedStatement {

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement pst = null;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Salary: ");
        int salary = sc.nextInt();

        System.out.print("Enter City: ");
        String city = sc.next();

        try {

            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully.");

            // Establish Database Connection
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/db40",
                    "root",
                    "root");

            System.out.println("Database Connected Successfully.");

            // Create PreparedStatement
            pst = con.prepareStatement(
                    "INSERT INTO emp VALUES(?,?,?,?)");

            // Set Parameters
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setInt(3, salary);
            pst.setString(4, city);

            // Execute Query
            int rows = pst.executeUpdate();

            if(rows > 0)
            {
                System.out.println(rows + " record(s) inserted successfully.");
            }
            else
            {
                System.out.println("Record insertion failed.");
            }

            // Close Resources
            pst.close();
            con.close();
            sc.close();

        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
    }
}
