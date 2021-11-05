//$Id$
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.entities.Module;
import main.entities.ModuleScore;
import main.entities.SmartCard;
import main.entities.UnderGraduate;

class SmartCardTestCase {

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
		
		SmartCard sc = SmartCard.getInstance(ug, new Date("01-Jan-1990"));
		if(sc != null) {
			assertEquals("FirstName LastName", sc.getStudentName());
			assertEquals(new Date().getYear(), sc.getDateOfIssue().getYear());
			assertEquals(new Date().getYear() + 4, sc.getExpiryDate().getYear());
			
		}
	}

}
