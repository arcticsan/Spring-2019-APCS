/*Bryan Chan
 *28 Jan 2019
 * Fraction Calculator using Object Class Fraction
 * V 1.0
 */
package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner userInput = new Scanner(System.in);
    	System.out.print("Welcome to the Frac Calc\nPlease enter expression to evaluate or type \"quit\" to exit Frac Calc: ");
    	String fracString = userInput.nextLine();
    	while (fracString.contentEquals("quit") == false) {
    		System.out.println(produceAnswer(fracString));
    		System.out.print("Please enter expression to evaluate or type \"quit\" to exit Frac Calc: ");
    		fracString = userInput.nextLine();
    	}
    }
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	String[] splitEqua = input.split(" "); 
        String operator = splitEqua[1];
        Fraction operand1 = new Fraction(splitEqua[0]);
        Fraction operand2 = new Fraction(splitEqua[2]);
        Fraction answer = new Fraction();
        answer = answer.doMath(operator, operand1, operand2);
        return answer.getFracStr();
    }
}
