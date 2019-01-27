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
			System.out.println("Change sign");
			//numerator = (absValue(Integer.parseInt(op.substring((underscoreIndex + 1), dashIndex))) * -1);
		}
		else sign = 1;
    	toImproperFrac(); 
    }
	public Fraction() {
		numerator = 0;
		denominator = 1;
		whole = 0;
		sign = 0;
		fracStr = "";				
	}
	public void toImproperFrac() { //needs to be worked
    	whole = absValue(whole);
    	numerator = whole * denominator + numerator;
    	if (sign == -1) {
    		numerator = absValue(numerator) * -1;
    	}
    	whole = 0;
	}
	public static Fraction reduce(Fraction answer) {
    	int gcf = gcf(answer.getNumer(), answer.getDenom());
    	if (gcf == 0 || gcf == 1) {
    		return(answer);
    	}
    	answer.setNumer(answer.getNumer() / gcf);
    	answer.setDenom(answer.getDenom() / gcf);
    	if (answer.getNumer()/answer.getDenom() == 1) {
    		answer.setNumer(absValue(answer.getNumer()));
    		answer.setDenom(absValue(answer.getDenom()));
    	}
    	return answer;
    }
	public void negativeChecker() {
  		if ((numerator * denominator) > 0) {
  			numerator = absValue(numerator);
  		}
  		else if ((numerator * denominator) < 0){
  			numerator = absValue(numerator) * -1;
  		}
  		denominator = absValue(denominator);
  	}
	public void toMixed() {
    	String answer = "";
    	int numerator = absValue(this.numerator);
    	int denominator = this.denominator;
    	int integer = 0;
    	if (numerator > denominator) {
    		integer = (numerator/denominator);
    		if (this.numerator < 0) integer = integer * -1;
    		if (denominator == 1) {
    			numerator = 0;
    			denominator = 0;
    		}
    		else numerator = numerator % denominator;
    	}
    	else if (denominator == 1) {
    		integer = numerator;
    		numerator = 0;
    		denominator = 0;
    	}
    	else {
    		if (this.numerator < 0) numerator = numerator * -1;
    	}
    	if (integer != 0) answer = (answer + integer);
    	if (integer != 0 && numerator != 0) answer = (answer + "_");
    	if (numerator != 0) answer = (answer + numerator + "/" + denominator);
    	if (answer.length() == 0) answer = "0"; 
    	fracStr = answer;
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
		answer.printFields();
		return (answer);		
	}
	public Fraction multiply(Fraction operand1, Fraction operand2) {
    	Fraction product = new Fraction();
    	product.setNumer(operand1.getNumer() * operand2.getNumer());
    	product.setDenom(operand1.getDenom() * operand2.getDenom()); 
    	return product;
    }
    public Fraction divide(Fraction operand1, Fraction operand2) {
    	Fraction quotient = new Fraction();
    	quotient.setNumer(operand1.getNumer() * operand2.getDenom());
    	quotient.setDenom(operand1.getDenom() * operand2.getNumer());
    	return quotient;
    }
    public Fraction subtract(Fraction operand1, Fraction operand2) {
    	Fraction difference = new Fraction();
    	if (operand1.getDenom() != operand2.getDenom()) {
    		int oper1Denom = operand1.getDenom();
        	int oper2Denom = operand2.getDenom();
          	operand1.setNumer(operand1.getNumer() * oper2Denom);
    		operand1.setDenom(operand1.getDenom() * oper2Denom);
    		operand2.setNumer(operand2.getNumer() * oper1Denom);
    		operand2.setDenom(operand2.getDenom() * oper1Denom);
    	}
    	difference.setNumer(operand1.getNumer() - operand2.getNumer());
    	difference.setDenom(operand2.getDenom());
    	return difference;
    }
    public Fraction add(Fraction operand1, Fraction operand2) {
    	Fraction sum = new Fraction();
    	if (operand1.getDenom() != operand2.getDenom()) {
    		int oper1Denom = operand1.getDenom();
        	int oper2Denom = operand2.getDenom();
    		operand1.setDenom(operand1.getDenom() * oper2Denom);
    		operand1.setNumer(operand1.getNumer() * oper2Denom);
    		operand2.setDenom(operand2.getDenom() * oper1Denom);
    		operand2.setNumer(operand2.getNumer() * oper1Denom);
    	}
    	sum.setNumer(operand1.getNumer() + operand2.getNumer());
    	sum.setDenom(operand2.getDenom());
    	return sum;
    }
    public int getNumer() {
    	return(numerator);
    }
    public void setNumer(int numer) {
    	numerator = numer;
    }
    public int getDenom() {
    	return(denominator);
    }
    public void setDenom(int denom) {
    	denominator = denom;
    }
    public String getFracStr() {
    	return fracStr;
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
    public static int gcf(int number1, int number2) {
		number1 = (int) (absValue(number1));
		number2 = (int) (absValue(number2));
		if (number1 == 0 || number2 == 0) {
			return 0;
		}
		int lownum = (int) (min((double) number1, (double) number2));
		int highnum = (int) (max(number1,number2));
		int factor = lownum;
		boolean factorable = (isDivisibleBy(highnum,factor));
		while (factorable == false) {
			factor--;
			factorable = (isDivisibleBy(highnum, factor) && (isDivisibleBy(lownum, factor)));
		}
		return (factor);
	}
    public static double max(double number1, double number2) {
		if (number1 > number2) {
			return (number1);
		}
		else /*if (number1 < number2)*/ {
			return (number2);					
		}
	}
    public static double min(double number1, double number2) {
  		if (number1 < number2) {
  			return (number1);
  		}
  		else return (number2);
  	}
  	public static boolean isDivisibleBy(int number1, int number2) {
  		if (number2 == 0) {
  			throw new IllegalArgumentException ("Sorry, numbers cannot be divided by 0. Please enter a positive integer.");
  		}
  		boolean test = number1 % number2 == 0;
  		return test;
  	}
}
