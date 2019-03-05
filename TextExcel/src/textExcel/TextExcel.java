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
    	System.out.print("Welcome to the TextExcel\nPlease enter expression to evaluate or type \"quit\" to exit TextExcel: ");
    	String command = userInput.nextLine();
    	while (command.contentEquals("quit") == false) {
    		//System.out.println(processcommand(command));
    		System.out.print("Please enter expression to evaluate or type \"quit\" to exit Frac Calc: ");
    		command = userInput.nextLine();
    	}
	}
}
