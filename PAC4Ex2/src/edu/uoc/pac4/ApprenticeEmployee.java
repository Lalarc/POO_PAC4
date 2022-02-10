package edu.uoc.pac4;

public class ApprenticeEmployee extends Employee{
	
	public ApprenticeEmployee() throws EmployeeException {
		super();
	}
	
	public ApprenticeEmployee(String name, String street, String email) throws EmployeeException {
		super();
		setName(name);
		setStreet(street);
		setEmail(email);
	}
	
	public void todoTask(Task task) {
		
	}
	
	public String presentation() {
		return "";
	}
	
	@Override
	public String toString() {
		return"";
	}

}
