package login1;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class login extends HttpServlet {
//	Connection cn;
//	PreparedStatement ps;
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		PrintWriter pw = null;
		String user=req.getParameter("username");
		String pass=req.getParameter("password");
	RequestDispatcher rs=req.getRequestDispatcher("general.html");
	rs.include(req,res);
	
	if(user.equals("dhivvya") && pass.equals("39")) {
		HttpSession hp=req.getSession();
		hp.setAttribute("un",user);
			pw.print("login successfull");
			RequestDispatcher rd1=req.getRequestDispatcher("Dashboard");
			rd1.forward(req, res);
		
	}
	else {
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.forward(req, res);
	
	}
	}
	}
       
    

