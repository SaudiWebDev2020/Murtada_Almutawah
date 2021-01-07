package part1;

public class HumanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human hu1 = new Human();
		Human hu2 = new Human();
		
		hu1.attack(hu2);
		hu1.attack(hu2);
		hu1.attack(hu2);
		hu1.attack(hu2);
		System.out.print("Human 1 health: "+ hu1.getHealth() + ", Human 2 health: "+hu2.getHealth());
	}

}
