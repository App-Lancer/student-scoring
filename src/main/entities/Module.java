//$Id$
package main.entities;

/**
 * The class is the template of module entity
 * The class contains - name, moduleCode and credits*/
final public class Module {

	private final String name;
	private final String moduleCode;
	private final int credits;
	
	/**
	 * Module constructor class to create module objects*/
	public Module(String name, String moduleCode, int credits) {
		this.name = name;
		this.moduleCode = moduleCode;
		this.credits = credits;
	}
	
	/**
	 * module name getter method*/
	public String getName() {
		return name;
	}
	
	/**
	 * module code getter method*/
	public String getModuleCode() {
		return moduleCode;
	}
	
	/**
	 * module credits getter method*/
	public int getCreds() {
		return credits;
	}
	
	/**
	 * To compare to module objects.
	 * Module code will be unique for every module so we can compare the module code of two modules*/
	@Override
	public boolean equals(Object obj2) {
		
		if(obj2 == null) {
			return false;
		}
		
		if(this == obj2) {
			return true;
		}
		
		if(!(obj2 instanceof Module)) {
			return false;
		}
		
		Module m = (Module) obj2;
		
		return this.moduleCode.equals(m.moduleCode);
	}
	
	@Override
	public String toString() {
		return "Module Name : "+ this.name+ "\n"
				+ "Module Code : "+ this.moduleCode +"\n"
				+ "Credits : "+ this.credits +"\n";
		
	}
}
