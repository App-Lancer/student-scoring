//$Id$
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.entities.Module;
import main.entities.ModuleScore;
import main.entities.UnderGraduate;

class UnderGraduateTestCase {

	@Test
	void test() {
		Module module1 = new Module("Module1", "M1234", 35);
		Module module2 = new Module("Module2", "M2345", 50);
		Module module3 = new Module("Module3", "M3456", 35);
		
		List<Module> modules = new ArrayList<Module>();
		modules.add(module1);
		modules.add(module2);
		modules.add(module3);
		
		ModuleScore moduleScore1 = new ModuleScore(module1, 100, 40);
		ModuleScore moduleScore2 = new ModuleScore(module2, 60, 40);
		ModuleScore moduleScore3 = new ModuleScore(module3, 80, 50);
		
		List<ModuleScore> moduleScores = new ArrayList<ModuleScore>();
		moduleScores.add(moduleScore1);
		moduleScores.add(moduleScore2);
		moduleScores.add(moduleScore3);
		
		UnderGraduate ug = new UnderGraduate("FirstName", "LastName", 18, modules, 120, moduleScores);
		
		assertEquals("FirstName", ug.getFirstName());
		assertEquals("LastName", ug.getLastName());
		assertEquals("FirstName LastName", ug.getLastName());
		assertEquals(18, ug.getAge());
		assertEquals(modules, ug.getRegisteredModules());
		assertEquals(moduleScores, ug.getModuleScores());
		assertEquals(true, ug.isPassed());
		assertEquals(true, ug.isRegisteredForValidCreds());
		
		String returnValue = "Student Name : FirstName LastName\n"
				+ "Student Id : UG1000\n"
				+ "Student Type : UG\n"
				+ "Student Age : 18\n"
				+ "Module Name : Module1\t Module Code : M1234\t Module Creds : 35\n"
				+ "Module Name : Module2\t Module Code : M2345\t Module Creds : 50\n"
				+ "Module Name : Module3\t Module Code : M3456\t Module Creds : 35\n"
				+ "Total Creds : 120";
		
		assertEquals(returnValue, ug.toString());
		
	}

}
