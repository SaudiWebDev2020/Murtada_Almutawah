package mammal;

public class Mammal {
	private int energyLevel;
	private static int defaultEnergyLevel = 100;
	public Mammal() {
		setEnergyLevel(defaultEnergyLevel);
	}
	
	
	public int displayEnergy() {
		System.out.println("The energy level is " + energyLevel);
		return energyLevel;
	}
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
}
