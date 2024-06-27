package projectname;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		RequestDispatcher rs=request.getRequestDispatcher("general.html");
		rs.include(request, response);
	
	HttpSession hs=request.getSession(false);
	if(hs!=null) {
		String op=(String)hs.getAttribute("un");
		pw.print("hello "+ op);
	}
	else {
		pw.print("you need to login first");
		RequestDispatcher ds=request.getRequestDispatcher("login.html");
		ds.include(request, response);
	}

}
}