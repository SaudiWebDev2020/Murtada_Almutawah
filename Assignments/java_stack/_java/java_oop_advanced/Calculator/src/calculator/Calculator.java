package calculator;

public class Calculator {
	
	private double operandOne;
	private String operation;
	private double operandTwo;
	private double results;
	
	
	public Calculator() {
		
	}

	public void performOperation() {
		if(operation == "+") {
			this.results = this.operandOne + this.operandTwo;
		} else if (operation == "-") {
			this.results = this.operandOne - this.operandTwo;
		}
	}
	

	public double getOperandOne() {
		return operandOne;
	}



	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}



	public String getOperation() {
		return operation;
	}



	public void setOperation(String operation) {
		this.operation = operation;
	}



	public double getOperandTwo() {
		return operandTwo;
	}



	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}



	public double getResults() {
		return results;
	}



	public void setResults(double results) {
		this.results = results;
	}
	
	
}
