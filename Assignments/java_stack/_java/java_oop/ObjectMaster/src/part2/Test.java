package part2;

import part1.Human;

public class Test {

	public static void main(String[] args) {
		// Team 1
		Samurai samurai1Team1 = new Samurai();
		Ninja ninja1Team1 = new Ninja();
		
		
		// Team 2
		Samurai samurai1Team2 = new Samurai();
		Samurai samurai2Team2 = new Samurai();
		Wizard w1Team2 = new Wizard();
		
		ninja1Team1.steal(w1Team2);
		ninja1Team1.steal(w1Team2);
		ninja1Team1.steal(w1Team2);
		ninja1Team1.runAway();
		samurai1Team1.deathBlow(samurai2Team2);
		
		
		w1Team2.heal(samurai1Team2);
		w1Team2.fireball(samurai1Team1);
		
		
		System.out.println("Team1");
		samurai1Team1.stat();
		ninja1Team1.stat();
		
		System.out.println("Team2");
		w1Team2.stat();
		samurai1Team2.stat();
		samurai2Team2.stat();
		
		
		System.out.println("Total number of Samurai is " +Samurai.howMany());
		
	}

}
