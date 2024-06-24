package employeee;

public class main {
	public static void main(String[] args) {
		employeedetails emp = new employeedetails(102,"dhilan",300000,20,"male","2024-02,17");
		//new employeeDAO();
		//employeeDAO.insert(emp);
		//new employeeDAO().delete(emp);
		new employeeDAO().update(emp);
		
	}
	

}
