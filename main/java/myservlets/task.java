package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/task")
public class task extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) {
		String st=req.getParameter("f1");
		String st1=req.getParameter("f2");
		try {
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vsb","root","Dhivvya@20");
			String str="select * from studentlogin";
			PreparedStatement ps=cn.prepareStatement(str);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String n1=rs.getString("uname");
				String n2=rs.getString("pass");
				int n3=rs.getInt("marks");
			
				try {
					PrintWriter pw=res.getWriter();
					if(st.equals(n1) && st1.equals(n2)){
						pw.print("username: "+n1+" password: "+n2+" marks: "+n3);
						break;
					}
					else {
						pw.print("invalid entry");
						break;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}