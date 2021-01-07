package mammal;

public class Gorilla extends Mammal {
	
	public Gorilla () {
		super();
	}
	
	public void eatBananas() {
		super.setEnergyLevel(super.displayEnergy() + 10);
	}
	
	public void climb(){
		super.setEnergyLevel(super.displayEnergy() - 10);
	}
	public void throwSomething() {
		super.setEnergyLevel(super.displayEnergy() - 5);
	}
}
