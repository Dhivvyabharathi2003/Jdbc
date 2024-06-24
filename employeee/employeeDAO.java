package employeee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class employeeDAO {
	static Connection cn;
	static PreparedStatement ps;
	ResultSet res;
	String url="jdbc:mysql://localhost:3306/vsb";
	String user="root";
	String pass="Dhivvya@20";
	
	employeeDAO(){
		try {
			cn=DriverManager.getConnection(url,user,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	public static void insert(employeedetails data) {
		System.out.println("");
		
		
		try {
			String str="insert into employee values(?,?,?,?,?,?)";
			ps=cn.prepareStatement(str);
			ps.setInt(1, data.getId());
			ps.setString(2, data.getName());
			ps.setInt(3, data.getSalary());
		    ps.setInt(4, data.getAge());
			ps.setString(5, data.getGender());
			ps.setString(6, data.getD_o_j());
			ps.execute();
			System.out.println("Data entered Successfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		public static void delete(employeedetails data) {
		
			String str="delete employee from employee where e_id=1100" ;
			try {
				ps=cn.prepareStatement(str);
//			    ps.setInt(1, data.getId());
//       		    ps.setString(2, data.getName());
//			    ps.setInt(3, data.getSalary());
//			    ps.setInt(4, data.getAge());
//				ps.setString(5, data.getGender());
//				ps.setString(6, data.getD_o_j());
				ps.execute();
			System.out.println("Data deleted Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
		public static void update(employeedetails data) {
			String str="update employee set age =26 where e_id=101";
			System.out.println("Data updated Successfully");
			try {
				ps=cn.prepareStatement(str);
				ps.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		

	
}
	
