package edu.uoc.pac4;

import java.time.LocalDate;

/**
 * @author Fran
 * @version 1.0
 *
 * This class represents a employee of a company
 */
public class Employee {

	/**
	 * Employee's id
	 */
	private int id;
	
	/**
	 * Class field that allows to create unique ids
	 */
	private static int nextId  = 0;
	
	/**
	 * Employee's name (max. 50 chars)
	 */
	private String name;
	
	/**
	 * Employee's street
	 */
	private String street;
	
	/**
	 * Employee's salary (in range [13300, 60000])
	 */
	private double salary;
	
	/**
	 * Employee's email (contains '@')
	 */
	private String email;
	
	/**
	 * Employee's birth Year (>= 18 years old)
	 */
	private int birthYear;
	
	/**
	 * Default constructor:
	 * 	name = "Lorem Ipsum".
	 *  street = "Sesame Street"
	 *  salary = 50000
	 *  email = "lorem@uoc.edu"
	 *  birthYear = 1982
	 *  @throws Exception is never thrown because the values of the fields are correct	  
	 */
	public Employee() throws Exception {
		this("Lorem Ipsum", "Sesame Street", 50000, "lorem@uoc.edu", 1982);
	}

	/**
	 * Parameterized constructor
	 * @param name Employee's name (max. 50 chars)
	 * @param street Employee's street
	 * @param salary Employee's salary (in range [13300, 60000])
	 * @param email Employee's email (contains '@')
	 * @param birthYear  Employee's year born (>= 18 years old)
	 * @throws Exception when name has more than 50 chars, or salary is out of [13300, 50000], or email not contains '@' or birthYear is smaller than 18
	 */
	public Employee(String name, String street, double salary, String email, int birthYear) throws Exception {
		setName(name);
		setStreet(street);
		setSalary(salary);
		setEmail(email);
		setBirthYear(birthYear);
		setId();
	}

	/**
	 * Getter of "id"
	 * @return Value of the field "id"
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter of "id". It assigns "nextId" value to "id" and increases "nextId" by using "incNextId()".
	 */
	private void setId() {
		this.id = getNextId();
		incNextId();
	}

	/**
	 * Getter of "nextId"
	 * @return nextId's value
	 */
	public static int getNextId() {
		return nextId;
	}
	
	/**
	 * Increases one unit the value of "nextId" 
	 */
	private void incNextId(){
		nextId++;
	}

	/**
	 * Getter of "name"
	 * @return Employee's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter of "name"
	 * @param name New name that we want to assign to the employee
	 * @throws Exception When the new name has more than 50 characters
	 */
	public void setName(String name) throws Exception {
		if(name.length()>50) {
			throw new Exception("[ERROR] Employee's name cannot be longer than 50 characters");
		}else {
			this.name = name;
		}
	}

	/**
	 * Getter of "street"
	 * @return Employee's street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Setter of "street"
	 * @param street New street that we want to assign to the employee
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Getter of "salary"
	 * @return Employee's salary
	 */
	public double getSalary() {		
		return salary;
	}
	
	/**
	 * Setter of "salary"
	 * @param salary New salary that we want to assign to the employee
	 * @throws Exception When the new salary is out of the range [13300,60000]	
	 */
	public void setSalary(double salary) throws Exception {
		if(salary<13300 || salary>60000) {
			throw new Exception("[ERROR] Employee's salary must be in range [13300,60000]");
		}else {
			this.salary = salary;
		}
	}

	/**
	 * Getter of "email"
	 * @return Employee's email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter of "email"
	 * @param email New email that we want to assign to the employee
	 * @throws Exception When the new email not contains '@'
	 */
	public void setEmail(String email) throws Exception {
		
		if(!email.contains("@")) {
			throw new Exception("[ERROR] Employee's email does not have the correct format");
		}else {
			this.email = email;
		}
	}

	/**
	 * Getter of "birthYear"
	 * @return Employee's birthYear
	 */
	public int getBirthYear() {
		return birthYear;
	}

	/**
	 * Setter of "birthYear"
	 * @param birthYear capacity New birthYear that we want to assign to the employee
	 * @throws Exception When the new birthYear is smaller than 18
	 */
	public void setBirthYear(int birthYear) throws Exception {
		if(birthYear > LocalDate.now().getYear()-18) {	
			throw new Exception("[ERROR] Employee's age must be greater than or equal to 18 years old");
		}else {
			this.birthYear = birthYear;
		}
	}
	
}
