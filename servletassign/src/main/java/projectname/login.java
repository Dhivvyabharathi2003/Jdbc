package projectname;

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
import javax.servlet.http.HttpSession;

import org.apache.coyote.http11.Http11InputBuffer;

@WebServlet("/login")
public class login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String str="select * from studentlogin";
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vsb","root","Dhivvya@20");
			PreparedStatement ps=cn.prepareStatement(str);
			PrintWriter pw=response.getWriter();
			String user=request.getParameter("username");
			String pass=request.getParameter("password");
			RequestDispatcher rs=request.getRequestDispatcher("general.html");
			rs.include(request, response);
			ResultSet r =ps.executeQuery();
			while(r.next()) {
				String st=r.getString("username");
				String pas=r.getString("pass");
			
		if(user.equals(st)&&pass.equals(pas)) {
			HttpSession hp=request.getSession();
			hp.setAttribute("un",user);
            pw.print("Login Successfully");
			RequestDispatcher rd=request.getRequestDispatcher("Dashboard");
			rd.forward(request, response);
			
		}
		else {
			RequestDispatcher rd1=request.getRequestDispatcher("login.html");
			rd1.forward(request, response);
			
		}
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
