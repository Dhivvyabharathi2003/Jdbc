package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/assign")
public class assign extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) {
		String st=req.getParameter("f1");
		String st1=req.getParameter("f2");
		String str="Select * from studentlogin where username=? and pass=?";
		
		try {
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vsb","root","Dhivvya@20");
			PreparedStatement ps=cn.prepareStatement(str);
			ps.setString(1,st);
			ps.setString(2, st1);
			ResultSet rs=ps.executeQuery();
		   
		     
		    while(rs.next()) {
		    	String n=rs.getString("username");
		    	String n2=rs.getString("pass");
		    	int m=rs.getInt("marks");
		    	 try {
					PrintWriter pw=res.getWriter();
					if(n.equals(st) && n2.equals(st1)) {
						pw.print("valid entry");
						
					RequestDispatcher rd=req.getRequestDispatcher("dashboard.java");
					try {
						rd.forward(req,res);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
						
						
						
						
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
