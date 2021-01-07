package part2;

import part1.Human;

public class Samurai extends Human {
	
	protected static int counterOfSamurai = 0;
	

	public Samurai() {
		// TODO Auto-generated constructor stub
		super();
		this.setHealth(200);
		counterOfSamurai++;
	}
	
	public void deathBlow(Human deadHuman){
		deadHuman.setHealth(0);
		int halfOfHealth = (int) getHealth()/2;
		this.setHealth(halfOfHealth);
	}
	
	public void meditate() {
		int halfOfHealth = (int) getHealth()/2;
		this.setHealth(this.getHealth() + halfOfHealth);
	}
	
	public static int howMany() {
		return counterOfSamurai;
	}

}
