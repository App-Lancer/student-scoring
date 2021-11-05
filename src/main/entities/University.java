//$Id$
package main.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import main.util.CommonUtil;

public class University {
	
	List<Module> module;
	
	List<StudentClass> students;
	
	List<String> supervisors;
	
	static University university = null;
	
	HashMap<String, ArrayList<StudentClass>> supervisorToStudent = new HashMap<String, ArrayList<StudentClass>>();
	
	
	private University(List<Module> module, List<String> supervisors) {
		this.module = module;
		this.supervisors = supervisors;
		this.students = new ArrayList<StudentClass>();
	}
	
	/**
	 * This is singleton class
	 * Only one object can be created */
	public static University getInstance(List<Module> module, List<String>  supervisors) {
		if(university == null) {
			university = new University(module, supervisors);
			return university;
		}else {
			return university;
		}
	}
	
	
	/**
	 * This method can be used to fetch the number of users of a particular type in the university
	 * @param type - we can pass the user type to get the number of users*/
	public int noOfStudents(String type) {
		if(type != null) {
			int count = 0;
		
			for(int index=0; index < this.students.size(); index++) {
				StudentClass student = this.students.get(index);
				if(type.equals(student.getStudentType())) {
					count++;
				}
			}
			
			return count;
		}else {
			System.out.println("Invalid Type");
			return 0;
		}
	}
	
	/**
	 * To remove a particular user from the list of students in the university
	 * @param  studentId - id of the student to be removed from the student list*/
	public void terminateStudent(String studentId) {
		if(studentId != null) {
			for(int index =0; index < this.students.size(); index++) {
				StudentClass student = this.students.get(index);
				
				if(studentId.equals(student.getStudentId())) {
					this.students.remove(index);
					break;
				}
			}
		}
	}
	
	/**
	 * To remove a particular user from the list of students in the university
	 * Overloaded method
	 * @param student - If the user wants to pass the studentId object to delete the user*/
	public void terminateStudent(StudentId studentId) {
		if(studentId != null) {
			terminateStudent(studentId.toString());
		}
	}
	
	/**
	 * To add a new student into the university
	 * @param firstName - first name of the student
	 * @param lastname - last name of the student
	 * @param age - age of the student
	 * @param studentType - Type of student
	 * @param registeredModules - List of registered modules
	 * @param suprvisorname - Supervisor name of the student
	 * @param moduleScores - Score of different modules of the student*/
	public void registerStudentData(String firstName, String lastName, int age, String studentType, List<Module> registeredModules, String supervisorName, List<ModuleScore> moduleScores) {
		StudentClass newStudent = CommonUtil.createStudentObject(firstName, lastName, age, studentType, registeredModules, supervisorName, moduleScores);
		this.students.add(newStudent);
		
		if(newStudent instanceof PostGraduateResearch) {
			PostGraduateResearch pGR = (PostGraduateResearch) newStudent;
			String supervisor = pGR.getSupervisorName();
			
			if(supervisors.indexOf(supervisor) != -1) {
				if(supervisorToStudent.containsKey(supervisor)) {
					ArrayList<StudentClass> studentClass = supervisorToStudent.get(supervisor);
					studentClass.add(newStudent);
				}else {
					ArrayList<StudentClass> studentList = new ArrayList<StudentClass>();
					studentList.add(newStudent);
					supervisorToStudent.put(supervisor, studentList);
				}
			}
		}
	}
	
	/**
	 * To update the student data
	 * @param data - data to be updated for the user
	 * @param studentId - id of the student to update the data*/
	public void amendStudentData(String studentId, Object data) {
		if(studentId != null) {
			for(int index=0; index < this.students.size(); index++) {
				StudentClass student = this.students.get(index);
				
				if(studentId.equals(student.getStudentId())) {
					student.updateStudent(data);
					break;
				}
			}
		}
	}
	
	/**
	 * To update the student data
	 * @param studentid - studentId of the user to update the data
	 * @param data - */
	public void amedStudentData(StudentId studentId, Object data) {
		if(studentId != null) {
			amendStudentData(studentId.toString(), data);
		}
	}
	
	

}
