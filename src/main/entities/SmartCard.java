//$Id$
package main.entities;

import java.util.Calendar;
import java.util.Date;

import main.util.CommonUtil;

final public class SmartCard {
	
	private final StudentClass student;
	private final Date dob;
	private final SmartCardNumber smartCardNumber;
	private final Date dateOfIssue;
	private Date expiryDate;
	
	private SmartCard(StudentClass student, Date dob) {
		this.student = student;
		this.dob = dob;
		this.smartCardNumber = new SmartCardNumber(student);
		Date currentDate = new Date();
		this.dateOfIssue = currentDate;
		this.expiryDate = CommonUtil.getExpiryDate(currentDate, student);
	}
	
	public static SmartCard getInstance(StudentClass student, Date dob) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int dobYear = dob.getYear();
		int age = currentYear - dobYear;
		
		if("UG".equals(student.getStudentType())) {
			
			if(age > 17) {
				return new SmartCard(student, dob);
			}
		}else {
			if(age > 21) {
				return new SmartCard(student, dob);
			}
		}
		
		return null;
	}
	
	public String getStudentName() {
		return this.student.getFullName();
	}
	
	public String getStudentId() {
		return this.student.getStudentId();
	}
	
	public Date getDateOfIssue() {
		return this.dateOfIssue;
	}
	
	public Date getExpiryDate() {
		return this.expiryDate;
	}
	
	private void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
}
