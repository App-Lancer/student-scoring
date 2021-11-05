//$Id$
package main.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import main.entities.Module;
import main.entities.ModuleScore;
import main.entities.PostGraduateResearch;
import main.entities.PostGraduateTaught;
import main.entities.StudentClass;
import main.entities.UnderGraduate;
import main.entities.University;

public class CommonUtil {
	
	public static HashMap<Integer, Integer> smartCardYearToId = new HashMap<Integer, Integer>();
	
	public static HashMap<String, Integer> studentTypeToId = new HashMap<String, Integer>();
	
	public static String moduleFileName = "module.txt";		//Update module file path
	
	public static String supervisorsFileName = "supervisors.txt";	//Update supervisors file path
	
	static {
		studentTypeToId.put("UG", 1000);
		studentTypeToId.put("PGT", 1000);
		studentTypeToId.put("PGR", 1000);
	}
	
	/**
	 * To read the text files and create object of Modules and supervisors of the university*/
	public static void init() {
		ArrayList<Module> module = readModulesFromFile();
		ArrayList<String> supervisors = readSupervisorsFromFile();
		
		University.getInstance(module, supervisors);
	}
	
	/**
	 * File to read supervisors file and add the supervisor data in a array list*/
	public static ArrayList<String> readSupervisorsFromFile(){
		try {
			File file = new File(supervisorsFileName);
			ArrayList<String> supervisors = new ArrayList<String>();
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			String tempString;
			
			while((tempString = br.readLine()) != null) {
				supervisors.add(tempString);
			}
			
			br.close();
			
			return supervisors;
		}catch(Exception ex) {
			System.out.println("Exception while reading modules from file");
			return null;
		}
	}
	
	/**
	 * File to read module file and create objects of the module data*/
	public static ArrayList<Module> readModulesFromFile(){
		try {
			File file = new File(moduleFileName);
			ArrayList<Module> moduleList = new ArrayList<Module>();
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String tempString;
			while((tempString = br.readLine()) != null) {
				String[] moduleValues = tempString.split(",");
				Module module = new Module(moduleValues[1], moduleValues[0], Integer.parseInt(moduleValues[2]));
				
				moduleList.add(module);
			}
			
			br.close();
			
			return moduleList;
			
		}catch(Exception ex) {
			System.out.println("Exeption while reading modules from file");
			return null;
		}
		
	}
	
	/**
	 * Top calculate the total credits of the passed in modules
	 * @param registeredModules - list of modules*/
	public static int getTotalCredits(List<Module> registeredModules) {
		int total = 0;
		
		if(registeredModules != null) {
			for(int i=0; i<registeredModules.size(); i++) {
				Module module = registeredModules.get(i);
				total += module.getCreds();
			}
		}
		
		return total;
	}
	
	/**
	 * To create a student object based on the input data passed in
	 * The method is a implementation of factory design patter
	 * @param firstName - student first name
	 * @param lastName - student last name
	 * @param age - age of the student
	 * @param studentType - type of the student
	 * @param registeredModuels - list of registered modules
	 * @param supervisorName - Supervisor name
	 * @param modulescores - scores of modules of the student*/
	public static StudentClass createStudentObject(String firstName, String lastName, int age, String studentType, List<Module> registeredModules, String supervisorName, List<ModuleScore> moduleScores) {
		
		int totalCredits = getTotalCredits(registeredModules);
		
		StudentClass student = null;
		if("UG".equals(studentType)) {
			student = new UnderGraduate(firstName, lastName, age, registeredModules, totalCredits, moduleScores);
		}else if("PGT".equals(studentType)) {
			student = new PostGraduateTaught(firstName, lastName, age, registeredModules, totalCredits, moduleScores);
		}else if("PGR".equals(studentType)) {
			student = new PostGraduateResearch(firstName, lastName, age, supervisorName);
		}
		
		return student;
	}
	
	/**
	 * To get the next serial number of a specific year for smar card number
	 * @param year - year to which generate the number*/
	public static int getNextSmartCardNo(int year) {
		if(smartCardYearToId.containsKey(year)) {
			int value = smartCardYearToId.get(year);
			smartCardYearToId.put(year, value + 1);
			return value;
		}else {
			smartCardYearToId.put(year, 2);
			return 1;
		}
	}
	
	/**
	 * To get the next number of student id to autogenerate the student id
	 * @param studentType - type of student to get the next number*/
	public static int getNextStudentId(String studentType) {
		if(studentTypeToId.containsKey(studentType)) {
			int value = studentTypeToId.get(studentType);
			studentTypeToId.put(studentType, value+1);
			return value;
		}
		
		return 0;
	}
	
	/**
	 * To calculate the expiry date
	 * @param currentDate - date to which expiry date to be calculated
	 * @param student - student object to calculate the expriy period*/
	public static Date getExpiryDate(Date currentDate, StudentClass student) {
		int year = currentDate.getYear();
		
		if("UG".equals(student.getStudentType())) {
			currentDate.setYear(year + 4);
		}else if("PGT".equals(student.getStudentType())) {
			currentDate.setYear(year + 2);
		}else if("PGR".equals(student.getStudentType())) {
			currentDate.setYear(year + 5);
		}
		
		return currentDate;
	}

}
