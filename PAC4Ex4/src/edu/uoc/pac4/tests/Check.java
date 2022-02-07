package edu.uoc.pac4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.uoc.pac4.Company;

class Check {
	
	@Test
	void test1() {
		Company c1 = new Company("UOCompany S.L.","12345678-B", 41.98123, 2.1344, "Fran");
		try {
			Company c2 = (Company) c1.clone();
			assertNotEquals(c1, c2);
			assertEquals(c1.getName(),c2.getName());
			assertEquals(c1.getNif(),c2.getNif());
			assertNotEquals(c1.getOffice(),c2.getOffice());
			assertEquals(c1.getOffice().getLatitude(),c2.getOffice().getLatitude());
			assertEquals(c1.getOffice().getLongitude(),c2.getOffice().getLongitude());
			assertNotEquals(c1.getCeo(),c2.getCeo());
			assertEquals(c1.getCeo().getname(),c2.getCeo().getname());
		} catch (CloneNotSupportedException e) {		
			e.printStackTrace();
			fail("test1 failed");
		}
	}

}
