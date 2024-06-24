package employeee;

public class employeedetails {
             int  id;
             String name;
             int salary;
             int age;
             String gender;
             String d_o_j;
               
             
             employeedetails(int id, String name, int salary, int age, String gender, String d_o_j ){
            	 this.id=id;
            	 this.name=name;
            	 this .salary=salary;
            	 this.age=age;
            	 this.gender=gender;
            	 this.d_o_j=d_o_j;
            	 
             }


			public int getId() {
				return id;
			}


			public void setId(int id) {
				this.id = id;
			}


			public String getName() {
				return name;
			}

			

			public void setName(String name) {
				this.name = name;
			}


			public int getSalary() {
				return salary;
			}


			public void setSalary(int salary) {
				this.salary = salary;
			}


			public int getAge() {
				return age;
			}


			public void setAge(int age) {
				this.age = age;
			}


			public String getGender() {
				return gender;
			}


			public void setGender(String gender) {
				this.gender = gender;
			}


			public String getD_o_j() {
				return d_o_j;
			}


			public void setD_o_j(String d_o_j) {
				this.d_o_j = d_o_j;
			}
}
