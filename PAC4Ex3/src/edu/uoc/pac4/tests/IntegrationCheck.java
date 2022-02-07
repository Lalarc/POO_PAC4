package edu.uoc.pac4.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

import edu.uoc.pac4.ApprenticeEmployee;
import edu.uoc.pac4.CommissionEmployee;
import edu.uoc.pac4.Department;
import edu.uoc.pac4.EducationLevel;
import edu.uoc.pac4.Employee;
import edu.uoc.pac4.HourlyEmployee;
import edu.uoc.pac4.SalariedEmployee;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class IntegrationCheck {
	Department department1, department2;	
	Employee salaried, hourly, commission, apprentice;
	
	@BeforeAll
	void init(){
		try {
			department1 = new Department("Department 1",3);		
			department2 = new Department("Department 2",6);
			salaried = new SalariedEmployee("Maria", "C/uno", "maria@uoc.edu", 1992, EducationLevel.MASTER, 30000.01);
			hourly = new HourlyEmployee("Alberto", "C/dos", "alberto@uoc.edu", 1982, EducationLevel.MASTER, 25, 20);
			commission = new CommissionEmployee("Leo", "C/siete", "leo@uoc.edu", 1969, EducationLevel.BACHELOR, 2.5);
			((CommissionEmployee)commission).setSales(500000);
			apprentice = new ApprenticeEmployee("Mar", "C/ocho", "mar@uoc.edu", 2003);
		} catch (Exception e) {
			fail("Init failed");
		}
	}
	
	

	@Test
	@Order(1)
	void testIntegration1() {
		try {
			assertEquals(true,department1.add(salaried));		
			assertEquals(1,department1.getEmployees().size());			
			assertEquals(salaried,department1.getEmployees().get(0));
			assertEquals(department1,salaried.getDepartment());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Integration1 failed");
		}
	}
	
	@Test
	@Order(2)
	void testIntegration2() {
		try {
			assertEquals(true,department1.add(hourly));
			assertEquals(true,department1.add(commission));
			assertEquals(3,department1.getEmployees().size());
			assertEquals(false,department1.add(apprentice));
			assertEquals(3,department1.getEmployees().size());
			assertNull(apprentice.getDepartment());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Integration2 failed");
		}
	}
	
	@Test
	@Order(3)
	void testIntegration3()  {		
		try{
			assertFalse(department1.add(salaried));
			assertEquals(3,department1.getEmployees().size());
		}catch(Exception e) {
			e.printStackTrace();
			fail("Integration3 failed");
		}		
	}
	
	@Test
	@Order(4)
	void testIntegration4() {
		try {
			salaried.setDepartment(null);
			assertNull(salaried.getDepartment());
			assertFalse(department1.isEmpty());
			assertEquals(2,department1.getEmployees().size());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Integration4 failed");
		}		
	}
	
	@Test
	@Order(5)
	void testIntegration5() {	
		try {
			salaried.setDepartment(department1);
			assertTrue(department1.getEmployees().contains(salaried));						
			assertEquals(department1,salaried.getDepartment());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Integration5 failed");
		}		
	}
	

	@Test
	@Order(6)
	void testIntegration6() {		
		try {
			department1.remove();
			assertTrue(department1.isEmpty());
			assertNull(salaried.getDepartment());
			assertTrue(department1.add(salaried));
			assertFalse(department1.isEmpty());
			assertFalse(department1.add(salaried));
			assertEquals(1,department1.getEmployees().size());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Integration6 failed");
		}		
	}
	
	@Test
	@Order(7)
	void testIntegration7() {		
		try {
			department1.remove(salaried);
			assertTrue(department1.isEmpty());
			assertEquals(0,department1.getEmployees().size());
			assertNull(salaried.getDepartment());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Integration7 failed");
		}		
	}
	
	@Test
	@Order(8)
	void testIntegration8() {		
		try {
			assertTrue(department1.add(hourly));
			
			NullPointerException ex = assertThrows(NullPointerException.class, () -> department1.add(null));
			assertEquals("[ERROR] Employee object cannot be null!!", ex.getMessage());
			
			assertFalse(department1.exists(salaried));
			assertEquals(hourly,department1.getEmployees().get(0));
			assertEquals(1,department1.getEmployees().size());
			assertTrue(department1.exists(hourly));
			assertNull(salaried.getDepartment());
			assertEquals(department1,hourly.getDepartment());
			assertTrue(department1.add(salaried));
			assertEquals(salaried,department1.getEmployees().get(1));
			assertEquals(2,department1.getEmployees().size());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Integration8 failed");
		}		
	}
	
	@Test
	@Order(9)
	void testIntegration9() {
		try{
			salaried.setDepartment(department2);
			
			assertEquals(1,department1.getEmployees().size());
			assertEquals(1,department2.getEmployees().size());
			hourly.setDepartment(department2);
			assertEquals(0,department1.getEmployees().size());			
			assertTrue(department1.isEmpty());
			assertEquals(hourly,department2.getEmployees().get(0));
			assertEquals(salaried,department2.getEmployees().get(1));
			assertEquals(department2,salaried.getDepartment());
			assertEquals(department2,hourly.getDepartment());
			
		}catch(Exception e) {
			e.printStackTrace();
			fail("Integration9 failed");
		}	
	}
	
	@Test
	@Order(10)
	void testIntegration10() {
		try{
			assertTrue(department2.remove(salaried));
			assertTrue(department2.remove(hourly));
			assertFalse(department2.remove(salaried));
			assertNull(salaried.getDepartment());
			assertNull(hourly.getDepartment());
			assertTrue(department1.isEmpty());
			assertTrue(department2.isEmpty());
		}catch(Exception e) {
			e.printStackTrace();
			fail("Integration10 failed");
		}	
	}
	
	
	@Test
	@Order(11)
	void testIntegration11() {
		try{			
			IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Department("Department 3",0));
			assertEquals("[ERROR] Department's size cannot be 0 or a negative value!!",ex.getMessage());
			Department department3 = new Department("Department 3", 1);
			salaried.setDepartment(department3);
			assertEquals(1,department3.getEmployees().size());
			assertFalse(department3.add(hourly));
			assertFalse(department3.add(commission));
			assertEquals(1,department3.getEmployees().size());
			assertEquals(department3,salaried.getDepartment());
			assertNull(hourly.getDepartment());
			assertNull(commission.getDepartment());
			assertEquals(1,department3.getSize());
			department3.setSize(3);
			assertEquals(3,department3.getSize());
			assertTrue(department3.add(hourly));
			assertTrue(department3.add(commission));
			assertEquals(department3,hourly.getDepartment());
			assertEquals(department3,commission.getDepartment());
			assertEquals(3,department3.getEmployees().size());
			ex = assertThrows(IllegalArgumentException.class, () -> department3.setSize(1));
			assertEquals("[ERROR] Department's size (1) cannot be less than the number of employees (3) that are in the department!!",ex.getMessage());
			department3.setSize(5);
			assertEquals(5,department3.getSize());
		}catch(Exception e) {
			e.printStackTrace();
			fail("Integration11 failed");
		}	
	}
	
	@Test
	@Order(12)
	void testIntegration12() {
		try{
			salaried.setDepartment(department2);
			department2.add(hourly);
			assertEquals("Department: Department 1 - Size: 3 - Employees: 0", department1.toString());
			assertEquals("Department: Department 2 - Size: 6 - Employees: 2", department2.toString());
		}catch(Exception e) {
			e.printStackTrace();
			fail("Integration10 failed");
		}	
	}
	
}
