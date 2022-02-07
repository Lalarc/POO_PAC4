package edu.uoc.pac4.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import edu.uoc.pac4.ApprenticeEmployee;
import edu.uoc.pac4.EducationLevel;
import edu.uoc.pac4.EmployeeException;
import edu.uoc.pac4.Task;
import edu.uoc.pac4.TaskType;

@TestInstance(Lifecycle.PER_CLASS)

class ApprenticeEmployeeTest {

	ApprenticeEmployee employee;
		
	@BeforeAll
	void testBecarioEmployee() {
		try {
			employee = new ApprenticeEmployee();
			assertEquals("Lorem Ipsum", employee.getName());
			assertEquals(EducationLevel.UNDEFINED, employee.getLevel());
			
			employee = new ApprenticeEmployee("Fran", "Av. Diagonal", "fmanezsa@uoc.edu", 1992);
			assertEquals("Fran", employee.getName());
			assertEquals(EducationLevel.STUDENT, employee.getLevel());
			
		} catch (EmployeeException e) {			
			e.printStackTrace();
			fail("testBecarioEmployee failed");
		}
	}
	
	@Test
	void testTodoTask() {
		
		assertEquals(0, employee.getWorkload());
		Task task1 = new Task("T01: tarea 1", 80,TaskType.FUNCTIONAL);
		Task task2 = new Task("T02: tarea 2", 10,TaskType.TECHNICAL);
		Task task3 = new Task("T03: tarea 3", 10,TaskType.ISSUE);
		Task task4 = new Task("T04: tarea 4", 5,TaskType.MANAGEMENT);
		Task task5 = new Task("T03: tarea 3", 100,TaskType.ISSUE);
		
		try{
			EmployeeException ex = assertThrows(EmployeeException.class, () -> employee.todoTask(task1));
			assertEquals(EmployeeException.MSG_ERR_TASK_NOT_ALLOWED, ex.getMessage());
			assertEquals(0, employee.getWorkload());
			
			ex = assertThrows(EmployeeException.class, () -> employee.todoTask(task2));
			assertEquals(EmployeeException.MSG_ERR_TASK_NOT_ALLOWED, ex.getMessage());
			assertEquals(0, employee.getWorkload());
			
			employee.todoTask(task3);
			assertEquals(10, employee.getWorkload());
			
			ex = assertThrows(EmployeeException.class, () -> employee.todoTask(task4));
			assertEquals(EmployeeException.MSG_ERR_TASK_NOT_ALLOWED, ex.getMessage());
			assertEquals(10, employee.getWorkload());
			
			ex = assertThrows(EmployeeException.class, () -> employee.todoTask(task5));
			assertEquals(EmployeeException.MSG_ERR_WORKLOAD, ex.getMessage());
			assertEquals(10, employee.getWorkload());
		}catch(EmployeeException e) {
			fail("testTodoTask failed");
		}
		
	}
	
	@Test
	void testPresentation() {
		assertEquals("I'm an apprentice", employee.presentation());
	}

	
	@Test
	void testToString() {
	    assertEquals("Apprentice Employee - Name: Fran\nAge: 29\nEmail: fmanezsa@uoc.edu\nEducation level: STUDENT", employee.toString());
	}

}
