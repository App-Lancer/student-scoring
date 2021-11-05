//$Id$
package main.entities;

import java.util.Calendar;

import main.util.CommonUtil;

final public class SmartCardNumber {
	
	private final String nameShortForm;
	private final int year;
	private final int serialNo;
	
	public SmartCardNumber(StudentClass student) {
		String firstName = student.getFirstName();
		String lastName = student.getLastName();
		
		String nameShortForm = firstName.charAt(0)+ ""+  lastName.charAt(0);
		nameShortForm = nameShortForm.toUpperCase();
		this.nameShortForm = nameShortForm;
		this.year = Calendar.getInstance().get(Calendar.YEAR);
		this.serialNo = CommonUtil.getNextSmartCardNo(Calendar.getInstance().get(Calendar.YEAR));
	}
	
	public String getShortName() {
		return this.nameShortForm;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public int getSerialNumber() {
		return this.serialNo;
	}
	
	@Override
	public String toString() {
		return this.getShortName() + "-" + this.getYear() + "-" + this.getSerialNumber();
	}

}
