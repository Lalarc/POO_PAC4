package edu.uoc.pac4;

public class SalariedEmployee extends Employee {

	double salary;
	
	public SalariedEmployee(double salary) throws EmployeeException{
		super();
		setSalary(salary);
	}
	
	public SalariedEmployee(String name, String street, String email, int birthYear, EducationLevel level, double salary) throws EmployeeException {
		super();
		setName(name);
		setStreet(street);
		setEmail(email);
		setBirthYear(birthYear);
		setLevel(level);
		setSalary(salary);
	}
	
	@Override
	public double getSalary() {
		return salary;
	}
	
	@Override
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void todoTask(Task task) {
		
	}
	
	public String presentation() {
		return "";
	}
	
	public String presentation(boolean showSalary) {
		return "";
	}
	
	public int getPaymentDay() {
		return 0;
	}
	
	public double calculateSalary() {
		return 0;
	}
	
	public String toString() {
		return "";
	}
}
