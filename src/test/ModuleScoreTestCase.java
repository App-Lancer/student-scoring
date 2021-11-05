//$Id$
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.entities.Module;
import main.entities.ModuleScore;

class ModuleScoreTestCase {

	@Test
	void test() {
		
		Module module = new Module("Advanced Programming", "CSC8404", 10);
		
		ModuleScore moduleScore = new ModuleScore(module, 100, 50);
		
		assertEquals(module, moduleScore.getModule());
		
		assertEquals(100, moduleScore.getTotalMarks());
		
		assertEquals(50, moduleScore.getMarksScored());
		
		assertEquals(50, moduleScore.getPercentage());
		
		String returnValue = "Module Name : Advanced Programming\n"
				+ "Module Code : CSC8404\n"
				+ "Credits : 10\n"
				+ "Total Marks : 100\n"
				+ "Marks Scored : 50\n";
		
		assertEquals(returnValue, moduleScore.toString());
	}

}
