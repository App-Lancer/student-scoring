//$Id$
package main.entities;

public interface Student {
	
	/**
	 * To check if the student is valid user*/
	public boolean isRegisteredForValidCreds();
	
	public String listRegisteredModules();
	
	public void updateStudent(Object data);

}
