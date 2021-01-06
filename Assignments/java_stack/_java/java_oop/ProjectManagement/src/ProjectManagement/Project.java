package ProjectManagement;

public class Project {
	private String name;
	private String description;
	private Double initialCost = 0.0;
	
	public Project() {
	}
	public Project(String name) {
		this.name = name;
	}
	public Project(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String elevatorPitch() {
		return String.format("%s ($%.2f): %s", getName(), getCost(), getDescription());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getCost() {
		return initialCost;
	}
	public void setCost(Double initialCost) {
		this.initialCost = initialCost;
	}
}