package mammal;

public class Bat extends Mammal {

	public Bat() {
		super.setEnergyLevel(300);
	}

	public void attackTown() {
		// TODO Auto-generated method stub
		System.out.println("The sound of a town on fire");
		super.setEnergyLevel(super.displayEnergy() - 100);
	}

	public void eatHumans() {
		// TODO Auto-generated method stub
		System.out.println("So- well, never mind");
		super.setEnergyLevel(super.displayEnergy() + 25);
	}

	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("The sound a bat taking off ");
		super.setEnergyLevel(super.displayEnergy() - 50);
	}
	
	

}
