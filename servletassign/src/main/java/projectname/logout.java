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
 * Servlet implementation class logout
 */
@WebServlet("/logout")
public class logout extends HttpServlet {
	PrintWriter pw;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pw=response.getWriter();
		RequestDispatcher rs=request.getRequestDispatcher("general.html");
		rs.include(request, response);
		HttpSession hp=request.getSession();
		hp.getAttribute("un");
		hp.invalidate();
		pw.print("Loged out successfully");
	}
		


}
