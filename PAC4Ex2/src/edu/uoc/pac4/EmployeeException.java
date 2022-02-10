package edu.uoc.pac4;

public class EmployeeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static String MSG_ERR_NAME ="[ERROR] Employee's name cannot be longer than 50 characters";
	public final static String MSG_ERR_SALARY ="[ERROR] Employee's salary must be in range [13300,60000]";
	public final static String MSG_ERR_EMAIL ="[ERROR] Employee's email does not have the correct format";
	public final static String MSG_ERR_AGE ="[ERROR] Employee's age must be greater than or equal to 18 years old";
	
	public EmployeeException() {
		super();
	}
	public EmployeeException(String msg) {
		super(msg);
	}
}

