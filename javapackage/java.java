package javapackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="select * from emp";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Vsb", "root","Dhivvya@20");
			PreparedStatement ps=con.prepareStatement(str);
			ps.execute();
			System.out.println("table :");
	        ResultSet rs=ps.executeQuery("select*from emp");
	        while(rs.next()) {
	        	int e_id=rs.getInt(1);
	        	int age=rs.getInt(2);
	        	int salary=rs.getInt(3);
	        	String e_name=rs.getNString(4);
	        	System.out.println(e_id+" "+age+" "+salary+" "+e_name+" ");
	        }
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	


	}

}
