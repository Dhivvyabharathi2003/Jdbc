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

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
public void doGet(HttpServletRequest req ,HttpServletResponse res) {
	String username=req.getParameter("f1");
	String pass =req.getParameter("f2");
	boolean check=valid.isvalid(username, pass);
	if(check) {
		String str="Select marks from studentlogin where username=? and pass=?";
		
		Connection cn;
		try {
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vsb","root","Dhivvya@20");
			PreparedStatement ps=cn.prepareStatement(str);
			ps.setString(1,username);
			ps.setString(2, pass);
			
	
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
//				String s=rs.getString("username");
//				String s1=rs.getString("pass");
				int mark=rs.getInt("marks");
				try {
					PrintWriter pw=res.getWriter();
					pw.println(mark);
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
	else {
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		try {
			rd.forward(req,res);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("no");
	}
}
}
