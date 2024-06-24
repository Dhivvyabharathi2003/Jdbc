package javapackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class jdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try {
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vsb","root","Dhivvya@20");
			String str="insert into emp(e_id,age,salary,e_name) values(106,20,40000,'dhanya')";
			Statement st=cn.createStatement ();
			st.execute(str);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("connection established");
	}

}
