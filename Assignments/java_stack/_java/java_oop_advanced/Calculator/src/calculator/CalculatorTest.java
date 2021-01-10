package calculator;

public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c = new Calculator();
		c.setOperandOne(10.5);
		c.setOperation("+");
		c.setOperandTwo(5.2);
		c.performOperation();
		
		System.out.println(String.format("%.2f %s %.2f = %.2f", c.getOperandOne(), c.getOperation(), c.getOperandTwo() , c.getResults()));
		
		c.setOperation("-");
		c.performOperation();
		System.out.println(String.format("%.2f %s %.2f = %.2f", c.getOperandOne(), c.getOperation(), c.getOperandTwo() , c.getResults()));
		
	}
	
	

}
