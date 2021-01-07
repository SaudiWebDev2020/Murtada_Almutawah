package part2;

import part1.Human;

public class Ninja extends Human {

	public Ninja() {
		// TODO Auto-generated constructor stub
		super();
		super.setStealth(10);
	}
	
	public void steal(Human stolenHuman){
		this.setHealth(getHealth() + this.getStealth());
		stolenHuman.setHealth(stolenHuman.getHealth() - this.getStealth());
	}
	
	public void runAway(){
		this.setHealth(getHealth() - 10);
	}

}
