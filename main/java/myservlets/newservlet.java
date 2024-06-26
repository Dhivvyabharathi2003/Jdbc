package myservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/newservlet")
public class newservlet extends HttpServlet {
    public void service(HttpServletRequest req ,HttpServletResponse res) {
    	HttpSession hs=req.getSession();
    	String data= (String)hs.getAttribute("name");
    	PrintWriter pw;
		try {
			pw = res.getWriter();
			pw.print(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
