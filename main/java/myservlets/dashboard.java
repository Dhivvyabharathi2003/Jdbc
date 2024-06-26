package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dashboard")
public class dashboard extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		String str="select * from student";
		try {
			Connection cn =DriverManager.getConnection("jdbc:mysql://localhost:3306/vsb","root" ,"Dhivvya@20" );
			PreparedStatement ps=cn.prepareStatement(str);
			ResultSet rs=ps.executeQuery("select * from student");
			while(rs.next()) {
				int rno=rs.getInt("rno");
				String s=rs.getString("name");
				int mark1=rs.getInt("mark1");
				int mark2=rs.getInt("mark2");
				try {
					PrintWriter pw=res.getWriter();
					pw.print("regno: "+rno+" name: "+s+" mark1: "+mark1+" mark2: "+mark2);
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
