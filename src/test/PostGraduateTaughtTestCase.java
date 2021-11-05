//$Id$
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.entities.Module;
import main.entities.ModuleScore;
import main.entities.PostGraduateTaught;

class PostGraduateTaughtTestCase {

	@Test
	void test() {
		Module module1 = new Module("Module1", "M1234", 60);
		Module module2 = new Module("Module2", "M2345", 60);
		Module module3 = new Module("Module3", "M3456", 60);
		
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
		
		PostGraduateTaught pgt = new PostGraduateTaught("FirstName", "LastName", 22, modules, 180, moduleScores);
		
		assertEquals("FirstName", pgt.getFirstName());
		assertEquals("LastName", pgt.getLastName());
		assertEquals("FirstName LastName", pgt.getLastName());
		assertEquals(22, pgt.getAge());
		assertEquals(modules, pgt.getRegisteredModules());
		assertEquals(moduleScores, pgt.getModuleScores());
		assertEquals(true, pgt.isPassed());
		assertEquals(true, pgt.isRegisteredForValidCreds());
		
		String returnValue = "Student Name : FirstName LastName\n"
				+ "Student Id : PGT1000\n"
				+ "Student Type : PGT\n"
				+ "Student Age : 22\n"
				+ "Module Name : Module1\t Module Code : M1234\t Module Creds : 60\n"
				+ "Module Name : Module2\t Module Code : M2345\t Module Creds : 60\n"
				+ "Module Name : Module3\t Module Code : M3456\t Module Creds : 60\n"
				+ "Total Creds : 180";
		
		assertEquals(returnValue, pgt.toString());
	}

}
