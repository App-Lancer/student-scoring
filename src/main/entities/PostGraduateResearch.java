//$Id$
package main.entities;

import java.util.ArrayList;
import java.util.List;

public class PostGraduateResearch extends StudentClass{
	
	private String supervisorName;
	
	public PostGraduateResearch(String firstName, String lastName, int age, String supervisorName) {
		super(firstName, lastName, age, "PGR", 0);
		this.supervisorName = supervisorName;
	}
	
	public String getSupervisorName() {
		return this.supervisorName;
	}
	
	public void assignSupervisor(String supervisorName) {
		this.supervisorName = supervisorName;
	}
	
	public String listRegisteredModules() {
		return "No Modules";
	}
	
	public void updateStudent(Object data) {
		if(data != null && data instanceof String) {
			this.supervisorName = (String) data;
		}
	}
	
	@Override
	public boolean isRegisteredForValidCreds() {
		if(this.totalCredits > 0) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		String returnValue = super.toString();
		returnValue += "Supervisor Name : "+ this.supervisorName +"\n";
		return returnValue;
	}
}
