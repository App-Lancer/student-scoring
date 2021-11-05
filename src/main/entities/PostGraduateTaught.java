//$Id$
package main.entities;

import java.util.ArrayList;
import java.util.List;

public class PostGraduateTaught extends StudentClass{
	
	private List<Module> registeredModules;
	
	private List<ModuleScore> moduleScores;
	
	public PostGraduateTaught(String firstName, String lastName, int age, List<Module> registeredModules, int totalCredits, List<ModuleScore> moduleScores) {
		super(firstName, lastName, age, "PGT", totalCredits);
		List<Module> tempModules = new ArrayList<Module>();
		
		for(int i=0; i<registeredModules.size(); i++) {
			tempModules.add(registeredModules.get(i));
		}
		this.registeredModules = tempModules;
		
		if(this.moduleScores != null) {
			this.moduleScores = moduleScores;
		}else {
			this.moduleScores = new ArrayList<ModuleScore>();
		}
	}
	
	public List<ModuleScore> getModuleScores(){
		return this.moduleScores;
	}
	
	public void updateScores(List<ModuleScore> moduleScores) {
		this.moduleScores = moduleScores;
	}
	
	private boolean isModuleRegistered(Module module) {
		boolean isModuleRegistered = false;
		
		for(int i=0; i<this.registeredModules.size(); i++) {
			Module tempModule = this.registeredModules.get(i);
			
			if(tempModule.equals(module)) {
				isModuleRegistered = true;
				break;
			}
		}
		
		return isModuleRegistered;
	}
	
	public void addModuleScore(ModuleScore moduleScore) {
		
		if(isModuleRegistered(moduleScore.getModule())) {
			
			for(int i=0; i < this.moduleScores.size(); i++) {
				ModuleScore tempScore = this.moduleScores.get(i);
				
				if(tempScore.getModule().equals(moduleScore.getModule())) {
					this.moduleScores.remove(i);
					i--;
				}
			}
			
			this.moduleScores.add(moduleScore);
		}
	}
	
	public boolean isPassed() {
		
		boolean passed = true;
		
		for(int i=0; i<this.moduleScores.size(); i++) {
			ModuleScore tempModuleScore = this.moduleScores.get(i);
			
			if(50 < tempModuleScore.getPercentage()) {
				passed = false;
				break;
			}
		}
		
		return passed;
	}
	
	public List<ModuleScore> getFailedModules(){
		List<ModuleScore> failedModules = new ArrayList<ModuleScore>();
		
		for(int i=0; i<this.moduleScores.size(); i++) {
			ModuleScore tempModuleScore = this.moduleScores.get(i);
			
			if(50 < tempModuleScore.getPercentage()) {
				failedModules.add(tempModuleScore);
			}
		}
		
		return failedModules;
	}
	
	public List<Module> getRegisteredModules(){
		return this.registeredModules;
	}
	
	public void registerNewModule(Module module) {
		this.totalCredits += module.getCreds();
		this.registeredModules.add(module);
	}
	
	public void updateStudent(Object data) {
		if(data != null && data instanceof List) {
			List<Module> moduleList = (List<Module>) data;
			int credits = 0;
			List<Module> deepCopyModule = new ArrayList<Module>();
			
			for(int index=0; index < moduleList.size(); index++) {
				Module module = moduleList.get(index);
				credits += module.getCreds();
				deepCopyModule.add(module);
			}
			this.totalCredits = credits;
			this.registeredModules = deepCopyModule;
			
		}
	}
	
	@Override
	public boolean isRegisteredForValidCreds() {
		if(this.totalCredits == 180) {
			return true;
		}
		
		return false;
	}
	
	public String listRegisteredModules() {
		String returnValue = "";
		
		for(int i=0; i<this.registeredModules.size(); i++) {
			Module module = this.registeredModules.get(i);
			returnValue += "Module Name : "+ module.getName() +"\t Module Code : "+ module.getModuleCode() +"\t Module Credits : "+ module.getCreds() +"\n";
		}
		
		return returnValue;
	}
	
	@Override
	public String toString() {
		String returnValue = super.toString();
		
		String moduleList  = "";
		for(int i=0; i<this.registeredModules.size(); i++) {
			Module module = this.registeredModules.get(i);
			moduleList += "Module Name : "+ module.getName() +"\t Module Code : "+ module.getModuleCode() +"\t Module Creds : "+ module.getCreds() +"\n";
		}
		
		returnValue += moduleList;
		returnValue += "Total Creds : "+ this.totalCredits +"";
		
		return returnValue;
	}
}
