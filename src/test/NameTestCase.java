//$Id$
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.entities.Name;

class NameTestCase {

	@Test
	void test() {
		Name name = new Name("FirstName", "LastName");
		
		assertEquals("FirstName", name.getFirstName());
		
		assertEquals("Lastname", name.getLastName());
		
		assetEqauls("FirstName LastName", name.toString());
	}

}
