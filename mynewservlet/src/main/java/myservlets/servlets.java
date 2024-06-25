package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlets")
public class servlets extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) {
		try {
			
			int id=Integer.parseInt(req.getParameter("id"));
			String name=req.getParameter("name");
			int salary=Integer.parseInt(req.getParameter("salary"));
			int age=Integer.parseInt(req.getParameter("age"));
			String gender=req.getParameter("gender");
			String d_o_j=req.getParameter("d_o_j");
			String str="insert into employee values(?,?,?,?,?,?);";
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vsb","root" ,"Dhivvya@20" );
			PreparedStatement ps=cn.prepareStatement(str);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, salary);
			ps.setInt(4, age);
			ps.setString(5, gender);
			ps.setString(6, d_o_j);
			ps.execute();
			String str1="select * from employee";
			PreparedStatement ps1=cn.prepareStatement(str1);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
				int id1=rs.getInt("E_id");
				String name1=rs.getString("E_name");
				int sal=rs.getInt("salary");
				int age1=rs.getInt("age");
				String gen=rs.getString("gender");
				String doj=rs.getString("D_O_J");
				
				try {
					PrintWriter pw=res.getWriter();
					pw.println("e_id: "+id1+"e_name: "+name1+"salary: "+sal+"age: "+age1+"gender: "+gen+"doj: "+doj);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
			}
			
			
			System.out.println("created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
