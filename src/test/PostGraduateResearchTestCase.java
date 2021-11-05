//$Id$
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.entities.PostGraduateResearch;

class PostGraduateResearchTestCase {

	@Test
	void test() {
		PostGraduateResearch pgr = new PostGraduateResearch("FirstName", "LastName", 24, "Supervisor1");
		
		assertEquals("FirstName", pgr.getFirstName());
		assertEquals("LastName", pgr.getLastName());
		assertEquals("FirstName LastName", pgr.getFullName());
		assertEquals(24, pgr.getAge());
		assertEquals("Supervisor1", pgr.getSupervisorName());
		
		pgr.assignSupervisor("Superviosr2");
		
		assertEquals("Supervisor2", pgr.getSupervisorName());
		
		String returnValue = "Student Name : FirstName LastName\n"
				+ "Student Id : PGR1000\n"
				+ "Student Type : PGR\n"
				+ "Student Age : 23\n"
				+ "Supervisor Name : Supervisor2";
		
		assertEquals(returnValue, pgr.toString());
	}

}
