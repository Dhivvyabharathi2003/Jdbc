package javapackage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ass {
	public static void main(String[] args) {
		try {
			String str="insert into employee values(?,?,?,?,?,?)";
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vsb","root","Dhivvya@20");
			PreparedStatement ps=con.prepareStatement(str);
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter employee details");
			System.out.println("Enter E_id");
			ps.setInt(1, sc.nextInt());
			System.out.println("Enter E_name");
			ps.setString(2,sc.next());
			System.out.println("Enter salary");
			ps.setInt(3, sc.nextInt());
			System.out.println("Enter age");
			ps.setString(4, sc.next());
			System.out.println("Enter gender");
			ps.setString(5,sc.next());
			System.out.println("d_o_j");
			ps.setString(6,sc.next());
			ps.execute();
			
			
			String str1="select* from employee";
			PreparedStatement ps1=con.prepareStatement(str1);
			ResultSet rs=ps1.executeQuery("select* from employee");
			
			while(rs.next()) {
				int E_id1= rs.getInt(1);	
				String e_name1=rs.getString(2);
				int age1= rs.getInt(3);
				int salary1= rs.getInt(4);
				String gender1 =rs.getString(5);
				String d_o_j1=rs.getString(6);
				System.out.println(E_id1+" "+e_name1+" "+age1+" "+salary1+" "+gender1+" "+d_o_j1+" ");
				
				
				}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block;
			e.printStackTrace();
		}
	}
}
