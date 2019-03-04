package textExcel;
import java.util.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);
    	System.out.print("Welcome to the TextExcel\nPlease enter expression to evaluate or type \"quit\" to exit Frac Calc: ");
    	String fracString = userInput.nextLine();
    	while (fracString.contentEquals("quit") == false) {
    		System.out.println(processcommand(fracString));
    		System.out.print("Please enter expression to evaluate or type \"quit\" to exit Frac Calc: ");
    		fracString = userInput.nextLine();
    	}
	}
}
