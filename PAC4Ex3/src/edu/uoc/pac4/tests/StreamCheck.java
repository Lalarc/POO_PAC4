package edu.uoc.pac4.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import edu.uoc.pac4.ApprenticeEmployee;
import edu.uoc.pac4.CommissionEmployee;
import edu.uoc.pac4.CommissionEmployeeWithSalary;
import edu.uoc.pac4.Department;
import edu.uoc.pac4.EducationLevel;
import edu.uoc.pac4.Employee;
import edu.uoc.pac4.HourlyEmployee;
import edu.uoc.pac4.SalariedEmployee;
import edu.uoc.pac4.Task;
import edu.uoc.pac4.TaskType;

@TestInstance(Lifecycle.PER_CLASS)

class StreamCheck {
	
	Department department;
	Employee e1, e2, e3, e4, e5 ,e6, e7, e8;
	private ByteArrayOutputStream outContent;
	
	@BeforeAll
	void init(){
		try {
			department = new Department("RRHH", 10);		
			
			e1 = new SalariedEmployee("Maria", "C/uno", "maria@uoc.edu", 1992, EducationLevel.MASTER, 30000.01);
			e2 = new HourlyEmployee("Alberto", "C/dos", "alberto@uoc.edu", 1982, EducationLevel.MASTER, 25, 20);
			e3 = new SalariedEmployee("Juan", "C/tres", "juan@uoc.edu", 1978, EducationLevel.UNDEFINED, 20000.01);
			e4 = new SalariedEmployee("Sara", "C/cuatro", "sara@uoc.edu", 1988, EducationLevel.UNDEFINED, 20000.00);
			e5 = new SalariedEmployee("Fran", "C/cinco", "fran@uoc.edu", 1980, EducationLevel.MASTER, 24000.00);
			e6 = new CommissionEmployeeWithSalary("Lidia", "C/seis", "lidia@uoc.edu", 1971, EducationLevel.UNDEFINED, 24000.00, 4.5);
			((CommissionEmployeeWithSalary)e6).setSales(120000);
			e7 = new CommissionEmployee("Leo", "C/siete", "leo@uoc.edu", 1969, EducationLevel.BACHELOR, 2.5);
			((CommissionEmployee)e7).setSales(500000);
			e8 = new ApprenticeEmployee("Mar", "C/ocho", "mar@uoc.edu", 2003);
			
			Task task1 = new Task("T01: tarea 1", 90,TaskType.FUNCTIONAL);			
			Task task2 = new Task("T02: tarea 2", 80,TaskType.ISSUE);
			Task task3 = new Task("T03: tarea 3", 40,TaskType.MANAGEMENT);			
			
			
			e1.todoTask(task3);
			e2.todoTask(task2);
			e3.todoTask(task3);
			e4.todoTask(task2);
			e5.todoTask(task3);
			e6.todoTask(task1);
			e7.todoTask(task3);
			e8.todoTask(task2);
			
			department.add(e1);
			department.add(e2);
			department.add(e3);
			department.add(e4);
			department.add(e5);
			department.add(e6);
			department.add(e7);
			department.add(e8);
			
		} catch (Exception e) {
			fail("Init failed");
		}
	}
	
	/*@Test
	void testPrint() {
		System.out.println(e1.getName() +": "+ ((SalariedEmployee)e1).calculateSalary());
		System.out.println(e2.getName() +": "+ ((HourlyEmployee)e2).calculateSalary());
		System.out.println(e3.getName() +": "+ ((SalariedEmployee)e3).calculateSalary());
		System.out.println(e4.getName() +": "+ ((SalariedEmployee)e4).calculateSalary());
		System.out.println(e5.getName() +": "+ ((SalariedEmployee)e5).calculateSalary());
		System.out.println(e6.getName() +": "+ ((CommissionEmployeeWithSalary)e6).calculateSalary());
		System.out.println(e7.getName() +": "+ ((CommissionEmployee)e7).calculateSalary());
		System.out.println();
	}*/

	@Test	
	void testResetWorkload80() {
		outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
		assertEquals(40, e1.getWorkload());
		assertEquals(80, e2.getWorkload());
		assertEquals(40, e3.getWorkload());
		assertEquals(80, e4.getWorkload());
		assertEquals(40, e5.getWorkload());
		assertEquals(90, e6.getWorkload());
		assertEquals(40, e7.getWorkload());
		assertEquals(80, e8.getWorkload());
	    
	    department.resetWorkload80();
	    
	    assertEquals(40, e1.getWorkload());
		assertEquals(0, e2.getWorkload());
		assertEquals(40, e3.getWorkload());
		assertEquals(0, e4.getWorkload());
		assertEquals(40, e5.getWorkload());
		assertEquals(0, e6.getWorkload());
		assertEquals(40, e7.getWorkload());
		assertEquals(0, e8.getWorkload());
	    
	    assertEquals("5137", outContent.toString().replaceAll("\n|\r\n", System.getProperty("line.separator").trim()));
	}
	
	
	@Test	
	void testAverageSalary() {
  		assertEquals(22985.71,department.averageSalary(), 0.1);
	}
	
	@Test
	void testGetSalariedEmployeeWithSalaryGreatherThanX() {
		assertEquals(new ArrayList<String>(Arrays.asList("Fran", "Juan", "Maria", "Sara")), department.getSalariedEmployeeWithSalaryGreatherThanX(13300));
		assertEquals(new ArrayList<String>(Arrays.asList("Fran", "Juan", "Maria")), department.getSalariedEmployeeWithSalaryGreatherThanX(20000));
		assertEquals(new ArrayList<String>(Arrays.asList("Maria")), department.getSalariedEmployeeWithSalaryGreatherThanX(30000));
	}
}