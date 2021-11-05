//$Id$
package main.entities;

final public class Name {
	
	private final String firstName;
	private final String lastName;
	
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	@Override
	public String toString() {
		return this.firstName + " " + this.lastName;
	}
}
