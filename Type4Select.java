/*
Program: Type-4 JDBC Select
Topic: JDBC, MySQL, Statement, ResultSet

Description:
This program demonstrates how to connect a Java application to a MySQL database
using the Type-4 JDBC driver and retrieve records from the "emp" table using a SQL SELECT query.

Technologies Used:
- Java
- JDBC
- MySQL
- Connection
- Statement
- ResultSet
*/
package testdatabase;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Type4Select {
    public static void main(String[] args) {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    try
    {
     Class.forName("com.mysql.cj.jdbc.Driver");
     System.out.println("loaded");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3307/db40","root","root");
        System.out.println("connected");
        st= con.createStatement();
        String quary = "SELECT * FROM emp";
        rs = st.executeQuery(quary);
        while(rs.next())
        {
            System.out.print(rs.getString(1)+"\t");
            System.out.print(rs.getString(2)+"\t");
            System.out.print(rs.getString(3)+"\t");
            System.out.print(rs.getString(4)+"\n");
       }
}
    catch(ClassNotFoundException | SQLException e)
    {
    System.out.println(e);
}
    
}
}
