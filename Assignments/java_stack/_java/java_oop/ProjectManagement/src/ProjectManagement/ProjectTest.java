package ProjectManagement;

public class ProjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Project project1 = new Project();
		Project project2 = new Project("Banking System");
		Project project3 = new Project("Todo Apps", "Developming todo App");
	
		System.out.println(project1.elevatorPitch());
		System.out.println(project2.elevatorPitch());
		System.out.println(project3.elevatorPitch());
		
		project3.setCost(100.0);
		
		Portfolio portfolio = new Portfolio();
		portfolio.addProject(project1);
		portfolio.addProject(project2);
		portfolio.addProject(project3);
		
		System.out.println(portfolio.showPortfolio());
		System.out.println("The cost of the portfolio is $"+portfolio.getPortfolioCost());
		
	}

}
