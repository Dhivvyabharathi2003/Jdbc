package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/connection")
public class connection extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		try {
			String str="create table studentlogin(uname varchar(20),pass varchar(20),marks int);";
			Connection cn=null;

			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vsb","root" ,"Dhivvya@20" );
			PreparedStatement ps=cn.prepareStatement(str);
			PrintWriter pw=res.getWriter();
			ps.execute();
			pw.write("created");
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
