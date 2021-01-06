package ProjectManagement;

import java.util.ArrayList;

public class Portfolio {
	ArrayList<Project> projects;
	
	public Portfolio() {
		projects = new ArrayList<Project>();	
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}
	
	public void addProject(Project project) {
		projects.add(project);
	}
	
	public double getPortfolioCost() {
		double sum = 0.0;
		
		for(int i=0;i<this.projects.size();i++) {
			sum += projects.get(i).getCost();
		}
		
		return sum;
		
	}
	
	public String showPortfolio() {
		String res = "[";
		
		for(int i=0;i<this.projects.size();i++) {
			res += String.format("%s with total cost = $%.2f",projects.get(i).getName(),projects.get(i).getCost());
			if(i<this.projects.size()-1) {
				res += ", ";
			}
		}
		
		return res + "]";
	}
}
