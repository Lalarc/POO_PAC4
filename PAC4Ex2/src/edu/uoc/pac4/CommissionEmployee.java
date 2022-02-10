package edu.uoc.pac4;

public class CommissionEmployee extends Employee{
	
	private double sales;
	private double commissionRate;
	protected double bonus =-1;

	public CommissionEmployee (double commissionRate) throws EmployeeException {
		super();
		setCommissionRate(commissionRate);
	}
	
	public CommissionEmployee (String name, String street, String email, int birthYear, EducationLevel level, double commissionRate) throws EmployeeException {
		super();
		setName(name);
		setStreet(street);
		setEmail(email);
		setBirthYear(birthYear);
		setLevel(level);
		setCommissionRate(commissionRate);
	}
	
	public double getSales() {
		return sales;
	}
	
	public void setSales(double sales) {
		this.sales=sales;
	}
	
	public double getCommissionRate() {
		return commissionRate;
	}
	
	public void setCommissionRate(double commissionRate) {
		this.commissionRate=commissionRate;
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
	
	public double bonusExtra() {
		return 0;
	}
	
	@Override
	public String toString() {
		return "";
	}
}