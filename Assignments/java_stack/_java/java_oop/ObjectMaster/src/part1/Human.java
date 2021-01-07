package part1;

public class Human {
	private int strength;
	private int stealth;
	private int intelligence;
	private int health;
	
	public Human () {
		this.setStrength(3);
		this.setStealth(3);
		this.setIntelligence(3);
		this.setHealth(100);
	}
	
	public void attack(Human attacked) {
		attacked.setHealth(attacked.getHealth() - this.getStrength());
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getStealth() {
		return stealth;
	}

	public void setStealth(int stealth) {
		this.stealth = stealth;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	
}
