//$Id$
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.entities.StudentId;

class StudentIdTestCase {

	@Test
	void test() {
		StudentId studentId = new StudentId("UG", 1234);
		
		assertEquals("UG", studentId.getIdType());
		assertEquals(1234, studentId.getId());
		assertEquals("UG1234", studentId.toString());
	}

}
