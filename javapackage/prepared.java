package javapackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class prepared {
   public static void main(String[] args) {
	   String str="create table hospital(hname varchar(20),pname varchar(20),pid int)";
	   Connection con;
	try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Vsb", "root","Dhivvya@20");
		PreparedStatement ps=con.prepareStatement(str);
		ps.execute();
		System.out.println("table created successfully");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
}
