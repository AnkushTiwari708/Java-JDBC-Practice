/*
Program: Type-4 JDBC Insert User Data

Description:
This program demonstrates how to accept employee details from the user and
insert them into a MySQL database using the Type-4 JDBC driver and the
Statement interface.

Topics Covered:
- JDBC Driver Loading
- Database Connection
- User Input using Scanner
- Statement Interface
- SQL INSERT Query
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
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Type4InsertUserData {

    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;
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

            // Establish Database Connection
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/db40",
                    "root",
                    "root");

            // Create Statement
            st = con.createStatement();

            // SQL INSERT Query
            String query = "INSERT INTO emp VALUES('"
                    + id + "','"
                    + name + "','"
                    + salary + "','"
                    + city + "')";

            // Execute Query
            int rows = st.executeUpdate(query);

            if(rows > 0)
            {
                System.out.println(rows + " record(s) inserted successfully.");
            }
            else
            {
                System.out.println("Record insertion failed.");
            }

            // Close Resources
            st.close();
            con.close();
            sc.close();

        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
    }
}
