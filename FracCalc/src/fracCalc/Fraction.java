package fracCalc;
import java.util.*;

public class Fraction {
	private int numerator;
	private int denominator;
	private int whole;
	private int sign; //may not be necessary
	private String fracStr;
	
	public Fraction (String op) { //Constructs Object & converts String to int
		fracStr = op;
		int underscoreIndex = op.indexOf("_");
		int negativeIndex = op.indexOf("-");
    	int dashIndex = op.indexOf("/");
    	//Assigning Num and Dem
    	if (dashIndex == -1) { //No fraction
    		whole = 0;
    		numerator = 0;
    		denominator = 1;
    	}
    	else { //Has fraction
    		numerator = Integer.parseInt(op.substring((underscoreIndex + 1), dashIndex));
    		denominator = Integer.parseInt(op.substring((dashIndex + 1), op.length()));
    	} 
    	//Setting Whole Number
    	if (underscoreIndex > 0 && dashIndex > 0) { //Mixed Num
    		whole = Integer.parseInt(op.substring(0, underscoreIndex));
    	}
    	else if (underscoreIndex == -1 && dashIndex == -1) { //Just Whole Number
    		whole = Integer.parseInt(op.substring(0, op.length()));
    	}
    	
    	else { //Only fraction no whole number
    		whole = 0;
		}
    	//Determining Sign
    	if (negativeIndex > -1) {
			sign = -1;
		}
		else sign = 1;
    	toImproperFrac(); 
    }
	public Fraction() {
		numerator = 0;
		denominator = 1;
		whole = 0;
		sign = 1;
		fracStr = "";				
	}
	public void toImproperFrac() { //needs to be worked
    	whole = absValue(whole);
    	numerator = whole * denominator + numerator;
    	if (sign == -1) {
    		numerator = numerator * -1;
    	}
    	whole = 0;
	}
	public Fraction doMath(String operator,Fraction operand1, Fraction operand2) {
		Fraction answer = new Fraction();
		if (operator.equals("*") == true) {
        	answer = reduce(multiply(operand1,operand2));
        }
        else if (operator.equals("/") == true) {
        	answer = reduce(divide(operand1,operand2));
        }
        else if (operator.equals("+") == true) {
        	answer = reduce(add(operand1,operand2));
        }
        else if (operator.equals("-") == true) {
        	answer = reduce(subtract(operand1,operand2));
        }
		return (answer);		
	}
	public Fraction multiply(int[] operand1, int[] operand2) {
    	Fraction product = new Fraction();
    	product = operand1.numerator * operand2[0];
    	product = operand1[1] * operand2[1];
    	return product;
    }
    public Fraction divide(int[] operand1, int[] operand2) {
    	Fraction quotient = new Fraction();
    	quotient = operand1[0] * operand2[1];
    	quotient = operand1[1] * operand2[0];
    	return quotient;
    }
	public void printFields() {
		System.out.println("numerator: " + numerator);
		System.out.println("denominator: " + denominator);
		System.out.println("whole num: " + whole);
		System.out.println("sign: " + sign);
		System.out.println("fracStr: " + fracStr + "\n");
	}
	public static int absValue(int number) {
  		if (number < 0 ) {
  			return (number *-1);
  		}
  		else return (number);
  	}

}
