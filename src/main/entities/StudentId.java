//$Id$
package main.entities;

final public class StudentId {

	private final String idType;
	private final int id;
	
	
	public StudentId(String idType, int id) {
		this.idType = idType;
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return this.idType + this.id;
	}
	
	public String getIdType() {
		return this.getIdType();
	}
	
	public int getId() {
		return this.getId();
	}

	
	@Override
	public boolean equals(Object obj2) {
		if(obj2 == null) {
			return false;
		}
		
		if(this == obj2) {
			return true;
		}
		
		if(!(obj2 instanceof StudentId)) {
			return false;
		}
		
		StudentId studId = (StudentId) obj2;
		return this.idType.equals(studId.getIdType()) && this.id == studId.getId();
	}
}
