/*
Program: Type-4 JDBC Delete

Description:
This program demonstrates how to connect a Java application to a MySQL database
using the Type-4 JDBC driver and delete a record from the "emp" table using
the SQL DELETE statement.

Topics Covered:
- JDBC Driver Loading
- Database Connection
- Statement Interface
- SQL DELETE Query
- executeUpdate()
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

public class Type4Delete {

    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;

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

            // Create Statement
            st = con.createStatement();

            // SQL DELETE Query
            String query = "DELETE FROM emp WHERE empid = 106";

            // Execute Query
            int rows = st.executeUpdate(query);

            System.out.println(rows + " record(s) deleted successfully.");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
