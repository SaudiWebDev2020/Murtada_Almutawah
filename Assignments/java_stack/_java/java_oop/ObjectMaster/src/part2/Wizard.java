package part2;

import part1.Human;

public class Wizard extends Human {

	public Wizard() {
		// TODO Auto-generated constructor stub
		super();
		super.setIntelligence(8);
		super.setHealth(50);
	}
	
	public void heal(Human healedHuman) {
		healedHuman.setHealth(healedHuman.getHealth() + (this.getIntelligence()));
	}
	
	public void fireball(Human firedlHuman) {
		firedlHuman.setHealth(firedlHuman.getHealth() - (3 * this.getIntelligence()));
	}
}
