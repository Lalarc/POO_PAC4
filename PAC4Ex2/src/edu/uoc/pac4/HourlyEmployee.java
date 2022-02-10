package edu.uoc.pac4;

public class HourlyEmployee extends Employee{
	
	private int WEEKS_YEAR = 50;
	private double wage;
	private double hours;
	
	public HourlyEmployee(double wage, double hours) throws EmployeeException {
		super();
		setWage(wage);
		setHours(hours);
	}
	
	public HourlyEmployee(String name, String street, String email, int birthYear, EducationLevel level, double wage, double hours) throws EmployeeException {
		super();
		setName(name);
		setStreet(street);
		setEmail(email);
		setBirthYear(birthYear);
		setLevel(level);
		setWage(wage);
		setHours(hours);
	}
	
	public double getWage() {
		return wage;
	}
	
	public void setWage(double wage) {
		this.wage=wage;
	}
	
	public double getHours() {
		return hours;
	}
	
	public void setHours(double hours) {
		this.hours=hours;
	}
	
	public void todoTask(Task task) {
		
	}
	
	public String presentation() {
		return "";
	}
	
	public int getPaymentDay() {
		return 0;
	}
	
	public double calculateSalary() {
		return 0;
	}
	
	@Override
	public String toString() {
		return "";
	}

}
