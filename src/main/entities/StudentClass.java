//$Id$
package main.entities;

import main.util.CommonUtil;

public class StudentClass implements Student{
	
	protected final Name name;
	
	protected final StudentId studentId;
	
	protected final int age;
	
	protected final String studentType;
	
	protected int totalCredits;
	
	public StudentClass(String firstName, String lastName, int age, String studentType, int totalCredits) {
		
		this.name = new Name(firstName, lastName);
		this.age = age;
		this.studentType = studentType;
		int studentSerialNo = CommonUtil.getNextStudentId(studentType);
		this.studentId = new StudentId(studentType, studentSerialNo);
		this.totalCredits = totalCredits;
	}
	
	public String getFirstName() {
		return this.name.getFirstName();
	}
	
	public String getLastName() {
		return this.name.getLastName();
	}
	
	public String getFullName() {
		return this.name.toString();
	}
	
	public int getAge() {
		return age;
	}
	
	public String getStudentId() {
		return studentId.toString();
	}
	
	public String getStudentType() {
		return studentType;
	}
	
	public int getTotalCreidts() {
		return this.totalCredits;
	}
	
	@Override
	public boolean equals(Object obj2) {
		if(obj2 == null) {
			return false;
		}
		
		if(!(obj2 instanceof UnderGraduate)) {
			return false;
		}
		
		StudentClass ug = (StudentClass) obj2;
		return this.studentId.equals(ug.studentId);
	}
	

	@Override
	public boolean isRegisteredForValidCreds() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override 
	public String toString() {
		return "Student Name : "+ this.name.toString() +"\n"
				+ "Student Id : "+ this.studentId.toString() +"\n"
				+ "Student Type : "+ this.studentType +"\n"
				+ "Student Age : "+ this.age + "\n";
	}

	@Override
	public String listRegisteredModules() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStudent(Object data) {
		// TODO Auto-generated method stub
		
	}
}
