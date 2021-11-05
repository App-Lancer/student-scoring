//$Id$
package main.entities;

public class ModuleScore {
	
	private final Module module;
	private final int totalMarks;
	private int marksScored;
	
	public ModuleScore(Module module, int totalMarks, int marksScored) {
		this.module = module;
		this.totalMarks = totalMarks;
		this.marksScored = marksScored;
	}
	
	public Module getModule() {
		return this.module;
	}
	
	public int getTotalMarks() {
		return this.totalMarks;
	}
	
	public int getMarksScored() {
		return this.marksScored;
	}
	
	public void setMarksScored(int marksScored) {
		this.marksScored = marksScored;
	}
	
	public float getPercentage() {
		return ((this.marksScored / this.totalMarks) * 100);
	}
	
	
	@Override
	public boolean equals(Object obj2) {
		if(obj2 == null) {
			return false;
		}
		
		if(this == obj2) {
			return true;
		}
		
		if(!(obj2 instanceof ModuleScore)) {
			return false;
		}
		
		ModuleScore moduleObj2 = (ModuleScore) obj2;
		
		return this.module.equals(moduleObj2.module);
	}
	
	@Override
	public String toString() {
		String returnValue = this.module.toString();
		
		returnValue += "Total Marks : "+ this.totalMarks +"\n"
						+ "Marks Scored : " + this.marksScored+ "\n";
		
		return returnValue;
	}
	
	

}
