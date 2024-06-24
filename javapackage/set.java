package javapackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class set {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str="insert into hospital (hname,pname,pid)values(?,?,?)";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Vsb", "root","Dhivvya@20");
			PreparedStatement ps=con.prepareStatement(str);
			
			System.out.println("enter details :");
			
			String hname=sc.next();
			String pname=sc.next();
			int pid=sc.nextInt();
			
			ps.setString(1,hname);
			ps.setString(2,pname);
			ps.setInt(3,pid);
			  ps.execute();
		
			    String str1="select * from hospital";
	
				PreparedStatement ps1=con.prepareStatement(str1);
				ResultSet rs=ps1.executeQuery("select*from hospital");
			
         while(rs.next()) { 
        	 while(rs.next()) {
 	        	String hname1=rs.getString(1);
 	        	String pname1=rs.getString(2);
 	        	int pid1=rs.getInt(3);
 	        
 	        	System.out.println(hname1+" "+pname1+" "+pid1+" ");
         }
		}
       
		}
         catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
         }
	}

}
