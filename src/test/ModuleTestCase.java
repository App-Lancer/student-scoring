//$Id$
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.entities.Module;

class ModuleTestCase {

	@Test
	void test() {
		Module module = new Module("Advanced Programming", "CSC8404", 10);
		
		String toStringAssertValue = "Module Name : Advanced Programming\n"
				+ "Module Code : CSC8404\n"
				+ "Credits : 10\n";
		
		assertEquals(toStringAssertValue, module.toString());
		
		assertEquals("Advanced Programming", module.getName());
		
		assertEquals("CSC8404", module.getModuleCode());
		
		assertEquals(10, module.getCreds());
		
		Module module2 = new Module("Test Module", "TS1011", 5);
		
		assertEquals(module, module2);
	}

}
