package edu.uoc.pac4.tests;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import edu.uoc.pac4.CommissionEmployee;
import edu.uoc.pac4.EducationLevel;
import edu.uoc.pac4.EmployeeException;
import edu.uoc.pac4.Task;
import edu.uoc.pac4.TaskType;

@TestInstance(Lifecycle.PER_CLASS)

class ComissionEmployeeTest {

	CommissionEmployee employee;
	CommissionEmployee employee2;

	
	@BeforeAll
	void testCommissionEmployee() {
		try {
			employee = new CommissionEmployee(3.5);
			assertEquals("Lorem Ipsum", employee.getName());
			assertEquals(EducationLevel.UNDEFINED, employee.getLevel());
			assertEquals(3.5, employee.getCommissionRate());
			assertEquals(0, employee.getSales());
			employee.setSales(1250000);
			assertEquals(1250000, employee.getSales());
			
			EmployeeException ex = assertThrows(EmployeeException.class, () -> new CommissionEmployee(11));
			assertEquals(EmployeeException.MSG_ERR_COMMISSION_RATE, ex.getMessage());
			
			ex = assertThrows(EmployeeException.class, () -> new CommissionEmployee(-1));
			assertEquals(EmployeeException.MSG_ERR_COMMISSION_RATE, ex.getMessage());
			
			employee2 = new CommissionEmployee("Perico", "Av. Diagonal", "fmanezsa@uoc.edu", 1982, EducationLevel.MASTER, 8);
			assertEquals("Perico", employee2.getName());
			assertEquals(8, employee2.getCommissionRate());
			assertEquals(0, employee2.getSales());
			employee2.setSales(800000);
			assertEquals(800000, employee2.getSales());
			
		} catch (EmployeeException e) {			
			e.printStackTrace();
			fail("testCommissionEmployee failed");
		}
	}
	
	@Test
	void testTodoTask() {
		
		assertEquals(0, employee.getWorkload());
		Task task1 = new Task("T01: tarea 1", 80,TaskType.FUNCTIONAL);
		Task task2 = new Task("T02: tarea 2", 10,TaskType.TECHNICAL);
		Task task3 = new Task("T03: tarea 3", 10,TaskType.ISSUE);
		Task task4 = new Task("T04: tarea 4", 5,TaskType.MANAGEMENT);
		Task task5 = new Task("T05: tarea 30", 90,TaskType.MANAGEMENT);
		
		try{
			employee.todoTask(task1);
			assertEquals(80, employee.getWorkload());
			
			EmployeeException ex = assertThrows(EmployeeException.class, () -> employee.todoTask(task2));
			assertEquals(EmployeeException.MSG_ERR_TASK_NOT_ALLOWED, ex.getMessage());
			assertEquals(80, employee.getWorkload());
			
			ex = assertThrows(EmployeeException.class, () -> employee.todoTask(task3));
			assertEquals(EmployeeException.MSG_ERR_TASK_NOT_ALLOWED, ex.getMessage());
			assertEquals(80, employee.getWorkload());
			
			employee.todoTask(task4);
			assertEquals(85, employee.getWorkload());
			
			ex = assertThrows(EmployeeException.class, () -> employee.todoTask(task5));
			assertEquals(EmployeeException.MSG_ERR_WORKLOAD, ex.getMessage());
			assertEquals(85, employee.getWorkload());
		}catch(EmployeeException e) {
			fail("testTodoTask failed");
		}
		
	}
	
	@Test
	void testPresentation() {
		assertEquals("I'm a commission employee", employee.presentation());
	}
	
	@Test
	void testGetPaymentDay() {
		assertEquals(10, employee.getPaymentDay());
	}
	
	@Test
	void testCalculateSalary() {
		assertEquals(43750.00, employee.calculateSalary(), 0.1);
		assertEquals(64000.00, employee2.calculateSalary(), 0.1);
	}
	
	@Test
	void testIncomeTax() throws EmployeeException {
		assertEquals(17500.00, employee.calculateIncomeTax(), 0.1);
		assertEquals(25600.00, employee2.calculateIncomeTax(), 0.1);
		
		CommissionEmployee commissionEmployee = new CommissionEmployee(9);
		commissionEmployee.setSales(131890);
		assertEquals(2255.32,commissionEmployee.calculateIncomeTax(), 0.1);
		
		commissionEmployee.setCommissionRate(2);
		commissionEmployee.setSales(0);
		assertEquals(0,commissionEmployee.calculateIncomeTax(), 0.1);
		
		commissionEmployee.setSales(9000);
		assertEquals(34.2,commissionEmployee.calculateIncomeTax(), 0.1);
	}
	
	@Test
	void testPensionContribution() throws EmployeeException {
		
		assertEquals(3281.25, employee.pensionContribution(), 0.1);
		assertEquals(10560.00, employee2.pensionContribution(), 0.1);
		
		CommissionEmployee commissionEmployee = new CommissionEmployee(4);
		commissionEmployee.setSales(304000);

		assertEquals(52.11,commissionEmployee.pensionContribution(), 0.1);
		
		commissionEmployee.setCommissionRate(2);
		commissionEmployee.setSales(0);
		assertEquals(0,commissionEmployee.pensionContribution(), 0.1);
		
		commissionEmployee.setSales(9000);
		assertEquals(0.0,commissionEmployee.pensionContribution(), 0.1);
		
		
	}
	
	@Test
	void testBonus() {
		double result = employee.bonusExtra();
		assertThat(employee.bonusExtra(), anyOf(equalTo(0.0), equalTo(1.0), equalTo(2.0), equalTo(3.0), equalTo(4.0), equalTo(5.0)));
		assertEquals(result, employee.bonusExtra());
		//test para probar que getBonus no genera nuevos resultados
		assertEquals(result, employee.bonusExtra());
		assertEquals(result, employee.bonusExtra());
		assertEquals(result, employee.bonusExtra());
		
	}	
	
	@Test
	void testToString() {
	    assertEquals("Commission Employee - Name: Lorem Ipsum\nAge: 39\nEmail: lorem@uoc.edu\nEducation level: UNDEFINED", employee.toString());
	}
	
}
