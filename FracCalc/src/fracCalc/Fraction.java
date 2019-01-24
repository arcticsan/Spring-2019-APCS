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
    }
	public Fraction() {
		numerator = 0;
		denominator = 1;
		whole = 0;
		sign = 1;
		fracStr = "";				
	}
	public static void toImproperFrac() { //needs to be worked
    	int[] improperFrac = new int[2];
    	improperFrac[1] = mixedFrac[2];
    	boolean negative = false;
    	if (mixedFrac[0] < 0) {
    		mixedFrac[0] = mixedFrac[0] * -1;
    		negative = true;
    	}
    	improperFrac[0] = mixedFrac[0] * mixedFrac[2] + mixedFrac[1];
    	if (negative == true) {
    		improperFrac[0] = improperFrac[0] * -1;
    	}
	}
	public void printFields() {
		System.out.println("numerator: " + numerator);
		System.out.println("denominator: " + denominator);
		System.out.println("whole num: " + whole);
		System.out.println("sign: " + sign);
		System.out.println("fracStr: " + fracStr + "\n");
	}

}
